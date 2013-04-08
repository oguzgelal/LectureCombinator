import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class AddSection extends JFrame {

	private JPanel contentPane;
	private JTextField section1;
	private JTextField time_from1;
	private JTextField time_to1;
	private JComboBox day1;
	private JComboBox day2;
	private JTextField section2;
	private JTextField time_from2;
	private JTextField time_to2;
	private JTextField section3;
	private JTextField section4;
	private JTextField section5;
	private JTextField section6;
	private JTextField section7;
	private JComboBox day3;
	private JTextField time_from3;
	private JTextField time_to3;
	private JComboBox day4;
	private JTextField time_from4;
	private JTextField time_to4;
	private JTextField time_to6;
	private JTextField time_to5;
	private JTextField time_from5;
	private JTextField time_from6;
	private JComboBox day6;
	private JComboBox day5;
	private JComboBox day7;
	private JTextField time_from7;
	private JTextField time_to7;

	public void runSection(final String lecture){
		try {
		    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSection frame = new AddSection(lecture);
					frame.setVisible(true);
					frame.setLocation(frame.getX()+140, frame.getY());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AddSection(final String lecture) {
		this.setTitle("Add Section(s)");
		setBounds(100, 100, 336, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(22, 6, 61, 16);
		contentPane.add(lblSection);

		section1 = new JTextField();
		section1.setBounds(22, 22, 39, 28);
		contentPane.add(section1);
		section1.setColumns(10);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(79, 6, 39, 16);
		contentPane.add(lblDay);

		day1 = new JComboBox(Combinator.days);
		day1.setBounds(73, 24, 104, 27);
		contentPane.add(day1);

		JLabel lblNewLabel = new JLabel("From\n");
		lblNewLabel.setBounds(185, 6, 110, 16);
		contentPane.add(lblNewLabel);

		time_from1 = new JTextField();
		time_from1.setBounds(185, 22, 61, 28);
		contentPane.add(time_from1);
		time_from1.setColumns(10);
		FocusListenerClass flis = new FocusListenerClass(time_from1,contentPane);
		time_from1.addFocusListener(flis);
		
		JLabel lblToex = new JLabel("To");
		lblToex.setBounds(274, 6, 87, 16);
		contentPane.add(lblToex);

		time_to1 = new JTextField();
		time_to1.setColumns(10);
		time_to1.setBounds(258, 22, 61, 28);
		contentPane.add(time_to1);
		FocusListenerClass flis2 = new FocusListenerClass(time_to1,contentPane);
		time_to1.addFocusListener(flis2);


		JButton onay = new JButton("Add Section(s)");
		onay.setBounds(6, 343, 313, 29);
		contentPane.add(onay);

		section2 = new JTextField();
		section2.setColumns(10);
		section2.setBounds(22, 67, 39, 28);
		contentPane.add(section2);

		day2 = new JComboBox(Combinator.days);
		day2.setBounds(73, 69, 104, 27);
		contentPane.add(day2);

		time_from2 = new JTextField();
		time_from2.setColumns(10);
		time_from2.setBounds(185, 67, 61, 28);
		contentPane.add(time_from2);
		FocusListenerClass flis3 = new FocusListenerClass(time_from2,contentPane);
		time_from2.addFocusListener(flis3);

		time_to2 = new JTextField();
		time_to2.setColumns(10);
		time_to2.setBounds(258, 67, 61, 28);
		contentPane.add(time_to2);
		FocusListenerClass flis4 = new FocusListenerClass(time_to2,contentPane);
		time_to2.addFocusListener(flis4);

		section3 = new JTextField();
		section3.setColumns(10);
		section3.setBounds(22, 112, 39, 28);
		contentPane.add(section3);

		section4 = new JTextField();
		section4.setColumns(10);
		section4.setBounds(22, 157, 39, 28);
		contentPane.add(section4);

		section5 = new JTextField();
		section5.setColumns(10);
		section5.setBounds(22, 202, 39, 28);
		contentPane.add(section5);

		section6 = new JTextField();
		section6.setColumns(10);
		section6.setBounds(22, 247, 39, 28);
		contentPane.add(section6);

		section7 = new JTextField();
		section7.setColumns(10);
		section7.setBounds(22, 292, 39, 28);
		contentPane.add(section7);

		day3 = new JComboBox(Combinator.days);
		day3.setBounds(73, 113, 104, 27);
		contentPane.add(day3);

		time_from3 = new JTextField();
		time_from3.setColumns(10);
		time_from3.setBounds(185, 111, 61, 28);
		contentPane.add(time_from3);
		FocusListenerClass flis5 = new FocusListenerClass(time_from3,contentPane);
		time_from3.addFocusListener(flis5);

		time_to3 = new JTextField();
		time_to3.setColumns(10);
		time_to3.setBounds(258, 111, 61, 28);
		contentPane.add(time_to3);
		FocusListenerClass flis6= new FocusListenerClass(time_to3,contentPane);
		time_to3.addFocusListener(flis6);

		day4 = new JComboBox(Combinator.days);
		day4.setBounds(73, 159, 104, 27);
		contentPane.add(day4);

		time_from4 = new JTextField();
		time_from4.setColumns(10);
		time_from4.setBounds(185, 157, 61, 28);
		contentPane.add(time_from4);
		FocusListenerClass flis7 = new FocusListenerClass(time_from4,contentPane);
		time_from4.addFocusListener(flis7);

		time_to4 = new JTextField();
		time_to4.setColumns(10);
		time_to4.setBounds(258, 157, 61, 28);
		contentPane.add(time_to4);
		FocusListenerClass flis8 = new FocusListenerClass(time_to4,contentPane);
		time_to4.addFocusListener(flis8);

		time_to6 = new JTextField();
		time_to6.setColumns(10);
		time_to6.setBounds(258, 246, 61, 28);
		contentPane.add(time_to6);
		FocusListenerClass flis9 = new FocusListenerClass(time_to6,contentPane);
		time_to6.addFocusListener(flis9);

		time_to5 = new JTextField();
		time_to5.setColumns(10);
		time_to5.setBounds(258, 202, 61, 28);
		contentPane.add(time_to5);
		FocusListenerClass flis11 = new FocusListenerClass(time_to5,contentPane);
		time_to5.addFocusListener(flis11);

		time_from5 = new JTextField();
		time_from5.setColumns(10);
		time_from5.setBounds(185, 202, 61, 28);
		contentPane.add(time_from5);
		FocusListenerClass flis12 = new FocusListenerClass(time_from5,contentPane);
		time_from5.addFocusListener(flis12);

		time_from6 = new JTextField();
		time_from6.setColumns(10);
		time_from6.setBounds(185, 246, 61, 28);
		contentPane.add(time_from6);
		FocusListenerClass flis13 = new FocusListenerClass(time_from6,contentPane);
		time_from6.addFocusListener(flis13);

		day6 = new JComboBox(Combinator.days);
		day6.setBounds(73, 248, 104, 27);
		contentPane.add(day6);

		day5 = new JComboBox(Combinator.days);
		day5.setBounds(73, 204, 104, 27);
		contentPane.add(day5);

		day7 = new JComboBox(Combinator.days);
		day7.setBounds(73, 293, 104, 27);
		contentPane.add(day7);

		time_from7 = new JTextField();
		time_from7.setColumns(10);
		time_from7.setBounds(185, 291, 61, 28);
		contentPane.add(time_from7);
		FocusListenerClass flis14 = new FocusListenerClass(time_from7,contentPane);
		time_from7.addFocusListener(flis14);

		time_to7 = new JTextField();
		time_to7.setColumns(10);
		time_to7.setBounds(258, 291, 61, 28);
		contentPane.add(time_to7);
		FocusListenerClass flis15 = new FocusListenerClass(time_to7,contentPane);
		time_to7.addFocusListener(flis15);


		onay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (!section1.getText().equals("")){
					addSection(lecture,section1,day1,time_from1,time_to1);
				}
				if (!section2.getText().equals("")){
					addSection(lecture,section2,day2,time_from2,time_to2);
				}
				if (!section3.getText().equals("")){
					addSection(lecture,section3,day3,time_from3,time_to3);
				}
				if (!section4.getText().equals("")){
					addSection(lecture,section4,day4,time_from4,time_to4);
				}
				if (!section5.getText().equals("")){
					addSection(lecture,section5,day5,time_from5,time_to5);
				}
				if (!section6.getText().equals("")){
					addSection(lecture,section6,day6,time_from6,time_to6);
				}
				if (!section7.getText().equals("")){
					addSection(lecture,section7,day7,time_from7,time_to7);
				}
			};
		});
	}

	public void addSection(String lecture, JTextField section, JComboBox day, JTextField time_from, JTextField time_to){
		for(int i = 0; i < Combinator.sections.size(); i++){
			String sectionname = Combinator.sections.get(i).split("\\|")[1];
			String lecturename = Combinator.sections.get(i).split("\\|")[0];
			if ((section.getText().equals(sectionname)) && (lecture.equals(lecturename))){
				String temp = Combinator.sections.get(i);
				Combinator.sections.remove(i);
				String updated = temp+"|"+day.getModel().getSelectedItem().toString()+"|"+time_from.getText()+"|"+time_to.getText();
				Combinator.sections.add(i,updated);
				Combinator.list.removeAll();
				Combinator.list.setListData(Combinator.listToArray(Combinator.lectures, Combinator.sections));

				section.setText("");
				day.setSelectedIndex(0);
				time_from.setText("");
				time_to.setText("");

				return;
			}
		}
		String add = lecture+"|"+section.getText()+"|"+day.getModel().getSelectedItem().toString()+"|"+time_from.getText()+"|"+time_to.getText();
		Combinator.sections.add(add);
		Combinator.list.removeAll();
		Combinator.list.setListData(Combinator.listToArray(Combinator.lectures, Combinator.sections));

		section.setText("");
		day.setSelectedIndex(0);
		time_from.setText("");
		time_to.setText("");

	}
}


