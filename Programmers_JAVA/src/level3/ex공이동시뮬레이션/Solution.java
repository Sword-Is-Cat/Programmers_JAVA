package level3.ex공이동시뮬레이션;

class Solution {
	public long solution(int n, int m, int x, int y, int[][] queries) {

		int[] coord = { x, y, x, y };

		for (int i = queries.length - 1; i >= 0; i--) {

			int[] query = queries[i];

			int direct = query[0];
			int dx = query[1];

			switch (direct) {
			case 0:
				coord[1] += coord[1] == 0 ? 0 : dx;
				coord[3] += dx;
				break;
			case 1:
				coord[1] -= dx;
				coord[3] -= coord[3] == m - 1 ? 0 : dx;
				break;
			case 2:
				coord[0] += coord[0] == 0 ? 0 : dx;
				coord[2] += dx;
				break;
			case 3:
				coord[0] -= dx;
				coord[2] -= coord[2] == n - 1 ? 0 : dx;
				break;
			default:
				break;
			}

			if (!validateCoord(n, m, coord))
				return 0;

		}

		return (long) (coord[2] - coord[0] + 1) * (long) (coord[3] - coord[1] + 1);
	}

	boolean validateCoord(int n, int m, int[] coord) {

		coord[0] = Math.max(coord[0], 0);
		coord[1] = Math.max(coord[1], 0);
		coord[2] = Math.min(coord[2], n - 1);
		coord[3] = Math.min(coord[3], m - 1);

		return coord[0] < n && coord[1] < m && coord[2] >= 0 && coord[3] >= 0;
	}
}