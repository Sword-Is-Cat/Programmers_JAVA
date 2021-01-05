package level2.ex가장큰정사각형찾기;

class Solution {
	public int solution(int[][] board) {

		if (board.length == 1 || board[0].length == 1)
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++)
					if (board[i][j] == 1)
						return 1;

		int max = 0;

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					int value = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
					board[i][j] = value;
					max = Math.max(value, max);
				}
			}
		}

		return max * max;
	}
}