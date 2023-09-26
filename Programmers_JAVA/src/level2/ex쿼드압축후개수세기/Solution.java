package level2.ex쿼드압축후개수세기;

class Solution {

	public int[] solution(int[][] arr) {

		return dfs(arr, 0, arr.length, 0, arr[0].length, new int[2]);

	}

	private int[] dfs(int[][] arr, int row, int rowMax, int col, int colMax, int[] container) {

		int value = arr[row][col];
		boolean allMatch = true;

		for (int i = row; allMatch && i < rowMax; i++)
			for (int j = col; allMatch && j < colMax; j++)
				allMatch &= value == arr[i][j];

		if (allMatch) {
			container[value]++;
		} else {
			int rowMid = (row + rowMax) / 2, colMid = (col + colMax) / 2;
			dfs(arr, row, rowMid, col, colMid, container);
			dfs(arr, row, rowMid, colMid, colMax, container);
			dfs(arr, rowMid, rowMax, col, colMid, container);
			dfs(arr, rowMid, rowMax, colMid, colMax, container);
		}

		return container;
	}
}