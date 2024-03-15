package level3.ex코딩테스트공부;

class Solution {
	public int solution(int alp, int cop, int[][] problems) {

		int alGoal = alp, coGoal = cop, length = 450;

		for (int[] problem : problems) {
			alGoal = Math.max(alGoal, problem[0]);
			coGoal = Math.max(coGoal, problem[1]);
		}

		int[][] dp = new int[length][length];

		for (int al = 0; al < dp.length; al++) {
			for (int co = 0; co < dp[al].length; co++) {
				dp[al][co] = Math.max(al, alp) - alp + Math.max(co, cop) - cop;
			}
		}

		for (int al = alp; al < dp.length; al++) {
			for (int co = cop; co < dp[al].length; co++) {
				for (int[] problem : problems) {

					int alReq = problem[0], coReq = problem[1];
					int alGet = problem[2], coGet = problem[3];
					int cost = problem[4];

					if (alReq + alGet <= al && coReq + coGet <= co) {
						dp[al][co] = Math.min(dp[al][co], dp[al - alGet][co - coGet] + cost);
					}
				}

			}
		}

		int ans = length;

		for (int al = alGoal; al < dp.length; al++) {
			for (int co = coGoal; co < dp[al].length; co++) {
				ans = Math.min(ans, dp[al][co]);
			}
		}

		return ans;
	}
}