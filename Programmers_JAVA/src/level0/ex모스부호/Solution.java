package level0.ex모스부호;

import java.util.HashMap;

class Solution {
	public String solution(String letter) {

		HashMap<String, String> morseMap = buildMorseMap();

		StringBuilder sb = new StringBuilder();

		for (String morse : letter.split(" "))
			sb.append(morseMap.get(morse));

		return sb.toString();
	}

	HashMap<String, String> buildMorseMap() {

		HashMap<String, String> map = new HashMap<>();

		map.put(".-", "a");
		map.put("-...", "b");
		map.put("-.-.", "c");
		map.put("-..", "d");
		map.put(".", "e");
		map.put("..-.", "f");
		map.put("--.", "g");
		map.put("....", "h");
		map.put("..", "i");
		map.put(".---", "j");
		map.put("-.-", "k");
		map.put(".-..", "l");
		map.put("--", "m");
		map.put("-.", "n");
		map.put("---", "o");
		map.put(".--.", "p");
		map.put("--.-", "q");
		map.put(".-.", "r");
		map.put("...", "s");
		map.put("-", "t");
		map.put("..-", "u");
		map.put("...-", "v");
		map.put(".--", "w");
		map.put("-..-", "x");
		map.put("-.--", "y");
		map.put("--..", "z");

		return map;
	}
}