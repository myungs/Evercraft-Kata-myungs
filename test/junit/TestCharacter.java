package junit;
import static org.junit.Assert.*;
import junit.TestHelper;

import org.junit.Test;

import core.Alignments;
import core.EvercraftCharacter;


public class TestCharacter {
	
	//Names
	@Test
	public void testCreateCharacterWithName() {
		String name = "Superman";
		EvercraftCharacter character = TestHelper.createCharacterWithName(name);
		assertEquals(name, character.getName());
	}
	
	@Test
	public void testCanChangeCharacterName() {
		String oldName = "Bruce Wayne";
		String newName = "Batman";
		EvercraftCharacter character = new EvercraftCharacter(oldName);
		character.setName(newName);
		assertEquals(newName, character.getName());
	}
	
	//Alignments
	@Test
	public void testCharacterDefaultsNeutralAlignment() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertEquals(Alignments.NEUTRAL, character.getAlignment());
	}
	
	@Test
	public void testCharacterCanBeEvilAlignment() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setAlignment(Alignments.EVIL);
		assertEquals(Alignments.EVIL, character.getAlignment());
	}
	
	@Test
	public void testCharacterCanBeGoodAlignment() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setAlignment(Alignments.GOOD);
		assertEquals(Alignments.GOOD, character.getAlignment());
	}
	
	@Test
	public void testCharacterCanBeResetToNeutralAlignment() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setAlignment(Alignments.EVIL);
		character.setAlignment(Alignments.NEUTRAL);
		assertEquals(Alignments.NEUTRAL, character.getAlignment());
	}
	
	@Test
	public void testCharacterDefaultArmorClass() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertEquals(10, character.getArmorClass());
	}
	
	@Test
	public void testCharacterDefaultHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertEquals(5, character.getHitPoints());
	}
	
	
	//Dead or Alive?
	@Test
	public void testCharacterIsDeadWhenHitPointsIsZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setHitPoints(0);
		assertTrue(character.isDead());
	}
	
	@Test
	public void testCharacterIsDeadWhenHitPointsIsLessThanZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setHitPoints(-1);
		assertTrue(character.isDead());
	}
	
	@Test
	public void testCharacterIsNotDeadWhenHitPointsIsGreaterThanZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setHitPoints(1);
		assertFalse(character.isDead());
	}
	
	@Test
	public void testCharacterIsNotDeadWhenCharacterHasTakenNoDamage() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertFalse(character.isDead());
	}
	
	//Attributes
	@Test
	public void testCharacterDefaultStrengthIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedStrength = 10;
		assertEquals(expectedStrength, character.getStrength());
	}
	
	@Test
	public void testCharacterDefaultDexterityIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedDexterity = 10;
		assertEquals(expectedDexterity, character.getDexterity());
	}
	
	@Test
	public void testCharacterDefaultConstitutionIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedConstitution = 10;
		assertEquals(expectedConstitution, character.getConstitution());
	}
	
	@Test
	public void testCharacterDefaultWisdomIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedWisdom = 10;
		assertEquals(expectedWisdom, character.getWisdom());
	}
	
	@Test
	public void testCharacterDefaultIntelligenceIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedIntelligence = 10;
		assertEquals(expectedIntelligence, character.getIntelligence());
	}
	
	@Test
	public void testCharacterDefaultCharismaIs10() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		int expectedCharisma = 10;
		assertEquals(expectedCharisma, character.getCharisma());
	}
	
	//Attack Damage Calculations
	
	@Test
	public void testStrength11AddsToAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(11);
		assertEquals(1, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength12AddsToAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(12);
		assertEquals(2, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength14AddsFromAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(14);
		assertEquals(3, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength19AddsFromAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(19);
		assertEquals(5, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength9SubtractsToAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(9);
		assertEquals(1, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength8SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(8);
		assertEquals(1, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength7SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(7);
		assertEquals(1, character.attackDamageBonus());
	}
	
	@Test
	public void testStrength1SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(1);
		assertEquals(1, character.attackDamageBonus());
	}
	
	//Critical Rolls on Attack Damage
//	@Test
//	public void testStrength12DoubleStrengthModifierOnCriticalHits() {
//		EvercraftCharacter character = TestHelper.createDefaultCharacter();
//		character.setStrength(12);
//		int expectedDamage = 3;
//		assertEquals(expectedDamage, character.attackDamageBonus());
//	}
	
}
