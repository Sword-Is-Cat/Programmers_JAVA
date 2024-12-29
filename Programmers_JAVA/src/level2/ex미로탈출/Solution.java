package level2.ex미로탈출;

import java.util.ArrayDeque;

class Solution {

	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int solution(String[] maps) {

		int rMax = maps.length, cMax = maps[0].length();
		char[][] grid = new char[rMax][];
		int[] stt = null, lev = null, end = null;

		for (int i = 0; i < rMax; i++)
			grid[i] = maps[i].toCharArray();

		for (int r = 0; r < rMax; r++) {
			for (int c = 0; c < cMax; c++) {
				switch (grid[r][c]) {
				case 'S':
					stt = new int[] { r, c };
					break;
				case 'L':
					lev = new int[] { r, c };
					break;
				case 'E':
					end = new int[] { r, c };
					break;
				}
			}
		}

		int dist1 = calcDistance(stt, lev, grid);
		if (dist1 == -1)
			return -1;

		int dist2 = calcDistance(lev, end, grid);
		if (dist2 == -1)
			return -1;

		return dist1 + dist2;
	}

	private int calcDistance(int[] from, int[] to, char[][] grid) {
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(from);
		boolean[][] visit = new boolean[grid.length][grid[0].length];
		visit[from[0]][from[1]] = true;
		int distance = 0;

		while (!queue.isEmpty()) {
			int loop = queue.size();
			while (loop-- > 0) {
				int[] coord = queue.poll();
				if (coord[0] == to[0] && coord[1] == to[1])
					return distance;
				for (int d = 0; d < dir.length; d++) {
					int r = coord[0] + dir[d][0], c = coord[1] + dir[d][1];
					if (isValid(r, c, grid.length, grid[0].length) && grid[r][c] != 'X' && !visit[r][c]) {
						visit[r][c] = true;
						queue.add(new int[] { r, c });
					}
				}
			}
			distance++;
		}

		return -1;
	}

	private boolean isValid(int row, int col, int rMax, int cMax) {
		return row >= 0 && col >= 00 && row < rMax && col < cMax;
	}
}