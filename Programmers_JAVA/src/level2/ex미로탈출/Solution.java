package level2.ex미로탈출;

import java.util.ArrayList;

class Solution {

	char[][] map;
	int rowEnd, colEnd;

	int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public int solution(String[] maps) {

		rowEnd = maps.length;
		colEnd = maps[0].length();

		map = new char[rowEnd][];
		for (int i = 0; i < rowEnd; i++)
			map[i] = maps[i].toCharArray();

		int way1 = findWay('S', 'L');
		int way2 = findWay('L', 'E');

		return way1 == -1 || way2 == -1 ? -1 : way1 + way2;
	}

	protected int findWay(char s, char e) {

		int[] stt = findCoord(s), end = findCoord(e);
		boolean[][] visit = new boolean[rowEnd][colEnd];

		ArrayList<int[]> prev, curr = new ArrayList<>();
		curr.add(stt);
		int move = 0;

		while (!visit[end[0]][end[1]] && !curr.isEmpty()) {

			prev = curr;
			curr = new ArrayList<>();

			for (int[] coord : prev) {

				for (int di = 0; di < 4; di++) {
					int row = coord[0] + dr[di], col = coord[1] + dc[di];
					if (isSafe(row, col) && !visit[row][col]) {
						visit[row][col] = true;
						curr.add(new int[] { row, col });
					}
				}
			}

			move++;
		}
		return curr.isEmpty() ? -1 : move;
	}

	protected int[] findCoord(char c) {
		for (int row = 0; row < rowEnd; row++) {
			for (int col = 0; col < colEnd; col++) {
				if (map[row][col] == c) {
					return new int[] { row, col };
				}
			}
		}
		return null;
	}

	protected boolean isSafe(int[] coord) {
		return isSafe(coord[0], coord[1]);
	}

	protected boolean isSafe(int row, int col) {
		return 0 <= row && 0 <= col && row < rowEnd && col < colEnd && map[row][col] != 'X';
	}
}