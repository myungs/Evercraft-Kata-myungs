package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.ScoreModifiers;

public class TestScoreModifiers {

	private void assertScoreIsModifier(int score, int modifier) {
		int gotModifier = ScoreModifiers.getModifier(score);
		int expectedModifier = modifier;
		assertEquals(expectedModifier, gotModifier);
	}

	@Test
	public void testScoreOf1ModifierIsNegative5() {
		assertScoreIsModifier(1, -5);
	}

	@Test
	public void testScoreOf2ModifierIsNegative4() {
		assertScoreIsModifier(2, -4);
	}

	@Test
	public void testScoreOf3ModifierIsNegative4() {
		assertScoreIsModifier(3, -4);
	}

	@Test
	public void testScoreOf4ModifierIsNegative3() {
		assertScoreIsModifier(4, -3);
	}

	@Test
	public void testScoreOf5ModifierIsNegative3() {
		assertScoreIsModifier(5, -3);
	}

	@Test
	public void testScoreOf6ModifierIsNegative2() {
		assertScoreIsModifier(6, -2);
	}

	@Test
	public void testScoreOf7ModifierIsNegative2() {
		assertScoreIsModifier(7, -2);
	}

	@Test
	public void testScoreOf8ModifierIsNegative1() {
		assertScoreIsModifier(8, -1);
	}

	@Test
	public void testScoreOf9ModifierIsNegative1() {
		assertScoreIsModifier(9, -1);
	}

	@Test
	public void testScoreOf10ModifierIsZero() {
		assertScoreIsModifier(10, 0);
	}

	@Test
	public void testScoreOf11ModifierIsZero() {
		assertScoreIsModifier(11, 0);
	}

	@Test
	public void testScoreOf12ModifierIs1() {
		assertScoreIsModifier(12, 1);
	}

	@Test
	public void testScoreOf13ModifierIs1() {
		assertScoreIsModifier(13, 1);
	}

	@Test
	public void testScoreOf14ModifierIs2() {
		assertScoreIsModifier(14, 2);
	}

	@Test
	public void testScoreOf15ModifierIs2() {
		assertScoreIsModifier(15, 2);
	}

	@Test
	public void testScoreOf16ModifierIs3() {
		assertScoreIsModifier(16, 3);
	}

	@Test
	public void testScoreOf17ModifierIs3() {
		assertScoreIsModifier(17, 3);
	}

	@Test
	public void testScoreOf18ModifierIs4() {
		assertScoreIsModifier(18, 4);
	}

	@Test
	public void testScoreOf19ModifierIs4() {
		assertScoreIsModifier(19, 4);
	}

	@Test
	public void testScoreOf20ModifierIs5() {
		assertScoreIsModifier(20, 5);
	}
}
