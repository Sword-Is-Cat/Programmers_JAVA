package level3.ex2차원동전뒤집기;

class Solution {

	int max = Integer.MAX_VALUE;

	public int solution(int[][] grid, int[][] target) {

		// [0] 두 2차배열을 두 배열의 차를 나타내는 하나의 배열로 변경
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				grid[row][col] ^= target[row][col];
			}
		}

		int temp = dfs(grid, 0, 0);

		return temp == max ? -1 : temp;
	}

	public int dfs(int[][] grid, int col, int chng) {

		int temp = max;

		if (col < grid[0].length) {

			temp = Math.min(temp, dfs(grid, col + 1, chng));

			for (int i = 0; i < grid.length; i++)
				grid[i][col] ^= 1;

			temp = Math.min(temp, dfs(grid, col + 1, chng + 1));

			for (int i = 0; i < grid.length; i++)
				grid[i][col] ^= 1;

		} else {

			int result = 0;

			for (int[] arr : grid) {
				for (int i = 1; i < arr.length; i++)
					if (arr[i] != arr[0])
						return max;
				result += arr[0];
			}
			return result + chng;
		}
		return temp;
	}
}