import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class MoreTests {

	//This class contains a JUnit test for our usability quality.
	//(This test was failing while in the class with the other tests, but works in it's own class)

	//This test ensures that when the player turn changes, the game detects the proper player turn
	@Test
	void usabilityTest() {
		TriviaGame.main(null);
		//gameCount 10 is arbitrary, as long at it's between 0 and 24.
		Players.gameCount = 10;
		assertTrue(PlayerTurn.isState(PlayerTurn.Player_1));
		Players.changeTurn();
		assertTrue(PlayerTurn.isState(PlayerTurn.Player_2));
		Players.changeTurn();
		assertTrue(PlayerTurn.isState(PlayerTurn.Player_1));
	}

}
