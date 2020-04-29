//This Enum class is to keep the state of the game. It is either one of the players' turns, or the game is over


public enum PlayerTurn {

	Player_1,
	Player_2,
	END;
	
	//The current turn state
	private static PlayerTurn pTurn;
	
	//Set the turn state
	public static void setTurn(PlayerTurn pt) {
		pTurn = pt;
	}
	
	//Check if the current state matches any given state
	public static boolean isState(PlayerTurn pt) {
		if(pTurn.equals(pt)) {
			return true;
		}
		return false;
	}
	
	//Return the current give state
	public static PlayerTurn getTurn() {
		return pTurn;
	}
	
}
