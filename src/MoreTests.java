import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoreTests {

	@Test
	void usabilityTest() {
		TriviaGame.main(null);
		Players.gameCount = 10;
		assertTrue(PlayerTurn.isState(PlayerTurn.Player_1));
		Players.changeTurn();
		assertTrue(PlayerTurn.isState(PlayerTurn.Player_2));
		
	}

}
