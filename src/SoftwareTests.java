import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class SoftwareTests {

	@Test
	void reliabilityTest1() {
		TriviaGame.main(null);
		File f = new File("input.txt");
		QuestionList.read(f);

		for(int i = 100; i < QuestionList.USQ.size() * 100; i += 100) {
			assertTrue(QuestionList.USQ.get(i), QuestionList.USQ.get(i).endsWith("?"));
		}

		for(int i = 100; i < QuestionList.UMD.size() * 100; i += 100) {
			assertTrue(QuestionList.UMD.get(i), QuestionList.UMD.get(i).endsWith("?"));
		}

		for(int i = 100; i < QuestionList.CS.size() * 100; i += 100) {
			assertTrue(QuestionList.CS.get(i), QuestionList.CS.get(i).endsWith("?"));
		}

		for(int i = 100; i < QuestionList.GEO.size() * 100; i += 100) {
			assertTrue(QuestionList.GEO.get(i), QuestionList.GEO.get(i).endsWith("?"));
		}

		for(int i = 100; i < QuestionList.MOV.size() * 100; i += 100) {
			assertTrue(QuestionList.MOV.get(i), QuestionList.MOV.get(i).endsWith("?"));
		}

	}

	@Test
	void reliabilityTest2() {
		assertThrows(NoSuchElementException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				// TODO Auto-generated method stub
				File f = new File("empty.txt");
				QuestionList.read(f);
			}
		});
	}
	
	@Test
	void consistencyTest1() {
		assertTrue(Players.isAnswerCorrect("correct answer", "correct answer"));
		assertFalse(Players.isAnswerCorrect("correct answer", "incorrect answer"));
		assertFalse(Players.isAnswerCorrect(null, "correct answer"));
	}
	
	@Test
	void consistencyTest2() {
		TriviaGame.main(null);
		int s1 = Players.score1;
		int s2 = Players.score2;

		Players.addPoints(300);

		assertEquals(s1 + 300, Players.score1);

		PlayerTurn.setTurn(PlayerTurn.Player_2);

		Players.removePoints(300);

		assertEquals(s2 - 150, Players.score2);
	}
	

	@Test
	void completenessTest() {
		TriviaGame.main(null);
		Players.gameCount = 24;
		assertFalse(PlayerTurn.isState(PlayerTurn.END));
		Players.gameCount++;
		assertTrue(PlayerTurn.getTurn().equals(PlayerTurn.END));
	}


}
