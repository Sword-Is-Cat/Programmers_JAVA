package level3.ex거스름돈;

class Solution {

	final int MOD = 1000000007;

	public int solution(int n, int[] money) {

		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int index = 0; index < money.length; index++) {
			for (int cost = 0; cost <= n; cost++) {
				if (cost >= money[index]) {
					dp[cost] += dp[cost - money[index]];
					dp[cost] %= MOD;
				}
			}
		}

		return dp[n];
	}
}