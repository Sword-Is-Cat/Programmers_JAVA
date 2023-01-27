package level2.ex무인도여행;

import java.util.ArrayList;

class Solution {
	public int[] solution(String[] maps) {

		char[][] map = new char[maps.length][];
		boolean[][] visit = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int row = 0; row < maps.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				int rst = areaSearch(map, visit, row, col);
				if (rst > 0)
					list.add(rst);
			}
		}

		list.sort((a, b) -> a - b);
		// list가 비었다면 [-1] 반환, 아니라면 list를 array로 바꾸어 반환
		return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
	}

	protected int areaSearch(char[][] map, boolean[][] visit, int row, int col) {

		// index 유효성 체크
		if (row < 0 || col < 0 || row == map.length || col == map[row].length)
			return 0;

		// 기 처리여부 체크, 바다/육지 체크
		if (visit[row][col] || map[row][col] == 'X')
			return 0;

		visit[row][col] = true;

		int rst = map[row][col] - '0';

		rst += areaSearch(map, visit, row + 1, col);
		rst += areaSearch(map, visit, row - 1, col);
		rst += areaSearch(map, visit, row, col + 1);
		rst += areaSearch(map, visit, row, col - 1);

		return rst;
	}
}