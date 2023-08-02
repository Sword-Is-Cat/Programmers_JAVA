package level2.ex요격시스템;

import java.util.Arrays;

class Solution {
	public int solution(int[][] targets) {

		Arrays.sort(targets, (a, b) -> a[0] - b[0]);

		int missile = targets[0][1], cnt = 1;

		for (int[] target : targets) {
			if (missile <= target[0]) {
				missile = target[1];
				cnt++;
			} else {
				missile = Math.min(missile, target[1]);
			}
		}

		return cnt;
	}
}