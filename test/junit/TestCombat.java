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
		assertTrue(TestHelper.combatSimulatorRoll(10));
	}
	
	@Test
	public void testRoll11VSAC10IsHit() {
		assertTrue(TestHelper.combatSimulatorRoll(11));
	}
	
	@Test
	public void testRoll19VSAC10IsHit() {
		assertTrue(TestHelper.combatSimulatorRoll(19));
	}
	
	@Test
	public void testRoll20VSAC10IsHit() {
		assertTrue(TestHelper.combatSimulatorRoll(20));
	}
	
	@Test
	public void testRoll9VSAC10IsMiss() {
		assertFalse(TestHelper.combatSimulatorRoll(9));
	}
	
	@Test
	public void testRoll1VSAC10IsMiss() {
		assertFalse(TestHelper.combatSimulatorRoll(1));
	}
	
	@Test
	public void testRoll2VSAC10IsMiss() {
		assertFalse(TestHelper.combatSimulatorRoll(2));
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
		assertEquals(true, TestHelper.combatSimulatorStrAndRoll(12,9));
	}
	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength13() {
		assertEquals(true, TestHelper.combatSimulatorStrAndRoll(13,9));
	}
	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength13CanStillMiss() {
		assertEquals(false, TestHelper.combatSimulatorStrAndRoll(13,8));
	}
	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength14() {
		assertEquals(true, TestHelper.combatSimulatorStrAndRoll(14,8));
	}

	
	@Test
	public void testCharacterAttackRollIncreasedByStrengthModifierForStrength14Roll7Misses() {
		assertEquals(false, TestHelper.combatSimulatorStrAndRoll(14,7));
	}
	
	@Test
	public void testCharacterAttackRollNotIncreasedByStrengthModifierForStrength10() {
		assertEquals(false, TestHelper.combatSimulatorStrAndRoll(10,9));
	}
	
	@Test
	public void testCharacterAttackRollDecreasedByStrengthModifierForStrength8() {
		assertEquals(false, TestHelper.combatSimulatorStrAndRoll(8,10));
	}

	@Test
	public void testCharacterAttackRollDecreasedByStrengthModifierForStrength1() {
		assertEquals(false, TestHelper.combatSimulatorStrAndRoll(1,14));
	}
	
	@Test
	public void testCharacterAttackRollDecreasedByStrengthModifierForStrength1CanStillHitWith15Roll() {
		assertEquals(true, TestHelper.combatSimulatorStrAndRoll(1,15));
	}
}
