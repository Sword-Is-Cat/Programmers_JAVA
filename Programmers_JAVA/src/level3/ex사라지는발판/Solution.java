package level3.ex사라지는발판;

class Solution {

	int[][] map;
	int rowEnd, colEnd;
	int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public int solution(int[][] board, int[] aloc, int[] bloc) {

		map = board;
		rowEnd = map.length;
		colEnd = map[0].length;

		return Math.abs(expect(aloc[0], aloc[1], bloc[0], bloc[1], true));
	}

	/**
	 * expect the result
	 * 
	 * @param ar      player A's row
	 * @param ac      player A's col
	 * @param br      player B's row
	 * @param bc      player B's col
	 * @param isAturn player A's turn? or not?
	 * @return min step to win or ( -1 * max step ) to lose when cannot win
	 */
	protected int expect(int ar, int ac, int br, int bc, boolean isAturn) {

		Integer[] expects = new Integer[4];
		int row = isAturn ? ar : br, col = isAturn ? ac : bc;

		for (int di = 0; di < 4; di++) {

			// get next coord of player who has turn
			int nxtRow = row + dr[di], nxtCol = col + dc[di];

			// if player can't move to here, neglect result as null
			if (!isSafeCoord(nxtRow, nxtCol)) {
				continue;
			}
			// player can move guaranteed

			// if player can move and win this turn
			if (ar == br && ac == bc) {
				expects[di] = 1;
				continue;
			}

			toggle(row, col);

			// expect next turn
			int expect = -1
					* (isAturn ? expect(nxtRow, nxtCol, br, bc, !isAturn) : expect(ar, ac, nxtRow, nxtCol, !isAturn));
			expect += expect < 0 ? -1 : 1;
			expects[di] = expect;

			toggle(row, col);

		}

		int winMin = 100, loseMin = 100;

		for (int di = 0; di < 4; di++) {
			if (expects[di] != null) {
				if (expects[di] > 0)
					winMin = Math.min(winMin, expects[di]);
				else
					loseMin = Math.min(loseMin, expects[di]);
			}
		}

		if (winMin == 100 && loseMin == 100)
			// no expect data = cannot move(lose instantly)
			return 0;
		if (winMin == 100)
			// no win expect = lose
			return loseMin;
		else
			// can win
			return winMin;
	}

	/**
	 * check player can heading to Coord
	 * 
	 * @param row player's row
	 * @param col player's col
	 * @return
	 */
	protected boolean isSafeCoord(int row, int col) {
		return 0 <= row && 0 <= col && row < rowEnd && col < colEnd && map[row][col] == 1;
	}

	/**
	 * toggle map's value 0 and 1
	 * 
	 * @param row
	 * @param col
	 */
	protected void toggle(int row, int col) {
		map[row][col] = 1 - map[row][col];
	}
}