package level0.ex이차원배열대각선순회하기;

class Solution {
	public int solution(int[][] board, int k) {
		int answer = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				answer += i + j <= k ? board[i][j] : 0;
			}
		}
		return answer;
	}
}