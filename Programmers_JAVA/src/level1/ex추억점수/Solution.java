package level1.ex추억점수;

import java.util.HashMap;

class Solution {

	HashMap<String, Integer> map;

	public int[] solution(String[] name, int[] yearning, String[][] photo) {

		map = mapping(name, yearning);

		int[] ans = new int[photo.length];

		for (int i = 0; i < photo.length; i++)
			ans[i] = calcPoint(photo[i]);

		return ans;
	}

	private int calcPoint(String[] group) {
		int point = 0;
		for (String one : group)
			point += map.getOrDefault(one, 0);
		return point;
	}

	private HashMap<String, Integer> mapping(String[] keys, int[] values) {

		HashMap<String, Integer> myMap = new HashMap<>();

		for (int i = 0; i < keys.length; i++)
			myMap.put(keys[i], values[i]);

		return myMap;
	}
}