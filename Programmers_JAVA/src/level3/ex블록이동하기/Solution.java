package level3.ex블록이동하기;

import java.util.ArrayList;

class Solution {

	int length, grid[][];
	boolean[][][] visit;

	public int solution(int[][] board) {

		length = board.length;
		grid = board;
		visit = new boolean[length][length][2];

		ArrayList<int[]> prev, curr = new ArrayList<>();
		curr.add(new int[] { 0, 1, 0 });
		visit[0][1][0] = true;

		int move = 0;

		while (!curr.isEmpty()) {

			move++;
			prev = curr;
			curr = new ArrayList<>();

			for (int[] prevPosition : prev) {
				for (int[] nextPosition : nextAble(prevPosition)) {
					if (nextPosition[0] == length - 1 && nextPosition[1] == length - 1)
						return move;
					else
						curr.add(nextPosition);
				}
			}
		}

		return 0;
	}

	private ArrayList<int[]> nextAble(int[] position) {

		ArrayList<int[]> result = new ArrayList<>();
		int headRow = position[0], headCol = position[1], dir = position[2];
		int tailRow = headRow - dir, tailCol = headCol - 1 + dir;

		// check left
		if (isCoordValid(headRow, headCol - 1) && isCoordValid(tailRow, tailCol - 1)) {
			// move
			if (!visit[headRow][headCol - 1][dir]) {
				visit[headRow][headCol - 1][dir] = true;
				result.add(new int[] { headRow, headCol - 1, dir });
			}
			// turn
			if (dir == 1) {
				if (!visit[headRow][headCol][0]) {
					visit[headRow][headCol][0] = true;
					result.add(new int[] { headRow, headCol, 0 });
				}
				if (!visit[tailRow][tailCol][0]) {
					visit[tailRow][tailCol][0] = true;
					result.add(new int[] { tailRow, tailCol, 0 });
				}
			}
		}

		// check right
		if (isCoordValid(headRow, headCol + 1) && isCoordValid(tailRow, tailCol + 1)) {
			// move
			if (!visit[headRow][headCol + 1][dir]) {
				visit[headRow][headCol + 1][dir] = true;
				result.add(new int[] { headRow, headCol + 1, dir });
			}
			// turn
			if (dir == 1) {
				if (!visit[headRow][headCol + 1][0]) {
					visit[headRow][headCol + 1][0] = true;
					result.add(new int[] { headRow, headCol + 1, 0 });
				}
				if (!visit[tailRow][tailCol + 1][0]) {
					visit[tailRow][tailCol + 1][0] = true;
					result.add(new int[] { tailRow, tailCol + 1, 0 });
				}
			}
		}

		// check upper
		if (isCoordValid(headRow - 1, headCol) && isCoordValid(tailRow - 1, tailCol)) {
			// move
			if (!visit[headRow - 1][headCol][dir]) {
				visit[headRow - 1][headCol][dir] = true;
				result.add(new int[] { headRow - 1, headCol, dir });
			}
			// turn
			if (dir == 0) {
				if (!visit[headRow][headCol][1]) {
					visit[headRow][headCol][1] = true;
					result.add(new int[] { headRow, headCol, 1 });
				}
				if (!visit[tailRow][tailCol][1]) {
					visit[tailRow][tailCol][1] = true;
					result.add(new int[] { tailRow, tailCol, 1 });
				}
			}
		}

		// check lower
		if (isCoordValid(headRow + 1, headCol) && isCoordValid(tailRow + 1, tailCol)) {
			// move
			if (!visit[headRow + 1][headCol][dir]) {
				visit[headRow + 1][headCol][dir] = true;
				result.add(new int[] { headRow + 1, headCol, dir });
			}
			// turn
			if (dir == 0) {
				if (!visit[headRow + 1][headCol][1]) {
					visit[headRow + 1][headCol][1] = true;
					result.add(new int[] { headRow + 1, headCol, 1 });
				}
				if (!visit[tailRow + 1][tailCol][1]) {
					visit[tailRow + 1][tailCol][1] = true;
					result.add(new int[] { tailRow + 1, tailCol, 1 });
				}
			}
		}

		return result;
	}

	private boolean isCoordValid(int row, int col) {
		return 0 <= row && 0 <= col && row < length && col < length && grid[row][col] == 0;
	}
}