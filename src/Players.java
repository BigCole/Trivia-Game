
public class Players {

	public static int score1;
	public static int score2;
	public static int gameCount = 0;

	public static void startScore() {
		score1 = 0;
		score2 = 0;
	}

	public static int max(int p1, int p2) {
		if(p1 > p2) {
			return 1;
		} else if(p1 < p2) {
			return 2;
		} else {
			return 0;
		}
	}

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

	public static void addPoints(int points) {
		if(PlayerTurn.isState(PlayerTurn.Player_1)) {
			Players.score1 = Players.score1 + points;
			PlayerTurn.setTurn(PlayerTurn.Player_2);
		} else if(PlayerTurn.isState(PlayerTurn.Player_2)) {
			Players.score2 = Players.score2 + points;
			PlayerTurn.setTurn(PlayerTurn.Player_2);
		}
	}

	public static void removePoints(int points) {
		if(PlayerTurn.isState(PlayerTurn.Player_1)) {
			Players.score1 = Players.score1 - (points/2);
			changeTurn();
		} else if(PlayerTurn.isState(PlayerTurn.Player_2)) {
			Players.score2 = Players.score2 - (points/2);
			changeTurn();
		}
	}

	public static void changeTurn() {
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

	public static boolean isAnswerCorrect(String correct, String ans) {
		if(ans.equals(correct)) {
			return true;
		}
		return false;
	}

}
