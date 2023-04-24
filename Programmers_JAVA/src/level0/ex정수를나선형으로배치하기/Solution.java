package level0.ex정수를나선형으로배치하기;

class Solution {

	final int[][] DIRECT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int[][] solution(int n) {

		int[][] answer = new int[n][n];

		int row = 0, col = 0, value = 0, d = 0;

		while (value < n * n) {

			answer[row][col] = ++value;

			if (row + DIRECT[d][0] < 0 || n <= row + DIRECT[d][0] || col + DIRECT[d][1] < 0 || n <= col + DIRECT[d][1]
					|| answer[row + DIRECT[d][0]][col + DIRECT[d][1]] != 0) {
				d = (d + 1) % 4;
			}

			row += DIRECT[d][0];
			col += DIRECT[d][1];

		}

		return answer;
	}
}