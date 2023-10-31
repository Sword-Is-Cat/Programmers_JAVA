package level0.ex구슬을나누는경우의수;

class Solution {

	long[][] dp;

	public long solution(int balls, int share) {

		share = Math.min(share, balls - share);
		if (share == 0)
			return 1;

		if (dp == null) {
			dp = new long[balls + 1][];
		}
		if (dp[balls] == null) {
			dp[balls] = new long[balls + 1];
		}

		if (dp[balls][share] == 0) {
			dp[balls][share] = solution(balls - 1, share) + solution(balls - 1, share - 1);
		}

		return dp[balls][share];
	}

}