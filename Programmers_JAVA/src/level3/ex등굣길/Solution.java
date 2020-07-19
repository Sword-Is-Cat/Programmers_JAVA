package level3.ex등굣길;

class Solution {

	int m;
	int n;
	Integer[][] map;

	public int solution(int m, int n, int[][] puddles) {

		this.m = m;
		this.n = n;

		map = new Integer[m][n];

		map[0][0] = 1;

		for (int[] arr : puddles) {
			map[arr[0] - 1][arr[1] - 1] = 0;
		}

		for (int i = 1; i < m + n - 1; i++)
			process(i);

		return map[m - 1][n - 1];
	}

	public void process(int depth) {

		for (int i = 0; i <= depth; i++) {

			int j = depth - i;

			if (i >= 0 && i < m && j >= 0 && j < n) {

				if (map[i][j] == null) {

					if (i == 0) {
						map[i][j] = map[i][j - 1];
					} else if (j == 0) {
						map[i][j] = map[i - 1][j];
					} else {
						map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
					}
				}
			}
		}
	}
}