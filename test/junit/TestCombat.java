package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import core.EvercraftCharacter;

public class TestCombat {
	
	private final boolean HIT = true;
	private final boolean MISS = false;
	
	@Test
	public void testCharacterAttacksAnotherCharacter() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		int roll = 10;
		assertTrue(myCharacter.attackedBy(enemyCharacter, roll));
	}
	
	// Rolling hits vs AC
	@Test
	public void testRoll10VSAC10IsHit() {
		assertEquals(HIT, TestHelper.combatSimulatorRoll(10));
	}
	
	@Test
	public void testRoll11VSAC10IsHit() {
		assertEquals(HIT, TestHelper.combatSimulatorRoll(11));
	}
	
	@Test
	public void testRoll19VSAC10IsHit() {
		assertEquals(HIT, TestHelper.combatSimulatorRoll(19));
	}
	
	@Test
	public void testRoll20VSAC10IsHit() {
		assertEquals(HIT, TestHelper.combatSimulatorRoll(20));
	}
	
	@Test
	public void testRoll9VSAC10IsMiss() {
		assertEquals(MISS, TestHelper.combatSimulatorRoll(9));
	}
	
	@Test
	public void testRoll1VSAC10IsMiss() {
		assertEquals(MISS, TestHelper.combatSimulatorRoll(1));
	}
	
	@Test
	public void testRoll2VSAC10IsMiss() {
		assertEquals(MISS, TestHelper.combatSimulatorRoll(2));
	}
	
	//Tests for Strength Mod applies to Attack Roll for Hit/Miss
	
	@Test
	public void Strength12Roll9Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(12,9));
	}
	
	public void Strength12Roll10Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(12,10));
	}

	@Test
	public void Strength12Roll20Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(12,20));
	}
	
	@Test
	public void Strength12Roll8Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(12,8));
	}
	
	@Test
	public void Strength12Roll1Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(12,1));
	}

	@Test
	public void Strength13Roll9Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(13,9));
	}

	@Test
	public void Strength13Roll10Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(13,10));
	}

	@Test
	public void Strength13Roll20Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(13,20));
	}
	
	@Test
	public void Strength13Roll8Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(13,8));
	}
	
	@Test
	public void Strength13Roll1Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(13,1));
	}

	@Test
	public void Strength1Roll15Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(1,15));
	}

	@Test
	public void Strength1Roll20Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(1,20));
	}
	
	@Test
	public void Strength1Roll14Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(1,8));
	}

	@Test
	public void Strength1Roll1Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(1,1));
	}

	@Test
	public void Strength20Roll5Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(20,5));
	}

	@Test
	public void Strength20Roll20Hits() {
		assertEquals(HIT, TestHelper.combatSimulatorStrAndRoll(20,20));
	}
	
	@Test
	public void Strength20Roll4Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(20,4));
	}
	
	@Test
	public void Strength20Roll1Misses() {
		assertEquals(MISS, TestHelper.combatSimulatorStrAndRoll(20,1));
	}
	
	//Takes Damage
	@Test
	public void testCharacterTakes1DamageWhenHit() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		character.attackedBy(enemyCharacter, 10);
		int expectedHitPoints =  4;
		assertEquals(expectedHitPoints, character.getCurrentHitPoints());
	}
	
	@Test
	public void testCharacterTakesDoubleDamageWhenHitWithCriticalRollOf20() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		character.attackedBy(enemyCharacter, 20);
		int expectedHitPoints =  3;
		assertEquals(expectedHitPoints, character.getCurrentHitPoints());
	}
}
