package SkillCheck_level3.Q1;

class Solution {

	int MOD = 20170805;
	int[][] map;
	int[][][] result;

	public int solution(int m, int n, int[][] cityMap) {

		map = cityMap;
		result = new int[m][n][];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = proc(i, j);
			}
		}

		return (result[m - 1][n - 1][0] + result[m - 1][n - 1][1]) % MOD;
	}

	private int[] proc(int m, int n) {

		int[] temp = new int[2];

		if (map[m][n] == 1)
			return temp;

		if (m == 0 && n == 0) {
			temp[0] = 1;
			temp[1] = 1;
		} else if (m == 0) {
			temp[1] = result[m][n - 1][1];
		} else if (n == 0) {
			temp[0] = result[m - 1][n][0];
		} else {
			temp[0] = result[m - 1][n][0];
			if (map[m - 1][n] == 0)
				temp[0] += result[m - 1][n][1];
			temp[1] = result[m][n - 1][1];
			if (map[m][n - 1] == 0)
				temp[1] += result[m][n - 1][0];
			temp[0] %= MOD;
			temp[1] %= MOD;
		}

		return temp;
	}

}