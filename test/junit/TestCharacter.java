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
		assertEquals(5, character.getCurrentHitPoints());
	}
	
	
	//Dead or Alive?
	@Test
	public void testCharacterIsDeadWhenHitPointsIsZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setCurrentHitPoints(0);
		assertTrue(character.isDead());
	}
	
	@Test
	public void testCharacterIsDeadWhenHitPointsIsLessThanZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setCurrentHitPoints(-1);
		assertTrue(character.isDead());
	}
	
	@Test
	public void testCharacterIsNotDeadWhenHitPointsIsGreaterThanZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setCurrentHitPoints(1);
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
		assertEquals(1, character.attackDamage());
	}
	
	@Test
	public void testStrength12AddsToAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(12);
		assertEquals(2, character.attackDamage());
	}
	
	@Test
	public void testStrength14AddsFromAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(14);
		assertEquals(3, character.attackDamage());
	}
	
	@Test
	public void testStrength19AddsFromAttackDamageBasedOnModifier() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(19);
		assertEquals(5, character.attackDamage());
	}
	
	@Test
	public void testStrength9SubtractsToAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(9);
		assertEquals(1, character.attackDamage());
	}
	
	@Test
	public void testStrength8SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(8);
		assertEquals(1, character.attackDamage());
	}
	
	@Test
	public void testStrength7SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(7);
		assertEquals(1, character.attackDamage());
	}
	
	@Test
	public void testStrength1SubtractsFromAttackDamageBasedOnModifierMinimumDamageOf1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(1);
		assertEquals(1, character.attackDamage());
	}
	
	//Critical Rolls on Attack Damage
	@Test
	public void testStrength12DoubleStrengthModifierOnCriticalHits() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(12);
		assertEquals(4, character.attackDamageOnCrits());
	}
	
	@Test
	public void testStrength13DoubleStrengthModifierOnCriticalHits() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(13);
		assertEquals(4, character.attackDamageOnCrits());
	}
	
	@Test
	public void testStrength20DoubleStrengthModifierOnCriticalHits() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(20);
		assertEquals(12, character.attackDamageOnCrits());
	}
	
	@Test
	public void testStrength9DoubleStrengthModifierOnCriticalHitsNegativelyMinimum2Damage() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(9);
		assertEquals(2, character.attackDamageOnCrits());
	}
	
	@Test
	public void testStrength1DoubleStrengthModifierOnCriticalHitsNegativelyMinimum2Damage() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setStrength(1);
		assertEquals(2, character.attackDamageOnCrits());
	}
	
	
	//Test Dexterity Bonus modifies armor class
	@Test
	public void testDexterity20ModifiesCharacterArmorClass() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setDexterity(20);
		assertEquals(15, character.getArmorClass());
	}
	
	@Test
	public void testDexterity12ModifiesCharacterArmorClass() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setDexterity(12);
		assertEquals(11, character.getArmorClass());
	}
	
	@Test
	public void testDexterity1ModifiesCharacterArmorClassNegatively() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setDexterity(1);
		assertEquals(5, character.getArmorClass());
	}
	
	
	//Test constitution modifies base hit points
	@Test
	public void testConstitution12ModifiesCharacterHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setConstitution(12);
		assertEquals(6, character.getMaxHitPoints());
	}
	
	@Test
	public void testConstitution20ModifiesCharacterHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setConstitution(20);
		assertEquals(10, character.getMaxHitPoints());
	}
	
	@Test
	public void testConstitution1NegativelyModifiesCharacterHitPointsMinimumOf1MaxHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setConstitution(1);
		assertEquals(1, character.getMaxHitPoints());
	}
	
	@Test
	public void testConstitution3NegativelyModifiesCharacterHitPointsMinimumOf1MaxHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setConstitution(3);
		assertEquals(1, character.getMaxHitPoints());
	}
	
	@Test
	public void testConstitution3NegativelyModifiesCharacterHitPoints() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setConstitution(4);
		assertEquals(2, character.getMaxHitPoints());
	}

	//Test for leveling up and experience
	@Test
	public void testCharactersCanHaveLevelsDefault1() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertEquals(1, character.getLevel());
	}

	@Test
	public void testCharactersCanHaveExperienceDefaultZero() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		assertEquals(0, character.getExperience());
	}

	@Test
	public void testCharactersIsLevel1After999XP() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setExperience(999);
		assertEquals(1, character.getLevel());
	}

	@Test
	public void testCharactersIsLevel2After1000XP() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setExperience(1000);
		assertEquals(2, character.getLevel());
	}

	@Test
	public void testCharactersIsLevel2After1999XP() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setExperience(1999);
		assertEquals(2, character.getLevel());
	}

	@Test
	public void testCharactersIsLevel3After2000XP() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setExperience(2000);
		assertEquals(3, character.getLevel());
	}

	@Test
	public void testCharactersIsLevel10After9000XP() {
		EvercraftCharacter character = TestHelper.createDefaultCharacter();
		character.setExperience(9000);
		assertEquals(10, character.getLevel());
	}

	//Test gaining experience by attacking
	@Test
	public void testCharacterGains10XPOnSuccessfullAttack() {
		EvercraftCharacter myCharacter = TestHelper.combatSimulatorWithExperience(0);
		assertEquals(10, myCharacter.getExperience());
	}

	@Test
	public void testCharacterCanLevelUpByAttacking() {
		EvercraftCharacter myCharacter = TestHelper.combatSimulatorWithExperience(990);
		assertEquals(2, myCharacter.getLevel());
	}

	@Test
	public void testCharacterDoesntAlwaysLevelByAttacking() {
		EvercraftCharacter myCharacter = TestHelper.combatSimulatorWithExperience(1000);
		assertEquals(2, myCharacter.getLevel());
	}

	//Test character hit point increase with level
	@Test
	public void testCharacterHitPointsIncreaseBy5PerLevel() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(2);
		assertEquals(10, myCharacter.getMaxHitPoints());
	}

	@Test
	public void testCharacterHitPointsIncreaseBy5PerLevel10PointsForLevel3() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(3);
		assertEquals(15, myCharacter.getMaxHitPoints());
	}
	
	@Test
	public void testCharacterHitPointsIncreaseBy5PerLevel45PointsForLevel10() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(10);
		assertEquals(50, myCharacter.getMaxHitPoints());
	}
	
	//Test level up works with constitution bonus
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon12ModifierForLevel2() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(12);
		myCharacter.setLevel(2);
		assertEquals(6 + 6, myCharacter.getMaxHitPoints());
	}
	
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon20ModifierForLevel2() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(20);
		myCharacter.setLevel(2);
		assertEquals(10 + 10, myCharacter.getMaxHitPoints());
	}
	
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon1ModifierForLevel2() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(1);
		myCharacter.setLevel(2);
		assertEquals(1 + 0, myCharacter.getMaxHitPoints());
	}
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon12ModifierForLevel3() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(12);
		myCharacter.setLevel(3);
		assertEquals(6 + 12, myCharacter.getMaxHitPoints());
	}
	
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon20ModifierForLevel3() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(20);
		myCharacter.setLevel(3);
		assertEquals(10 + 20, myCharacter.getMaxHitPoints());
	}
	
	@Test
	public void testCharacterHitPointsIncreaseBy5PlusCon1ModifierForLevel3() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setConstitution(1);
		myCharacter.setLevel(3);
		assertEquals(1 + 0, myCharacter.getMaxHitPoints());
	}
	
	//Attack Roll Bonus for Level Up
	@Test
	public void testCharacterAttackRollBonusIncreasedBy1ForLevel2() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(2);
		assertEquals(1, myCharacter.getRollBonus());
	}
	
	@Test
	public void testCharacterAttackRollBonusIncreasedBy1ForLevel10() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(10);
		assertEquals(9, myCharacter.getRollBonus());
	}
	
	//Test Attack Bonus works with Level and Strength Bonus
	@Test
	public void testCharacterAttackRollBonusIncreasedLevel2AndStrength12() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(2);
		myCharacter.setStrength(12);
		assertEquals(2, myCharacter.getRollBonus());
	}
	
	@Test
	public void testCharacterAttackRollBonusIncreasedLevel2AndStrength20() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(2);
		myCharacter.setStrength(20);
		assertEquals(6, myCharacter.getRollBonus());
	}
	
	@Test
	public void testCharacterAttackRollBonusIncreasedLevel10AndStrength20() {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setLevel(10);
		myCharacter.setStrength(20);
		assertEquals(14, myCharacter.getRollBonus());
	}
	
}
