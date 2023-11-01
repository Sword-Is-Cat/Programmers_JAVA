package level1.ex공원산책;

class Solution {
	public int[] solution(String[] park, String[] routes) {
		int[] coord = findStartCoord(park);
		for (String route : routes) {
			coord = executeMoveQuery(park, route, coord);
		}
		return coord;
	}

	private int[] findStartCoord(String[] park) {
		for (int r = 0; r < park.length; r++) {
			for (int c = 0; c < park[r].length(); c++) {
				if (park[r].charAt(c) == 'S') {
					return new int[] { r, c };
				}
			}
		}
		return null;
	}

	private int[] executeMoveQuery(String[] park, String query, int[] coord) {

		char dir = query.charAt(0);
		int distance = query.charAt(2) - '0';

		int dRow = dir == 'S' ? 1 : dir == 'N' ? -1 : 0;
		int dCol = dir == 'E' ? 1 : dir == 'W' ? -1 : 0;

		int row = coord[0], col = coord[1];

		while (distance-- > 0) {
			row += dRow;
			col += dCol;
			if (row < 0 || park.length <= row || col < 0 || col <= park[row].length() || park[row].charAt(col) == 'X')
				return coord;
		}

		return new int[] { row, col };
	}
}