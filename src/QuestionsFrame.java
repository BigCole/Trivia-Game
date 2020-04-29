import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class QuestionsFrame {

	//This class' main function is the windows that pop up with questions and answer selections
	
	public static JFrame frameQ;
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	//This HashMap will be replaced with the map that contains the correct answers to the questions for a category
	//Ex. <questionIndex_(1-5), correctAnswer>
	public static HashMap<Integer, String> correctMap = null;
	
	public static void initializeQ(String category, int points) {
		//qMap will store the questions for each category <Point_Value, Question>
		//aMap will store the answers for each question <index (0-3), answer>
		HashMap<Integer, String> qMap = null;
		HashMap<Integer, String> aMap = null;
		
		//If statement will determine which category the question is and the nested if statement will determine the 
		//point value of the question and set aMap to the appropriate answers HashMap
		if(category.equals("US History")) {
			qMap = QAStorage.USQ;
			correctMap = QAStorage.USA;
			if(points == 100) {
				aMap = QAStorage.US1A;
			} else if(points == 200) {
				aMap = QAStorage.US2A;
			} else if(points == 300) {
				aMap = QAStorage.US3A;
			} else if(points == 400) {
				aMap = QAStorage.US4A;
			} else if(points == 500) {
				aMap = QAStorage.US5A;
			}
			
		} else if(category.equals("UMD")) {
			qMap = QAStorage.UMD;
			correctMap = QAStorage.UMDA;
			if(points == 100) {
				aMap = QAStorage.UMD1A;
			} else if(points == 200) {
				aMap = QAStorage.UMD2A;
			} else if(points == 300) {
				aMap = QAStorage.UMD3A;
			} else if(points == 400) {
				aMap = QAStorage.UMD4A;
			} else if(points == 500) {
				aMap = QAStorage.UMD5A;
			}
			
		} else if(category.equals("CS")) {
			qMap = QAStorage.CS;
			correctMap = QAStorage.CSA;
			
			if(points == 100) {
				aMap = QAStorage.CS1A;
			} else if(points == 200) {
				aMap = QAStorage.CS2A;
			} else if(points == 300) {
				aMap = QAStorage.CS3A;
			} else if(points == 400) {
				aMap = QAStorage.CS4A;
			} else if(points == 500) {
				aMap = QAStorage.CS5A;
			}
		} else if(category.equals("GEO")) {
			qMap = QAStorage.GEO;
			correctMap = QAStorage.GEOA;
			
			if(points == 100) {
				aMap = QAStorage.GEO1A;
			} else if(points == 200) {
				aMap = QAStorage.GEO2A;
			} else if(points == 300) {
				aMap = QAStorage.GEO3A;
			} else if(points == 400) {
				aMap = QAStorage.GEO4A;
			} else if(points == 500) {
				aMap = QAStorage.GEO5A;
			}
		} else if(category.equals("MOV")) {
			qMap = QAStorage.MOV;
			correctMap = QAStorage.MOVA;
			
			if(points == 100) {
				aMap = QAStorage.MOV1A;
			} else if(points == 200) {
				aMap = QAStorage.MOV2A;
			} else if(points == 300) {
				aMap = QAStorage.MOV3A;
			} else if(points == 400) {
				aMap = QAStorage.MOV4A;
			} else if(points == 500) {
				aMap = QAStorage.MOV5A;
			}
		}
		
		frameQ = new JFrame();
		frameQ.setBounds(100, 100, 800, 400);
		frameQ.getContentPane().setLayout(null);
		
		//JLabel and Buttons to set up the radio boxes and labels for the question frame
		JLabel lblNewLabel = new JLabel("<html>" + qMap.get(points) + "</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 764, 68);
		frameQ.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("<html>" + aMap.get(1) + "</html>");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(44, 104, 730, 23);
		frameQ.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("<html>" + aMap.get(2) + "</html>");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(44, 149, 730, 23);
		frameQ.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("<html>" + aMap.get(3) + "</html>");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(44, 198, 730, 23);
		frameQ.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("<html>" + aMap.get(4) + "</html>");
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(44, 243, 730, 23);
		frameQ.getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JButton btnNewButton = new JButton("Done");
		buttonGroup_1.add(btnNewButton);
		
		//Action Listener for when the player presses the "Done" button in the question frame
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//num is the index of the question within the correctMap
				//Ex. Question with point value 100 will be index 1
				int num = points/100;
				String correct = correctMap.get(num);
				String ans = null;
				//correct = the correct answer to the question
				//ans = the answer submitted by the player
				if(rdbtnNewRadioButton.isSelected()) {
					ans = rdbtnNewRadioButton.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_1.isSelected()) {
					ans = rdbtnNewRadioButton_1.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_2.isSelected()) {
					ans = rdbtnNewRadioButton_2.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_1_1.isSelected()) {
					ans = rdbtnNewRadioButton_1_1.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				}
				//If the question was answered correctly, give them the points
				//If it was answered incorrectly, take away the point value of the question / 2
				if((ans == null) || (!QAStorage.isAnswerCorrect(correct, ans))) {
					Players.removePoints(points);
				} else {
					Players.addPoints(points);
				}
				Players.endTurn();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(44, 306, 115, 23);
		frameQ.getContentPane().add(btnNewButton);
		
		try {
			QuestionsFrame.frameQ.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
	}
	
}
