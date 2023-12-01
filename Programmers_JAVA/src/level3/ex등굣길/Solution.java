package level3.ex등굣길;

class Solution {
	public int solution(int m, int n, int[][] puddles) {

		final int mod = (int) 1e9 + 7;
		int[][] field = new int[m][n];

		field[0][0] = 1;
		for (int[] puddle : puddles) {
			field[puddle[0] - 1][puddle[1] - 1] = -1;
		}

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (row + col == 0 || field[row][col] == -1)
					continue;
				field[row][col] += (getValue(field, row - 1, col) + getValue(field, row, col - 1)) % mod;
			}
		}
		return field[m - 1][n - 1];
	}

	private int getValue(int[][] field, int row, int col) {
		return row < 0 || col < 0 || field[row][col] == -1 ? 0 : field[row][col];
	}

}