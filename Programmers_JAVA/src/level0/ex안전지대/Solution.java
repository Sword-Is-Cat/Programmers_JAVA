package level0.ex안전지대;

class Solution {

	int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	int rMax = 0, cMax = 0;

	public int solution(int[][] board) {

		rMax = board.length;
		cMax = board[0].length;
		int answer = rMax * cMax;

		for (int row = 0; row < rMax; row++) {
			for (int col = 0; col < cMax; col++) {
				if (board[row][col] == 1) {
					answer--;
					answer -= findMine(board, row, col);
				}
			}
		}
		return answer;
	}

	private int findMine(int[][] board, int row, int col) {
		int result = 0;
		for (int d = 0; d < dir.length; d++) {
			int r = row + dir[d][0], c = col + dir[d][1];
			if (0 <= r && 0 <= c && r < rMax && c < cMax && board[r][c] == 0) {
				result++;
				board[r][c] = -1;
			}
		}
		return result;
	}
}