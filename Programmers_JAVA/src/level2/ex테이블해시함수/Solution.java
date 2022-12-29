package level2.ex테이블해시함수;

import java.util.Arrays;

class Solution {
	public int solution(int[][] data, int col, int row_begin, int row_end) {

		Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

		int ans = 0;

		for (int idx = row_begin; idx <= row_end; idx++) {

			int[] row = data[idx - 1];

			int hash = 0, index = idx;

			hash = Arrays.stream(row).map(val -> val % index).sum();

			ans ^= hash;
		}

		return ans;
	}
}
