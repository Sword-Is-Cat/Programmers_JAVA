package level2.ex게임맵최단거리;

import java.util.HashSet;
import java.util.Set;

class Solution {

	int[][] DIRECTION = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int solution(int[][] maps) {

		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visit = new boolean[n][m];

		Set<int[]> set = new HashSet<>();
		set.add(new int[] { 0, 0 });
		int distance = 1;

		Set<int[]> nextSet;

		while (set.size() > 0) {

			nextSet = new HashSet<>();
			distance++;

			for (int[] point : set) {

				for (int caseNo = 0; caseNo < 4; caseNo++) {

					int row = point[0] + DIRECTION[caseNo][0];
					int col = point[1] + DIRECTION[caseNo][1];

					if (0 <= row && row < n && 0 <= col && col < m) {
						
						if (maps[row][col] == 1 && !visit[row][col]) {
							
							visit[row][col] = true;
							nextSet.add(new int[] { row, col });
							
							if (row + 1 == n && col + 1 == m)
								return distance;
						}
					}
				}
			}
			set = nextSet;
		}
		return -1;
	}
}