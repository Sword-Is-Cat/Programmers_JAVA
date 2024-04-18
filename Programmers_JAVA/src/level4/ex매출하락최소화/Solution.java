package level4.ex매출하락최소화;

import java.util.ArrayList;

class Solution {

	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	int[] sales;
	int[][] dp;

	public int solution(int[] sales, int[][] links) {

		int members = sales.length;

		this.sales = sales;
		dp = new int[members + 1][];

		for (int i = 0; i <= members; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] link : links) {
			graph.get(link[0]).add(link[1]);
		}

		return dfs(1)[0];
	}

	// dp[idx][0] 는 본인참가여부 관계없이 최소값
	// dp[idx][1] 은 본인이 참가하는 최소값

	private int[] dfs(int memNo) {
		if (dp[memNo] == null) {

			int sale = sales[memNo - 1];

			if (graph.get(memNo).isEmpty()) {
				dp[memNo] = new int[] { 0, sale };
			} else {
				int minGap = Integer.MAX_VALUE, sum = 0;
				for (int lp : graph.get(memNo)) {
					int[] arr = dfs(lp);
					minGap = Math.min(minGap, arr[1] - arr[0]);
					sum += arr[0];
				}
				dp[memNo] = new int[] { sum, sum };
				dp[memNo][0] += Math.min(sale, minGap);
				dp[memNo][1] += sale;
			}

		}
		return dp[memNo];
	}
}