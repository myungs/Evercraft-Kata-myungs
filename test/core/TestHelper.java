package core;

public class TestHelper {
	
	public static EvercraftCharacter createDefaultCharacter() {
		String defaultName = "Hasselhoff";
		return createCharacterWithName(defaultName); 
	}
	
	public static EvercraftCharacter createCharacterWithName(String name) {
		return new EvercraftCharacter(name);
	}

	public static boolean attackedWithRoll(int roll) {
		EvercraftCharacter myCharacter = TestHelper.createDefaultCharacter();
		EvercraftCharacter enemyCharacter = TestHelper.createDefaultCharacter();
		return enemyCharacter.attackedBy(myCharacter, roll);
	}
}
