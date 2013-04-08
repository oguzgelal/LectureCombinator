import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Combinator extends JFrame {


	public static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public static JList list;
	public static JList section_list;
	public static ArrayList<String> lectures = new ArrayList<String>(); // MATH 112
	public static ArrayList<String> sections = new ArrayList<String>(); // MATH 112|A(section)|Monday|10:40|12:30
	private JPanel contentPane;
	private JTextField fromTime;
	private JTextField toTime;
	private JTextPane html_output;
	ArrayList<String[]> packed;
	JComboBox fromDay;
	JComboBox toDay;
	Operations ops = new Operations();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combinator frame = new Combinator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Combinator() {
		this.setTitle("Lecture Combinator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(10, 41, 32, 16);
		contentPane.add(lblTo);

		JButton btnAddLecture = new JButton("Add Lecture");
		btnAddLecture.setBounds(6, 76, 110, 29);
		contentPane.add(btnAddLecture);
		btnAddLecture.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				AddLecture lecture_form = new AddLecture();
				lecture_form.runLecture();
			}
		});

		JButton btnAddSection = new JButton("Add Section");
		btnAddSection.setBounds(117, 76, 110, 29);
		btnAddSection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (list.getSelectedIndex() != -1){
					String str = list.getModel().getElementAt(list.getSelectedIndex()).toString().split("\\(")[0];
					str = str.substring(0,str.length()-1);
					AddSection section = new AddSection(str);
					section.runSection(str);
				}
			};
		});
		contentPane.add(btnAddSection);

		JButton combineButton = new JButton("Combine Lectures");
		combineButton.setBounds(6, 220, 226, 29);
		contentPane.add(combineButton);
		combineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				packed = packUp();
				String output = ops.unpack(packed, fromDay.getModel().getSelectedItem().toString(), toDay.getModel().getSelectedItem().toString(), fromTime.getText(), toTime.getText());
				html_output.setText(output);

				JOptionPane.showMessageDialog(contentPane,"Now, please choose where to save the output.");
				// Chose path
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File current_path = chooser.getSelectedFile();
					String path = current_path.toString();
					// create file
					File create = new File(path+"/program.html");
					int count = 1;
					while (create.exists()){
						create = new File(path+"/program("+count+").html");
						count++;
					}
					try{
						if(create.createNewFile()){
							JOptionPane.showMessageDialog(contentPane,"Program created successfully");
						}
						else{
							JOptionPane.showMessageDialog(contentPane,"Cannot save file.");
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(contentPane,"Something went wrong");
					}
					// write to file
					try{
						FileWriter fstream = new FileWriter(create.toString());
						BufferedWriter out = new BufferedWriter(fstream);
						out.write(output);
						out.close();
					}catch (Exception e){
						System.err.println("Error: " + e.getMessage());
					}
					//default title and icon

					System.exit(0);






				}
			}

		});

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(10, 13, 47, 16);
		contentPane.add(lblFrom);

		fromDay = new JComboBox(days);
		fromDay.setSelectedIndex(0);
		fromDay.setBounds(52, 9, 126, 27);
		contentPane.add(fromDay);

		toDay = new JComboBox(days);
		toDay.setSelectedIndex(4);
		toDay.setBounds(52, 37, 126, 27);
		contentPane.add(toDay);

		list = new JList();
		list.setBounds(12, 115, 126, 236);
		contentPane.add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ArrayList<String> selectedSections = new ArrayList<String>();
				selectedSections.clear();
				if (list.getSelectedIndex() != -1){
					String selectedLecture = lectures.get(list.getSelectedIndex());
					for(int i = 0; i < sections.size(); i++){
						String secname = sections.get(i).split("\\|")[0];
						if (selectedLecture.equals(secname)){
							String add = sections.get(i).split("\\|")[1] + " - ";
							int cnt = 2;
							while(true){
								try{
									add += sections.get(i).split("\\|")[cnt]+", "+sections.get(i).split("\\|")[cnt+1]+"/"+sections.get(i).split("\\|")[cnt+2]+" | ";
									cnt += 3;
								}catch(Exception e1){break;}
							}
							selectedSections.add(add);
						}
					}
					section_list.setListData(selectedSections.toArray());
				}
			}
		});
		JScrollPane scroll1 = new JScrollPane(list);
		scroll1.setBounds(12, 115, 126, 100);
		scroll1.setViewportView(list);
		contentPane.add(scroll1);

		fromTime = new JTextField();
		fromTime.setText("8:00");
		fromTime.setColumns(10);
		fromTime.setBounds(195, 35, 58, 28);
		contentPane.add(fromTime);

		toTime = new JTextField();
		toTime.setText("21:00");
		toTime.setColumns(10);
		toTime.setBounds(280, 35, 58, 28);
		contentPane.add(toTime);

		JLabel label = new JLabel("-");
		label.setBounds(262, 41, 14, 16);
		contentPane.add(label);

		JLabel lblDaysFrom = new JLabel("From - To (ex. 12:30)");
		lblDaysFrom.setBounds(198, 13, 154, 16);
		contentPane.add(lblDaysFrom);

		section_list = new JList();
		section_list.setBounds(150, 115, 188, 236);
		contentPane.add(section_list);
		JScrollPane scroll2 = new JScrollPane(section_list);
		scroll2.setBounds(150, 115, 188, 100);
		scroll2.setViewportView(section_list);
		contentPane.add(scroll2);


		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(228, 76, 110, 29);
		btnRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (section_list.getSelectedIndex() != -1){
					sections.remove(section_list.getSelectedIndex());
					ArrayList<String> hop = new ArrayList<String>();
					section_list.removeAll();
					section_list.setListData(hop.toArray());
					list.removeAll();
					list.setListData(listToArray(lectures, sections));
				}
				else if (list.getSelectedIndex() != -1){
					String lecture = lectures.get(list.getSelectedIndex()).split("\\(")[0];
					lectures.remove(list.getSelectedIndex());
					for(int i = 0; i < sections.size(); i++){
						String check = sections.get(i).split("\\|")[0];
						if (check.equals(lecture)){
							sections.set(i, "removethis");
						}
					}
					int x = 0;
					while(true){
						try{
							if (sections.get(x).equals("removethis")){
								sections.remove(x);
							}
							else{
								x++;
							}
						} catch(Exception e){break;}
					}
					list.removeAll();
					section_list.removeAll();
					list.setListData(listToArray(lectures, sections));
					ArrayList<String> hop = new ArrayList<String>();
					section_list.removeAll();
					section_list.setListData(hop.toArray());
				}
			}
		});
		contentPane.add(btnRemove);

		html_output = new JTextPane();
		html_output.setFont(new Font("Consolas", Font.PLAIN, 9));
		html_output.setBounds(9, 275, 335, 108);
		contentPane.add(html_output);

		JLabel lblHtmlOutput = new JLabel("HTML output");
		lblHtmlOutput.setBounds(19, 251, 97, 16);
		contentPane.add(lblHtmlOutput);

		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(228, 220, 117, 29);
		contentPane.add(btnHelp);

		JButton btnSaveInput = new JButton("Save Input");
		btnSaveInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane,"Now, please choose where to save the input.");
				// Chose path
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File current_path = chooser.getSelectedFile();
					String path = current_path.toString();
					// create file
					File create = new File(path+"/input.lec");
					int count = 1;
					while (create.exists()){
						create = new File(path+"/input("+count+").lec");
						count++;
					}
					try{
						if(create.createNewFile()){
							JOptionPane.showMessageDialog(contentPane,"Input file created successfully");
						}
						else{
							JOptionPane.showMessageDialog(contentPane,"Cannot save file.");
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(contentPane,"Something went wrong");
					}
					// write to file
					try{
						String[] programInterval = {fromDay.getModel().getSelectedItem().toString(),toDay.getModel().getSelectedItem().toString(),fromTime.getText(),toTime.getText()};
						packed = packUp();
						packed.add(programInterval);
						final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(create));
					    out.writeObject(packed);
					    out.flush();
					    out.close();
					}catch (Exception e){
						e.printStackTrace();
					}
				}

			}
		});

		btnSaveInput.setBounds(110, 246, 122, 29);
		contentPane.add(btnSaveInput);

		JButton btnLoadInput = new JButton("Load Input");
		btnLoadInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane,"Now, please locate the saved input file.");
				// Chose path
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Select saved input file.");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if ((chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)&&(chooser.getSelectedFile().toString().endsWith(".lec"))) {
					File selectedFile = chooser.getSelectedFile();
					String path = selectedFile.toString();
					
					ObjectInputStream in;
					try {
						in = new ObjectInputStream(new FileInputStream(selectedFile));
						ArrayList<String[]> loaded = (ArrayList<String[]>) in.readObject();
						String[] values = loaded.get(loaded.size()-1);
						loaded.remove(loaded.size()-1);
						//String output = ops.unpack(packed, fromDay.getModel().getSelectedItem().toString(), toDay.getModel().getSelectedItem().toString(), fromTime.getText(), toTime.getText());
						String output =ops.unpack(loaded, values[0],values[1],values[2],values[3]);
						html_output.setText(output);

						JOptionPane.showMessageDialog(contentPane,"Now, please choose where to save the output.");
						// Chose path
						JFileChooser chooser1 = new JFileChooser();
						chooser1.setCurrentDirectory(new java.io.File("."));
						chooser1.setDialogTitle("choosertitle");
						chooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						chooser1.setAcceptAllFileFilterUsed(false);
						if (chooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							File current_path = chooser1.getSelectedFile();
							String path1 = current_path.toString();
							// create file
							File create = new File(path1+"/program.html");
							int count = 1;
							while (create.exists()){
								create = new File(path1+"/program("+count+").html");
								count++;
							}
							try{
								if(create.createNewFile()){
									JOptionPane.showMessageDialog(contentPane,"Program created successfully");
								}
								else{
									JOptionPane.showMessageDialog(contentPane,"Cannot save file.");
								}
							}
							catch(Exception e){
								JOptionPane.showMessageDialog(contentPane,"Something went wrong");
							}
							// write to file
							try{
								FileWriter fstream = new FileWriter(create.toString());
								BufferedWriter out = new BufferedWriter(fstream);
								out.write(output);
								out.close();
							}catch (Exception e){
								System.err.println("Error: " + e.getMessage());
							}
							//default title and icon

							System.exit(0);
						
						
						
						}	
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
			}
		});
		btnLoadInput.setBounds(228, 246, 118, 29);
		contentPane.add(btnLoadInput);

	}

	public static String[] listToArray(ArrayList<String> lectures, ArrayList<String> sections){ // generate the array to write section numbers to the list
		String[] output = new String[lectures.size()];
		for(int i = 0; i < lectures.size(); i++){
			String lecture = lectures.get(i);
			int count = 0;
			for(int j = 0; j < sections.size(); j++){
				String section = sections.get(j).split("\\|")[0];
				if (lecture.equals(section)){
					count++;
				}
			}
			output[i] = lecture + " ("+count+")";
		}
		return output;
	}

	public ArrayList<String[]> packUp(){
		ArrayList<String[]> packed = new ArrayList<String[]>();
		for(int i = 0; i < lectures.size(); i++){
			String lecture = lectures.get(i);
			int count = 0;
			for(int j = 0; j < sections.size(); j++){
				String section = sections.get(j).split("\\|")[0];
				if (lecture.equals(section)){
					count++;
				}
			}
			String[] array = new String[count];
			int cnt = 0;
			for(int j = 0; j < sections.size(); j++){
				String section = sections.get(j);
				if (lecture.equals(section.split("\\|")[0])){
					array[cnt] = sections.get(j);
					cnt++;
				}
			}
			packed.add(array);
		}
		return packed;
	}
}
