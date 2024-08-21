package level4.ex튜브의소개팅;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {

	Coord[][] coords;
	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int[] solution(int m, int n, int s, int[][] time_map) {

		coords = new Coord[m][n];
		HashMap<Coord, Long> prev, curr = new HashMap<>();
		curr.put(getCoord(0, 0), 0L);

		int move = 0;

		while (curr.size() > 0) {

			prev = curr;
			curr = new HashMap<>();

			for (Entry<Coord, Long> entry : prev.entrySet()) {

				Coord coord = entry.getKey();
				long talked = entry.getValue();

				if (talked > s)
					continue;
				if (coord.row == m - 1 && coord.col == n - 1)
					return new int[] { move, (int) talked };

				for (int d = 0; d < dir.length; d++) {
					int row = coord.row + dir[d][0], col = coord.col + dir[d][1];

					if (isValid(row, col) && time_map[row][col] != -1) {

						Coord next = getCoord(row, col);
						curr.compute(next, (k, v) -> v == null ? (talked + time_map[row][col])
								: (Math.min(v, talked + time_map[row][col])));

					}

				}
			}

			move++;

		}

		return null;
	}

	private boolean isValid(int row, int col) {
		return 0 <= row && 0 <= col && row < coords.length && col < coords[row].length;
	}

	private Coord getCoord(int row, int col) {
		if (coords[row][col] == null)
			coords[row][col] = new Coord(row, col);
		return coords[row][col];
	}

	class Coord {
		int row, col;

		Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

}