package level3.ex경주로건설;

class Solution {

	int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	int[][] board;
	int[][] costs;
	boolean[][] visit;
	int minCost;

	public int solution(int[][] board) {

		minCost = board.length * board[0].length * 600;
		this.board = board;
		costs = new int[board.length][board[0].length];
		visit = new boolean[board.length][board[0].length];

		dfs(0, 0, 0, 0, 'S');
		dfs(0, 0, 0, 1, 'S');

		return minCost;
	}

	public void dfs(int i, int j, int cost, int curDirect, char lastDirect) {

		if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] == 1 || visit[i][j]
				|| cost > minCost || (costs[i][j] != 0 && costs[i][j] + 500 < cost)) {
			return;
		} else if (i == board.length - 1 && j == board[i].length - 1) {
			minCost = Math.min(minCost, cost);
			return;
		} else {
			if (costs[i][j] == 0)
				costs[i][j] = cost;
			else
				costs[i][j] = Math.min(costs[i][j], cost);
			visit[i][j] = true;
			dfs(i + direction[curDirect][0], j + direction[curDirect][1], cost + 100, curDirect, 'S');
			int left = (curDirect + 1) % 4;
			int right = (curDirect + 3) % 4;
			if (lastDirect != 'L')
				dfs(i + direction[left][0], j + direction[left][1], cost + 600, left, 'L');
			if (lastDirect != 'R')
				dfs(i + direction[right][0], j + direction[right][1], cost + 600, right, 'R');
			visit[i][j] = false;
		}
	}
}