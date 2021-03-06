//No Trivial Matter by Pete Bulman and Cole Wagner
//Created using Eclipse IDE, JUnit 5, and the WindowBuilder plugin (https://www.eclipse.org/windowbuilder/)

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class TriviaGame {

	//This is the main class for the trivia game.

	private static JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		PlayerTurn.setTurn(PlayerTurn.Player_1);
		Players.startScore();
		QAStorage.read(new File("input.txt"));
		EventQueue.invokeLater(new Runnable() {
			//Display the main game window
			@SuppressWarnings("static-access")
			public void run() {
				try {
					TriviaGame window = new TriviaGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TriviaGame() {
		initialize();
	}

	//These are the labels to display the players' scores and whos turn it is
	//They are outside of the initialize() method so they can be accessed and update from another class
	public static JLabel lblNewLabel_5 = null;
	public static JLabel lblNewLabel_6 = null;
	public static JLabel lblNewLabel_6_1 = null;

	//This boolean reflects if a question window is currently open.
	//This is to prevent multiple question windows being open simultaneously
	public static boolean isQUp = false;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1400, 800);
		frame.setTitle("No Trivial Matter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		//Labels for each section of Trivia

		JLabel lblNewLabel = new JLabel("U.S. History");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(75, 11, 145, 45);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("UMASS Dartmouth");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(300, 20, 186, 26);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Computer Science");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(583, 20, 201, 26);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Geography");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(898, 20, 145, 26);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Movies");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(1225, 20, 113, 26);
		frame.getContentPane().add(lblNewLabel_4);

		//Section for US History Buttons

		JButton btnNewButton = new JButton("100");
		buttonGroup.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("US History", 100);
					btnNewButton.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(62, 132, 130, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("200");
		buttonGroup.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("US History", 200);
					btnNewButton_1.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(62, 234, 130, 50);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("300");
		buttonGroup.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("US History", 300);
					btnNewButton_2.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(62, 335, 130, 50);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("400");
		buttonGroup.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("US History", 400);
					btnNewButton_1_1.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(62, 443, 130, 50);
		frame.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_2_1 = new JButton("500");
		buttonGroup.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("US History", 500);
					btnNewButton_2_1.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(62, 544, 130, 50);
		frame.getContentPane().add(btnNewButton_2_1);

		//Section for the UMASS Dartmouth Buttons

		JButton btnNewButton_3 = new JButton("100");
		buttonGroup.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("UMD", 100);
					btnNewButton_3.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(314, 132, 130, 50);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_1_2 = new JButton("200");
		buttonGroup.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("UMD", 200);
					btnNewButton_1_2.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(314, 234, 130, 50);
		frame.getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_2_2 = new JButton("300");
		buttonGroup.add(btnNewButton_2_2);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("UMD", 300);
					btnNewButton_2_2.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_2.setBounds(314, 335, 130, 50);
		frame.getContentPane().add(btnNewButton_2_2);

		JButton btnNewButton_1_1_1 = new JButton("400");
		buttonGroup.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("UMD", 400);
					btnNewButton_1_1_1.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBounds(314, 443, 130, 50);
		frame.getContentPane().add(btnNewButton_1_1_1);

		JButton btnNewButton_2_1_1 = new JButton("500");
		buttonGroup.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("UMD", 500);
					btnNewButton_2_1_1.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_1.setBounds(314, 544, 130, 50);
		frame.getContentPane().add(btnNewButton_2_1_1);

		//Section for the Computer Science Buttons

		JButton btnNewButton_4 = new JButton("100");
		buttonGroup.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("CS", 100);
					btnNewButton_4.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(600, 132, 130, 50);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_1_3 = new JButton("200");
		buttonGroup.add(btnNewButton_1_3);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("CS", 200);
					btnNewButton_1_3.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_3.setBounds(600, 234, 130, 50);
		frame.getContentPane().add(btnNewButton_1_3);

		JButton btnNewButton_2_3 = new JButton("300");
		buttonGroup.add(btnNewButton_2_3);
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("CS", 300);
					btnNewButton_2_3.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_3.setBounds(600, 335, 130, 50);
		frame.getContentPane().add(btnNewButton_2_3);

		JButton btnNewButton_1_1_2 = new JButton("400");
		buttonGroup.add(btnNewButton_1_1_2);
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("CS", 400);
					btnNewButton_1_1_2.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_2.setBounds(600, 443, 130, 50);
		frame.getContentPane().add(btnNewButton_1_1_2);

		JButton btnNewButton_2_1_2 = new JButton("500");
		buttonGroup.add(btnNewButton_2_1_2);
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("CS", 500);
					btnNewButton_2_1_2.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_2.setBounds(600, 544, 130, 50);
		frame.getContentPane().add(btnNewButton_2_1_2);

		//Section for the Geography buttons

		JButton btnNewButton_5 = new JButton("100");
		buttonGroup.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("GEO", 100);
					btnNewButton_5.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(883, 132, 130, 50);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_1_4 = new JButton("200");
		buttonGroup.add(btnNewButton_1_4);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("GEO", 200);
					btnNewButton_1_4.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_4.setBounds(883, 234, 130, 50);
		frame.getContentPane().add(btnNewButton_1_4);

		JButton btnNewButton_2_4 = new JButton("300");
		buttonGroup.add(btnNewButton_2_4);
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("GEO", 300);
					btnNewButton_2_4.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_4.setBounds(883, 335, 130, 50);
		frame.getContentPane().add(btnNewButton_2_4);

		JButton btnNewButton_1_1_3 = new JButton("400");
		buttonGroup.add(btnNewButton_1_1_3);
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("GEO", 400);
					btnNewButton_1_1_3.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_3.setBounds(883, 443, 130, 50);
		frame.getContentPane().add(btnNewButton_1_1_3);

		JButton btnNewButton_2_1_3 = new JButton("500");
		buttonGroup.add(btnNewButton_2_1_3);
		btnNewButton_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("GEO", 500);
					btnNewButton_2_1_3.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_3.setBounds(883, 544, 130, 50);
		frame.getContentPane().add(btnNewButton_2_1_3);

		//Section for the Movie Buttons

		JButton btnNewButton_6 = new JButton("100");
		buttonGroup.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("MOV", 100);
					btnNewButton_6.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_6.setBounds(1198, 132, 130, 50);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_1_5 = new JButton("200");
		buttonGroup.add(btnNewButton_1_5);
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("MOV", 200);
					btnNewButton_1_5.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_5.setBounds(1198, 234, 130, 50);
		frame.getContentPane().add(btnNewButton_1_5);

		JButton btnNewButton_2_5 = new JButton("300");
		buttonGroup.add(btnNewButton_2_5);
		btnNewButton_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("MOV", 300);
					btnNewButton_2_5.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_5.setBounds(1198, 335, 130, 50);
		frame.getContentPane().add(btnNewButton_2_5);

		JButton btnNewButton_1_1_4 = new JButton("400");
		buttonGroup.add(btnNewButton_1_1_4);
		btnNewButton_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("MOV", 400);
					btnNewButton_1_1_4.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_4.setBounds(1198, 443, 130, 50);
		frame.getContentPane().add(btnNewButton_1_1_4);

		JButton btnNewButton_2_1_4 = new JButton("500");
		buttonGroup.add(btnNewButton_2_1_4);
		btnNewButton_2_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isQUp == false) {
					QuestionsFrame.initializeQ("MOV", 500);
					btnNewButton_2_1_4.setVisible(false);
					isQUp = true;
				}
			}
		});
		btnNewButton_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2_1_4.setBounds(1198, 544, 130, 50);
		frame.getContentPane().add(btnNewButton_2_1_4);

		//The labels below will display the players' scores and whos turn it is
		
		lblNewLabel_5 = new JLabel("Turn: " + PlayerTurn.getTurn().toString().replaceAll("_", " "));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(594, 701, 256, 45);
		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Player 1 Score: " + Players.score1);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(40, 701, 214, 45);
		frame.getContentPane().add(lblNewLabel_6);

		lblNewLabel_6_1 = new JLabel("Player 2 Score: " + Players.score2);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(1157, 701, 214, 45);
		frame.getContentPane().add(lblNewLabel_6_1);


	}
}