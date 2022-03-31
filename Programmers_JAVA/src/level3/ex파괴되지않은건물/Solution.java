package level3.ex파괴되지않은건물;

class Solution {
	public int solution(int[][] board, int[][] skill) {

		int height = board.length;
		int width = board[0].length;

		int[][] skilled = skilledBoard(height, width, skill);
		int cntBuild = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] + skilled[i][j] > 0)
					cntBuild++;
			}
		}

		return cntBuild;
	}

	int[][] skilledBoard(int height, int width, int[][] skill) {

		int[][] result = new int[height][width];

		for (int[] sk : skill) {
			int value = sk[0] == 2 ? sk[5] : sk[5] * -1;
			result[sk[1]][sk[2]] += value;
			if (sk[3] + 1 < height)
				result[sk[3] + 1][sk[2]] -= value;
			if (sk[4] + 1 < width)
				result[sk[1]][sk[4] + 1] -= value;
			if (sk[3] + 1 < height && sk[4] + 1 < width)
				result[sk[3] + 1][sk[4] + 1] += value;
		}

		for (int i = 0; i < height; i++) {
			for (int j = 1; j < width; j++) {
				result[i][j] += result[i][j - 1];
			}
		}

		for (int j = 0; j < width; j++) {
			for (int i = 1; i < height; i++) {
				result[i][j] += result[i - 1][j];
			}
		}

		return result;
	}
}