package core;

public class ScoreModifiers {
	
	public static int getAttribute(int desiredModifier) {
		return (desiredModifier + 4)*2;
	}
	
	public static int getModifier(int attributeScore) {
		return (attributeScore/2) - 5;
	}
}
