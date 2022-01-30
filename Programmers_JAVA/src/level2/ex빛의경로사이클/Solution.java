package level2.ex빛의경로사이클;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

	public int[] solution(String[] grid) {

		int[][] dirArr = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int maxRow = grid.length;
		int maxCol = grid[0].length();

		boolean[][][] check = new boolean[maxRow][maxCol][4];

		List<Integer> list = new ArrayList<>();

		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {
				for (int dir = 0; dir < 4; dir++) {
					int result = 0;

					int tempRow = row;
					int tempCol = col;
					int tempDir = dir;

					while (!check[tempRow][tempCol][tempDir]) {

						result++;
						check[tempRow][tempCol][tempDir] = true;
						char dirChar = grid[tempRow].charAt(tempCol);

						switch (dirChar) {
						case 'L':
							tempDir = (tempDir + 3) % 4;
							break;
						case 'R':
							tempDir = (tempDir + 1) % 4;
							break;
						}

						tempRow += dirArr[tempDir][0];
						tempCol += dirArr[tempDir][1];

						if (tempRow < 0)
							tempRow += maxRow;
						if (tempCol < 0)
							tempCol += maxCol;
						if (tempRow == maxRow)
							tempRow -= maxRow;
						if (tempCol == maxCol)
							tempCol -= maxCol;

					}

					if (result != 0)
						list.add(result);
				}
			}
		}

		Collections.sort(list);
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		return answer;
	}
}