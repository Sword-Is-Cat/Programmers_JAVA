package level0.ex안전지대;

class Solution {
	public int solution(int[][] board) {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == 1) {
					findMine(board, row, col);
				}
			}
		}

		int answer = 0;

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == 0) {
					answer++;
				}
			}
		}

		return answer;
	}

	void findMine(int[][] board, int row, int col) {

		if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 0)
			board[row - 1][col - 1] = 2;

		if (row - 1 >= 0 && board[row - 1][col] == 0)
			board[row - 1][col] = 2;

		if (row - 1 >= 0 && col + 1 < board.length && board[row - 1][col + 1] == 0)
			board[row - 1][col + 1] = 2;

		if (row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1] == 0)
			board[row + 1][col - 1] = 2;

		if (row + 1 < board.length && board[row + 1][col] == 0)
			board[row + 1][col] = 2;

		if (row + 1 < board.length && col + 1 < board.length && board[row + 1][col + 1] == 0)
			board[row + 1][col + 1] = 2;

		if (col - 1 >= 0 && board[row][col - 1] == 0)
			board[row][col - 1] = 2;

		if (col + 1 < board.length && board[row][col + 1] == 0)
			board[row][col + 1] = 2;

	}
}