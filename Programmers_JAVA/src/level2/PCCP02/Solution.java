package level2.PCCP02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	int rowMax, colMax;
	int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int solution(int[][] land) {

		rowMax = land.length;
		colMax = land[0].length;

		int[][] areaNum = new int[rowMax][colMax];
		int no = 1;
		List<Integer> oils = new ArrayList<>();
		oils.add(0);

		for (int row = 0; row < rowMax; row++) {
			for (int col = 0; col < colMax; col++) {
				if (land[row][col] == 1 && areaNum[row][col] == 0) {
					oils.add(countOilBalance(land, row, col, areaNum, no++));
				}
			}
		}

		int answer = 0, temp = 0;
		boolean[] getOil = new boolean[no];

		for (int col = 0; col < colMax; col++) {
			Arrays.fill(getOil, false);
			temp = 0;
			for (int row = 0; row < rowMax; row++) {
				getOil[areaNum[row][col]] = true;
			}

			for (int i = 0; i < getOil.length; i++) {
				if (getOil[i]) {
					temp += oils.get(i);
				}
			}

			answer = Math.max(answer, temp);
		}

		return answer;
	}

	private int countOilBalance(int[][] land, int row, int col, int[][] areaNum, int no) {

		int oil = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });

		while (!queue.isEmpty()) {
			int[] coord = queue.poll();
			if (isCoordValid(coord) && land[coord[0]][coord[1]] == 1 && areaNum[coord[0]][coord[1]] == 0) {
				oil++;
				areaNum[coord[0]][coord[1]] = no;
				for (int i = 0; i < 4; i++) {
					queue.add(new int[] { coord[0] + d[i][0], coord[1] + d[i][1] });
				}
			}
		}

		return oil;
	}

	private boolean isCoordValid(int[] coord) {
		return isCoordValid(coord[0], coord[1]);
	}

	private boolean isCoordValid(int row, int col) {
		return 0 <= row && row < rowMax && 0 <= col && col < colMax;
	}
}