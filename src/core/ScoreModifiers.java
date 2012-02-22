package core;

import java.util.HashMap;
import java.util.Map;

public class ScoreModifiers {

//	private final static HashMap<Integer, Integer> scoreToModifier = initScoreToModifier();
//	
//	private static HashMap<Integer, Integer> initScoreToModifier() {
//		HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
//		newMap.put(1,-5);
//		newMap.put(2,-4);
//		newMap.put(3,-4);
//		newMap.put(4,-3);
//		newMap.put(5,-3);
//		newMap.put(6,-2);
//		newMap.put(7,-2);
//		newMap.put(8,-1);
//		newMap.put(9,-1);
//		newMap.put(10,0);
//		newMap.put(11,0);
//		newMap.put(12,1);
//		newMap.put(13,1);
//		newMap.put(14,2);
//		newMap.put(15,2);
//		newMap.put(16,3);
//		newMap.put(17,3);
//		newMap.put(18,4);
//		newMap.put(19,4);
//		newMap.put(20,5);
//		
//		return newMap;
//		
//	}
	

	
	public static int getAttribute(int desiredModifier) {
		return (desiredModifier + 4)*2;
	}
	
	public static int getModifier(int attributeScore) {
		return (attributeScore/2) - 5;
	}
}
