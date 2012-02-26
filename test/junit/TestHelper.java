package junit;

import core.EvercraftCharacter;

public class TestHelper {

	public static EvercraftCharacter createDefaultCharacter() {
		String defaultName = "Hasselhoff";
		return createCharacterWithName(defaultName);
	}

	public static EvercraftCharacter createCharacterWithName(String name) {
		return new EvercraftCharacter(name);
	}

	public static boolean combatSimulatorRoll(int roll) {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		return myCharacter.attack(myCharacter, roll);
	}

	public static boolean combatSimulatorStrAndRoll(int strength, int roll) {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		myCharacter.setStrength(strength);
		return myCharacter.attack(enemyCharacter, roll);
	}
}
