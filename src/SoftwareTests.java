import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class SoftwareTests {

	//This class contains JUnit tests for our dynamic qualities
	
	//This method does the performance test, by making sure the input.txt file loads in 250 milliseconds or less
	//This method also performs a reliability test by making sure all the question HashMaps contain only questions.
	//This is checked by ensuring that every question in all 5 question HashMaps end in a "?" character.
	@Test
	void performanceAndReliabilityTest1() {
		Instant start = Instant.now();
		TriviaGame.main(null);
		File f = new File("input.txt");
		QAStorage.read(f);
		//These for loops will go through each key in the 5 HashMaps and verify the value is a question
		for(int i = 100; i < QAStorage.USQ.size() * 100; i += 100) {
			assertTrue(QAStorage.USQ.get(i), QAStorage.USQ.get(i).endsWith("?"));
		}
		for(int i = 100; i < QAStorage.UMD.size() * 100; i += 100) {
			assertTrue(QAStorage.UMD.get(i), QAStorage.UMD.get(i).endsWith("?"));
		}
		for(int i = 100; i < QAStorage.CS.size() * 100; i += 100) {
			assertTrue(QAStorage.CS.get(i), QAStorage.CS.get(i).endsWith("?"));
		}
		for(int i = 100; i < QAStorage.GEO.size() * 100; i += 100) {
			assertTrue(QAStorage.GEO.get(i), QAStorage.GEO.get(i).endsWith("?"));
		}
		for(int i = 100; i < QAStorage.MOV.size() * 100; i += 100) {
			assertTrue(QAStorage.MOV.get(i), QAStorage.MOV.get(i).endsWith("?"));
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		assertTrue(timeElapsed <= 250);
	}

	//This test will check if the NoSuchElementException is thrown when the txt file is empty
	@Test
	void reliabilityTest2() {
		assertThrows(NoSuchElementException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				File f = new File("empty.txt");
				QAStorage.read(f);
			}
		});
	}
	
	//This test will check if the NullPointerException is thrown when the txt file does not exist
	@Test
	void reliabilityTest3() {
		assertThrows(NullPointerException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				File f = null;
				QAStorage.read(f);
			}
		});
	}
	
	//This consistency test checks to make sure that correct and incorrect answers are processed correctly.
	//This also accounts for null answers (if no answer is selected)
	@Test
	void consistencyTest1() {
		assertTrue(QAStorage.isAnswerCorrect("correct answer", "correct answer"));
		assertFalse(QAStorage.isAnswerCorrect("correct answer", "incorrect answer"));
		assertFalse(QAStorage.isAnswerCorrect(null, "correct answer"));
	}
	
	//This consistency test will check to make sure that point adding and removal will yield the proper score outcome
	@Test
	void consistencyTest2() {
		TriviaGame.main(null);
		int s1 = Players.score1;
		int s2 = Players.score2;

		Players.addPoints(300);

		assertEquals(s1 + 300, Players.score1);

		PlayerTurn.setTurn(PlayerTurn.Player_2);

		//The 300 is passed as a parameter when a 300-point value question is selected
		//It should remove half the point value, in this case, 150
		Players.removePoints(300);

		assertEquals(s2 - 150, Players.score2);
	}
	
	//This completeness test will check to make sure the END game state is set only when the gameCount reaches 25, which means the game is over.
	@Test
	void completenessTest() {
		TriviaGame.main(null);

		Players.gameCount = 24;
		Players.changeTurn();
		assertFalse(PlayerTurn.isState(PlayerTurn.END));
		Players.gameCount = 25;
		//Note: changeTurn2()'s function for this testing purpose is identical to changeTurn()
		//Details of the reason why this duplicate testing method exists is in Players.java, line 80
		Players.changeTurn2();
		assertTrue(PlayerTurn.isState(PlayerTurn.END));
	}
}
