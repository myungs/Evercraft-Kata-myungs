package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.EvercraftCharacter;

public class TestCombat {
	
	@Test
	public void testCharacterAttacksAnotherCharacter() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		int roll = 10;
		assertNotNull(myCharacter.attackedBy(enemyCharacter, roll));
	}
	
	// Rolling hits vs AC
	@Test
	public void testRoll10VSAC10IsHit() {
		assertTrue(TestHelper.attackedWithRoll(10));
	}
	
	@Test
	public void testRoll11VSAC10IsHit() {
		assertTrue(TestHelper.attackedWithRoll(11));
	}
	
	@Test
	public void testRoll19VSAC10IsHit() {
		assertTrue(TestHelper.attackedWithRoll(19));
	}
	
	@Test
	public void testRoll20VSAC10IsHit() {
		assertTrue(TestHelper.attackedWithRoll(20));
	}
	
	@Test
	public void testRoll9VSAC10IsMiss() {
		assertFalse(TestHelper.attackedWithRoll(9));
	}
	
	@Test
	public void testRoll1VSAC10IsMiss() {
		assertFalse(TestHelper.attackedWithRoll(1));
	}
	
	@Test
	public void testRoll2VSAC10IsMiss() {
		assertFalse(TestHelper.attackedWithRoll(2));
	}
	
	//Takes Damage
	@Test
	public void testCharacterTakes1DamageWhenHit() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.attackedByRoll(10);
		int expectedHitPoints =  4;
		assertEquals(expectedHitPoints, character.getHitPoints());
	}
	
	@Test
	public void testCharacterTakesDoubleDamageWhenHitWithCriticalRollOf20() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.attackedByRoll(20);
		int expectedHitPoints =  3;
		assertEquals(expectedHitPoints, character.getHitPoints());
	}
	
	//Strength Mod for Attack Roll
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength12() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		enemyCharacter.setStrength(12);
		int roll = 9;
		boolean hit = myCharacter.attackedBy(enemyCharacter, roll);
		assertEquals(true, hit);
	}
	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength14() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		enemyCharacter.setStrength(14);
		int roll = 8;
		boolean hit = myCharacter.attackedBy(enemyCharacter, roll);
		assertEquals(true, hit);
	}

	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength14Roll7Misses() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		enemyCharacter.setStrength(14);
		int roll = 7;
		boolean hit = myCharacter.attackedBy(enemyCharacter, roll);
		assertEquals(false, hit);
	}
	
	@Test
	public void testCharacterAttackRollNotIncreasedByStrengthModifierForStrength10() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		enemyCharacter.setStrength(10);
		int roll = 9;
		boolean hit = myCharacter.attackedBy(enemyCharacter, roll);
		assertEquals(false, hit);
	}
	
	@Test
	public void testCharacterAttackRollDecreasedByStrengthModifierForStrength8() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		enemyCharacter.setStrength(8);
		int roll = 10;
		boolean hit = myCharacter.attackedBy(enemyCharacter, roll);
		assertEquals(false, hit);
	}

}
