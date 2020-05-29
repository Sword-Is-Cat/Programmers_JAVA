package level4.ex게임맵최단거리;
//넓이우선탐색 : 정-답

import java.util.HashSet;
import java.util.Set;

class Solution2 {

	public int solution(int[][] maps) {

		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visit = new boolean[n][m];

		Set<int[]> set = new HashSet<>();
		int[] coord = { 0, 0 };
		set.add(coord);
		int distance = 1;

		Set<int[]> temp;

		while (set.size() > 0) {

			temp = new HashSet<>();
			distance++;

			for (int[] c : set) {
				if (c[0] > 0 && maps[c[0] - 1][c[1]] != 0 && !visit[c[0] - 1][c[1]]) {
					int[] tempC = { c[0] - 1, c[1] };
					temp.add(tempC);
					visit[c[0] - 1][c[1]] = true;
				}
				if (c[0] + 1 < n && maps[c[0] + 1][c[1]] != 0 && !visit[c[0] + 1][c[1]]) {
					int[] tempC = { c[0] + 1, c[1] };
					if (c[0] + 1 == n - 1 && c[1] == m - 1)
						return distance;
					temp.add(tempC);
					visit[c[0] + 1][c[1]] = true;
				}
				if (c[1] > 0 && maps[c[0]][c[1] - 1] != 0 && !visit[c[0]][c[1] - 1]) {
					int[] tempC = { c[0], c[1] - 1 };
					temp.add(tempC);
					visit[c[0]][c[1] - 1] = true;
				}
				if (c[1] + 1 < m && maps[c[0]][c[1] + 1] != 0 && !visit[c[0]][c[1] + 1]) {
					int[] tempC = { c[0], c[1] + 1 };
					if (c[0] == n - 1 && c[1] + 1 == m - 1)
						return distance;
					temp.add(tempC);
					visit[c[0]][c[1] + 1] = true;
				}
			}

			set = temp;

		}

		return -1;

	}
}