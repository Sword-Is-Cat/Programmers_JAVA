package level3.ex고고학최고의발견;

class Solution {

	public int solution(int[][] clockHands) {

		int max = (int) Math.pow(4, clockHands.length);
		int answer = Integer.MAX_VALUE;

		for (int caseNo = 0; caseNo < max; caseNo++) {
			answer = Math.min(answer, caseCheck(copyArray(clockHands), caseNo));
		}

		return answer;
	}

	int caseCheck(int[][] grid, int caseNo) {

		int cnt = 0;

		int idx = 0;
		while (idx < grid.length && caseNo > 0) {
			cnt += caseNo % 4;
			turnClock(grid, 0, idx, caseNo % 4);
			caseNo /= 4;
			idx++;
		}

		for (int row = 1; row < grid.length; row++) {

			for (int col = 0; col < grid[row].length; col++) {

				int turnCnt = (4 - grid[row - 1][col]) % 4;
				cnt += turnCnt;
				turnClock(grid, row, col, turnCnt);
			}
		}

		int row = grid.length - 1;
		for (int col = 0; col < grid[0].length; col++) {

			if (grid[row][col] > 0)
				return Integer.MAX_VALUE;
		}

		return cnt;
	}

	void turnClock(int[][] grid, int row, int col, int cnt) {

		if (row < 0 || col < 0 || row >= grid.length || col >= grid.length)
			return;

		grid[row][col] = (grid[row][col] + cnt) % 4;

		if (row > 0)
			grid[row - 1][col] = (grid[row - 1][col] + cnt) % 4;

		if (col > 0)
			grid[row][col - 1] = (grid[row][col - 1] + cnt) % 4;

		if (row < grid.length - 1)
			grid[row + 1][col] = (grid[row + 1][col] + cnt) % 4;

		if (col < grid.length - 1)
			grid[row][col + 1] = (grid[row][col + 1] + cnt) % 4;

	}

	int[][] copyArray(int[][] array) {

		int[][] result = new int[array.length][];

		for (int i = 0; i < result.length; i++)
			result[i] = array[i].clone();

		return result;
	}
}