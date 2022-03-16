package level3.리틀프렌즈사천성;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	final String IMPOSSIBLE = "IMPOSSIBLE";
	final char EMPTY_CHAR = ' ';

	public String solution(int m, int n, String[] board) {

		char[][] grid = new char[m][];
		for (int i = 0; i < m; i++) {
			grid[i] = board[i].toCharArray();
		}

		Map<Character, int[]> map = new HashMap<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char ch = grid[i][j];
				if (ch != '.' && ch != '*') {
					if (!map.containsKey(ch)) {
						map.put(ch, new int[] { i, j, 0, 0 });
					} else {
						int[] temp = map.get(ch);
						temp[2] = i;
						temp[3] = j;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		char check = '-';

		while (check != EMPTY_CHAR) {
			check = method(grid, map);
			if (check != EMPTY_CHAR) {
				sb.append(check);
			}
			System.out.println(check);
		}

		return map.isEmpty() ? sb.toString() : IMPOSSIBLE;
	}

	char method(char[][] grid, Map<Character, int[]> map) {

		Queue<Character> que = new PriorityQueue<>();

		for (char ch : map.keySet()) {
			int[] coord = map.get(ch);

			boolean flag = true;
			int row = -1;
			int col = -1;
			for (row = coord[0], col = coord[1]; row != coord[2]; row += (coord[2] - coord[0]) > 0 ? 1 : -1) {
				if (!flag)
					break;
				flag &= grid[row][col] == '.' || grid[row][col] == ch;
			}
			for (row = coord[2], col = coord[1]; col != coord[3]; col += (coord[3] - coord[1]) > 0 ? 1 : -1) {
				if (!flag)
					break;
				flag &= grid[row][col] == '.' || grid[row][col] == ch;
			}

			if (flag) {
				que.add(ch);
			} else {
				flag = true;
				for (row = coord[0], col = coord[1]; col != coord[3]; col += (coord[3] - coord[1]) > 0 ? 1 : -1) {
					if (!flag)
						break;
					flag &= grid[row][col] == '.' || grid[row][col] == ch;
				}
				for (row = coord[0], col = coord[3]; row != coord[2]; row += (coord[2] - coord[0]) > 0 ? 1 : -1) {
					if (!flag)
						break;
					flag &= grid[row][col] == '.' || grid[row][col] == ch;
				}
				if (flag) {
					que.add(ch);
				}
			}

		}

		char ch = que.isEmpty() ? EMPTY_CHAR : que.poll();
		if (ch != EMPTY_CHAR) {
			int[] temp = map.get(ch);
			grid[temp[0]][temp[1]] = '.';
			grid[temp[2]][temp[3]] = '.';
			map.remove(ch);
		}
		return ch;
	}

	public static void main(String[] args) {
		new Solution().solution(3, 3, new String[] { "DBA", "C*A", "CDB" });
	}
}