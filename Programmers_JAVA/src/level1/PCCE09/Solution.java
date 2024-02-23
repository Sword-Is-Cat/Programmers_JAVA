package level1.PCCE09;

class Solution {
	public int solution(String[][] board, int h, int w) {

		int n = board.length;
		int count = 0;

		int[] dh = { 0, 1, -1, 0 }, dw = { 1, 0, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int h_check = h + dh[i], w_check = w + dw[i];
			if (0 <= h_check && h_check < n && 0 <= w_check && w_check < n) {
				if (board[h][w].equals(board[h_check][w_check])) {
					count++;
				}
			}
		}

		return count;
	}
}