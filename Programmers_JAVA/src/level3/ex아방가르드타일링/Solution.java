package level3.ex아방가르드타일링;

class Solution {

	final static int MOD = 1000000007;

	public int solution(int n) {

		int length = Math.max(n + 1, 4);

		long[] dp = new long[length];
		long[] as = new long[length];
		long[] ns = new long[length];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 10;

		as[0] = 1;
		as[1] = 2;
		as[2] = 5;
		as[3] = 15;

		ns[0] = 1;
		ns[1] = 1;
		ns[2] = 3;
		ns[3] = 11;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 5;
			dp[i] += as[i - 4] * 2;
			if (i > 5) 
				dp[i] += ns[i - 6] * 2;
			dp[i] %= MOD;
			as[i] = (as[i - 1] + dp[i]) % MOD;
			ns[i] = (ns[i - 3] + dp[i]) % MOD;
		}

		return (int) dp[n];
	}
}