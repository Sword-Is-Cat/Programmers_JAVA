package level0.ex저주의숫자3;

class Solution {

	int cache = 0;

	public int solution(int n) {

		int[] dp = new int[n];
		int idx = 0;

		while (idx < n) {
			dp[idx++] = next();
		}
		return dp[n - 1];
	}

	int next() {
		cache++;
		if (cache % 3 == 0 || cache % 10 == 3 || cache / 10 % 10 == 3)
			return next();
		return cache;
	}
}