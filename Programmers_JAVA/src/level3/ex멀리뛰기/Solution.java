package level3.ex멀리뛰기;

class Solution {

	public long solution(int n) {

		long[] dp = new long[n + 1];
		final int MOD = 1234567;

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%MOD;
		}

		return dp[n];
	}

}