import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class AddLecture extends JFrame {

	private JPanel contentPane;
	private JTextField lecture;

		public void runLecture(){
			try {
			    UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			} catch (Exception e) {
			    e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLecture frame = new AddLecture();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddLecture() {
		this.setTitle("Add Lecture");
		setBounds(100, 100, 402, 121);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLectureNamewithout = new JLabel("Lecture Name (Without section) :");
		lblLectureNamewithout.setBounds(19, 26, 205, 16);
		contentPane.add(lblLectureNamewithout);
		
		lecture = new JTextField();
		lecture.setBounds(236, 20, 134, 28);
		contentPane.add(lecture);
		lecture.setColumns(10);
		
		System.out.println("hopnaber");
		
		JButton onay = new JButton("Add");
		onay.setBounds(19, 54, 351, 29);
		onay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Combinator.lectures.add(lecture.getText());
				lecture.setText("");
				Combinator.list.removeAll();
				Combinator.list.setListData(Combinator.listToArray(Combinator.lectures, Combinator.sections));
			}
		});
		contentPane.add(onay);
	}
}
