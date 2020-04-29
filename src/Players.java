import java.awt.event.WindowEvent;

public class Players {

	//This class contains many methods pertaining to the game's players and game logic.
	//Including: Score control, turn control, game ending and winner logic.
	
	//score1 is Player 1's score, score2 is Player 2's score, and gameCount is a counter of how many questions have been answered
	public static int score1;
	public static int score2;
	public static int gameCount = 0;

	//Initialize the scores at 0
	public static void startScore() {
		score1 = 0;
		score2 = 0;
	}

	//Determine which integer is higher, 0 is a tie
	public static int max(int p1, int p2) {
		if(p1 > p2) {
			return 1;
		} else if(p1 < p2) {
			return 2;
		} else {
			return 0;
		}
	}

	//Determine who the winner is, utilizing the max(int, int) method
	//Update the main game frame to display the winner
	public static int getWinner() {
		if(max(score1, score2) == 1) {
			TriviaGame.lblNewLabel_5.setText("Player 1 wins!");
			return 1;
		} else if(Players.max(score1, score2) == 2) {
			TriviaGame.lblNewLabel_5.setText("Player 2 wins!");
			return 2;
		} else {
			TriviaGame.lblNewLabel_5.setText("The game is tied!");
			return 0;
		}
	}

	//Add points to a player's score, and change the players turn after
	public static void addPoints(int points) {
		if(PlayerTurn.isState(PlayerTurn.Player_1)) {
			Players.score1 = Players.score1 + points;
		} else if(PlayerTurn.isState(PlayerTurn.Player_2)) {
			Players.score2 = Players.score2 + points;
		}
		changeTurn();
	}

	//Remove points from a player's score, and change the players turn after
	public static void removePoints(int points) {
		if(PlayerTurn.isState(PlayerTurn.Player_1)) {
			Players.score1 = Players.score1 - (points/2);
		} else if(PlayerTurn.isState(PlayerTurn.Player_2)) {
			Players.score2 = Players.score2 - (points/2);
		}
		changeTurn();
	}

	//This method will determine who's turn it is after a question is answered
	public static void changeTurn() {
		//If gameCount is 25, the game is over. Otherwise, switch turns between the players
		if(gameCount == 25) {
			PlayerTurn.setTurn(PlayerTurn.END);
			getWinner();
		} else {
			if(PlayerTurn.getTurn().equals(PlayerTurn.Player_1)) {
				PlayerTurn.setTurn(PlayerTurn.Player_2);
			} else {
				PlayerTurn.setTurn(PlayerTurn.Player_1);
			}
		}
	}
	
	//NOTE: This method is a duplicate, solely for JUnit testing. The updating JLabels in getWinner() causes false positives in the JUnit testing.
	//Therefore, the call to getWinner is removed from this duplicate, as it will not impact the would-be result of the testing, if the program was truly running
	//This method will determine who's turn it is after a question is answered
	public static void changeTurn2() {
		//If gameCount is 25, the game is over. Otherwise, switch turns between the players
		if(gameCount == 25) {
			PlayerTurn.setTurn(PlayerTurn.END);
//			getWinner();
		} else {
			if(PlayerTurn.getTurn().equals(PlayerTurn.Player_1)) {
				PlayerTurn.setTurn(PlayerTurn.Player_2);
			} else {
				PlayerTurn.setTurn(PlayerTurn.Player_1);
			}
		}
	}
	
	//Method called at the end of each turn
	public static void endTurn() {
		//Update the displayed players' scores at the bottom corners
		TriviaGame.lblNewLabel_6.setText("Player 1 Score: " + Players.score1);
		TriviaGame.lblNewLabel_6_1.setText("Player 2 Score: " + Players.score2);
		//Update the display of who's turn it is
		TriviaGame.lblNewLabel_5.setText("Turn: " + PlayerTurn.getTurn().toString().replaceAll("_", " "));
		QuestionsFrame.frameQ.dispatchEvent(new WindowEvent(QuestionsFrame.frameQ, WindowEvent.WINDOW_CLOSING));
		TriviaGame.isQUp = false;
		//gameCount keeps track of how many questions have been answered so far.
		//The game has 25 questions, so once gameCount is 25, the game is over
		Players.gameCount++;
		if(Players.gameCount == 25) {
			Players.getWinner();
		}
	}

}
