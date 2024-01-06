package level3.ex산모양타일링;

class Solution {
	public int solution(int n, int[] tops) {

		int mod = 10007;
		int length = tops.length;

		int[][] dp = new int[length + 1][2];

		dp[0][0] = 1;

		for (int i = 0; i < length; i++) {
			if (tops[i] == 1) {
				dp[i + 1][0] = (dp[i][0] * 3 + dp[i][1] * 2) % mod;
				dp[i + 1][1] = (dp[i][0] + dp[i][1]) % mod;
			} else {
				dp[i + 1][0] = (dp[i][0] * 2 + dp[i][1]) % mod;
				dp[i + 1][1] = (dp[i][0] + dp[i][1]) % mod;
			}
		}

		return (dp[length][0] + dp[length][1]) % mod;
	}
}