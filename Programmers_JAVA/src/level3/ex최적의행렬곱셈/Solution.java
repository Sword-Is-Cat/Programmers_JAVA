package level3.ex최적의행렬곱셈;

class Solution {

	int[][] grid;
	int[][] cnt;

	public int solution(int[][] matrix_sizes) {

		grid = matrix_sizes;
		int size = grid.length;
		cnt = new int[size][size];

		return calc(0, size - 1);
	}

	int calc(int left, int right) {

		if (left == right)
			return 0;

		if (cnt[left][right] == 0) {

			int rst = Integer.MAX_VALUE;

			if (right - left == 1) {

				rst = grid[left][0] * grid[left][1] * grid[right][1];

			} else {

				for (int idx = left; idx < right; idx++) {

					int temp = calc(left, idx) + calc(idx + 1, right) + grid[left][0] * grid[idx][1] * grid[right][1];
					rst = Math.min(rst, temp);

				}

			}

			cnt[left][right] = rst;

		}

		return cnt[left][right];
	}

}