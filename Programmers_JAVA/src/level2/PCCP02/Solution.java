package level2.PCCP02;

import java.util.Arrays;

class Solution {

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int maxRow, maxCol;

	public int solution(int[][] land) {

		maxRow = land.length;
		maxCol = land[0].length;

		int[][] areaNum = new int[maxRow][maxCol];
		int areaNo = 0;

		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				if (land[row][col] == 1 && areaNum[row][col] == 0) {
					markArea(land, areaNum, row, col, ++areaNo);
				}
			}
		}

		int[] areaOil = new int[areaNo + 1];

		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				if (areaNum[row][col] != 0) {
					areaOil[areaNum[row][col]]++;
				}
			}
		}

		boolean[] visit = new boolean[areaOil.length];
		int answer = 0, temp = 0;

		for (int col = 0; col < maxCol; col++) {

			Arrays.fill(visit, false);
			temp = 0;

			for (int row = 0; row < maxRow; row++) {
				int area = areaNum[row][col];
				if (area != 0 && !visit[area]) {
					visit[area] = true;
					temp += areaOil[area];
				}
			}
			answer = Math.max(answer, temp);

		}

		return answer;
	}

	private void markArea(int[][] land, int[][] areaNum, int row, int col, int areaNo) {

		if (row < 0 || row == maxRow || col < 0 || col == maxCol)
			return;

		if (land[row][col] == 0 || areaNum[row][col] != 0)
			return;

		areaNum[row][col] = areaNo;

		for (int d = 0; d < dir.length; d++) {
			markArea(land, areaNum, row + dir[d][0], col + dir[d][1], areaNo);
		}

	}

}