class FocusListenerClass implements FocusListener {
	JTextField textfield;
	JPanel cPane;
	public FocusListenerClass(JTextField textfield, JPanel contentPane){
		this.textfield = textfield;
		this.cPane = contentPane;
	}

	public void focusGained(FocusEvent e) {	}

	public void focusLost(FocusEvent e){
		String text = textfield.getText();
		if (!text.equals("")){
			if (text.length()==5){
				try{
					int n1 = Integer.parseInt(text.substring(0, 1));
					int n2 = Integer.parseInt(text.substring(1, 2));
					int n3 = Integer.parseInt(text.substring(3, 4));
					int n4 = Integer.parseInt(text.substring(4, 5));

					if ((n1>2)||(n3>=6)){
						JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)1","Format error",JOptionPane.ERROR_MESSAGE);
						textfield.setText("");
					}
					if (!text.substring(2, 3).equals(":")){
						JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)2","Format error",JOptionPane.ERROR_MESSAGE);
						textfield.setText("");
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)3","Format error",JOptionPane.ERROR_MESSAGE);
					textfield.setText("");
				}
			}
			else if(text.length()==4){
				try{
					int n2 = Integer.parseInt(text.substring(0, 1));
					int n3 = Integer.parseInt(text.substring(2, 3));
					int n4 = Integer.parseInt(text.substring(3, 4));
					if (n3>=6){
						JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)","Format error",JOptionPane.ERROR_MESSAGE);
						textfield.setText("");
					}
					if (!text.substring(1, 2).equals(":")){
						JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)","Format error",JOptionPane.ERROR_MESSAGE);
						textfield.setText("");
					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)","Format error",JOptionPane.ERROR_MESSAGE);
					textfield.setText("");
				}
			}
			else{
				JOptionPane.showMessageDialog(cPane,"The format should exactly be like 13:30 (24-Hour format)","Format error",JOptionPane.ERROR_MESSAGE);
				textfield.setText("");
			}
		}
	}

}

