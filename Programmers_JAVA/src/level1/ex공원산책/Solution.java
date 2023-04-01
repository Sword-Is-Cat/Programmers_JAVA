package level1.ex공원산책;

import java.util.HashMap;

class Solution {

	int rowLength, colLength;
	char[][] grid;
	HashMap<Character, Integer> dictionary;
	int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int[] solution(String[] park, String[] routes) {

		dictionary = buildDictionary();

		rowLength = park.length;
		colLength = park[0].length();
		grid = new char[rowLength][];
		for (int i = 0; i < rowLength; i++)
			grid[i] = park[i].toCharArray();

		int[] coord = findStart();

		for (String route : routes) {
			move(coord, route);
		}

		return coord;
	}

	private void move(int[] coord, String moveQuery) {

		int d = dictionary.get(moveQuery.charAt(0)), distance = moveQuery.charAt(2) - '0';
		int oriRow = coord[0], oriCol = coord[1];

		while (distance-- > 0) {

			coord[0] += direct[d][0];
			coord[1] += direct[d][1];
			if (coord[0] < 0 || coord[0] == rowLength || coord[1] < 0 || coord[1] == colLength
					|| grid[coord[0]][coord[1]] == 'X') {
				coord[0] = oriRow;
				coord[1] = oriCol;
				return;
			}

		}

	}

	private int[] findStart() {
		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				if (grid[row][col] == 'S')
					return new int[] { row, col };
			}
		}
		return null;
	}

	private HashMap<Character, Integer> buildDictionary() {

		HashMap<Character, Integer> map = new HashMap<>();

		// 방향 동:0 / 서:1 / 남:2 / 북:3
		map.put('E', 0);
		map.put('W', 1);
		map.put('S', 2);
		map.put('N', 3);

		return map;
	}
}