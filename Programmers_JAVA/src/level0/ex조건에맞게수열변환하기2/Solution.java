package level0.ex조건에맞게수열변환하기2;

import java.util.Arrays;

class Solution {
	public int solution(int[] arr) {
		return Arrays.stream(arr).map(i -> cntAction(i)).max().getAsInt();
	}

	private int cntAction(int n) {

		int cnt = 0;
		boolean flag = true;

		while (flag) {

			if (n % 2 == 0 && 50 <= n) {
				n /= 2;
				cnt++;
			} else if (n % 2 == 1 && n < 50) {
				n *= 2;
				n += 1;
				cnt++;
			} else {
				flag = false;
			}
		}
		return cnt;
	}
}