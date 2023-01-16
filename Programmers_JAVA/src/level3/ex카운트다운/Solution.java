package level3.ex카운트다운;

class Solution {

	int[][] dp;

	public int[] solution(int target) {

		dp = new int[target + 1][2];

		for (int goal = 1; goal <= target; goal++) {

			// get target with bull
			shoot(dp[goal], goal, 50, true);
			// get target with non bull
			for (int i = 1; i <= 20; i++) {
				// single score
				shoot(dp[goal], goal, i, true);
				// double score
				shoot(dp[goal], goal, i * 2, false);
				// triple score
				shoot(dp[goal], goal, i * 3, false);
			}
		}
		return dp[target];
	}

	void shoot(int[] array, int goal, int score, boolean isSingle) {

		int total, single;

		if (goal - score >= 0) {

			total = dp[goal - score][0] + 1;
			single = dp[goal - score][1] + (isSingle ? 1 : 0);

			if (array[0] == 0 || array[0] > total || (array[0] == total && array[1] < single)) {
				array[0] = total;
				array[1] = single;
			}
		}
	}
}