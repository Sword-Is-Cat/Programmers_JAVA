package level0.ex1로만들기;

import java.util.Arrays;

class Solution {
	public int solution(int[] num_list) {
		return Arrays.stream(num_list).map(i -> cntAction(i)).sum();
	}

	private int cntAction(int n) {
		int cnt = 0;
		while (n > 1) {
			n /= 2;
			cnt++;
		}
		return cnt;
	}
}