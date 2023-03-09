package level1.ex바탕화면정리;

class Solution {
	public int[] solution(String[] wallpaper) {

		char[][] grid = new char[wallpaper.length][];
		for (int i = 0; i < wallpaper.length; i++)
			grid[i] = wallpaper[i].toCharArray();

		int minRow = 100, maxRow = -1, minCol = 100, maxCol = -1;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '#') {
					minRow = Math.min(minRow, row);
					maxRow = Math.max(maxRow, row);
					minCol = Math.min(minCol, col);
					maxCol = Math.max(maxCol, col);
				}
			}
		}

		return new int[] { minRow, minCol, maxRow + 1, maxCol + 1 };
	}
}