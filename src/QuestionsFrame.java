import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class QuestionsFrame {

	
	private static JFrame frameQ;
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	
	public static HashMap<Integer, String> correctMap = null;
	
	public static void initializeQ(String category, int points) {
		
		HashMap<Integer, String> qMap = null;
		HashMap<Integer, String> aMap = null;
		
		if(category.equals("US History")) {
			qMap = QuestionList.USQ;
			correctMap = QuestionList.USA;
			if(points == 100) {
				aMap = QuestionList.US1A;
			} else if(points == 200) {
				aMap = QuestionList.US2A;
			} else if(points == 300) {
				aMap = QuestionList.US3A;
			} else if(points == 400) {
				aMap = QuestionList.US4A;
			} else if(points == 500) {
				aMap = QuestionList.US5A;
			}
			
		} else if(category.equals("UMD")) {
			qMap = QuestionList.UMD;
			correctMap = QuestionList.UMDA;
			if(points == 100) {
				aMap = QuestionList.UMD1A;
			} else if(points == 200) {
				aMap = QuestionList.UMD2A;
			} else if(points == 300) {
				aMap = QuestionList.UMD3A;
			} else if(points == 400) {
				aMap = QuestionList.UMD4A;
			} else if(points == 500) {
				aMap = QuestionList.UMD5A;
			}
			
		} else if(category.equals("CS")) {
			qMap = QuestionList.CS;
			correctMap = QuestionList.CSA;
			
			if(points == 100) {
				aMap = QuestionList.CS1A;
			} else if(points == 200) {
				aMap = QuestionList.CS2A;
			} else if(points == 300) {
				aMap = QuestionList.CS3A;
			} else if(points == 400) {
				aMap = QuestionList.CS4A;
			} else if(points == 500) {
				aMap = QuestionList.CS5A;
			}
		} else if(category.equals("GEO")) {
			qMap = QuestionList.GEO;
			correctMap = QuestionList.GEOA;
			
			if(points == 100) {
				aMap = QuestionList.GEO1A;
			} else if(points == 200) {
				aMap = QuestionList.GEO2A;
			} else if(points == 300) {
				aMap = QuestionList.GEO3A;
			} else if(points == 400) {
				aMap = QuestionList.GEO4A;
			} else if(points == 500) {
				aMap = QuestionList.GEO5A;
			}
		} else if(category.equals("MOV")) {
			qMap = QuestionList.MOV;
			correctMap = QuestionList.MOVA;
			
			if(points == 100) {
				aMap = QuestionList.MOV1A;
			} else if(points == 200) {
				aMap = QuestionList.MOV2A;
			} else if(points == 300) {
				aMap = QuestionList.MOV3A;
			} else if(points == 400) {
				aMap = QuestionList.MOV4A;
			} else if(points == 500) {
				aMap = QuestionList.MOV5A;
			}
		}
		
		frameQ = new JFrame();
		frameQ.setBounds(100, 100, 800, 400);
		frameQ.getContentPane().setLayout(null);
		
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
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = points/100;
				String correct = correctMap.get(num);
				String ans = "";
				if(rdbtnNewRadioButton.isSelected()) {
					ans = rdbtnNewRadioButton.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_1.isSelected()) {
					ans = rdbtnNewRadioButton_1.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_2.isSelected()) {
					ans = rdbtnNewRadioButton_2.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				} else if(rdbtnNewRadioButton_1_1.isSelected()) {
					ans = rdbtnNewRadioButton_1_1.getText().replaceAll("<html>", "").replaceAll("</html>", "");
				}
				if(Players.isAnswerCorrect(correct, ans)) {
					Players.addPoints(points);
				} else {
					Players.removePoints(points);
				}
				endTurn();
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
	
	public static void endTurn() {
		TriviaGame.lblNewLabel_6.setText("Player 1 Score: " + Players.score1);
		TriviaGame.lblNewLabel_6_1.setText("Player 2 Score: " + Players.score2);
		TriviaGame.lblNewLabel_5.setText("Turn: " + PlayerTurn.getTurn().toString().replaceAll("_", " "));
		frameQ.dispatchEvent(new WindowEvent(frameQ, WindowEvent.WINDOW_CLOSING));
		TriviaGame.isQUp = false;
		Players.gameCount++;
		if(Players.gameCount == 25) {
			Players.getWinner();
		}
	}
	
}
