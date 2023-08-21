package level3.exGPS;

import java.util.ArrayList;

class Solution {

	int[] log;
	Integer[][] dp;
	ArrayList<ArrayList<Integer>> graph;

	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

		log = gps_log;
		dp = new Integer[n + 1][k];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// edge 연결 graph화
		for (int[] edge : edge_list) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return getDP(log[k - 1], k - 1);
	}

	/***
	 * dp계산
	 * 
	 * @param position 위치value
	 * @param index    log-index
	 */
	private int getDP(int position, int index) {

		if (dp[position][index] == null) {

			if (index == 0) {
				dp[position][index] = position == log[index] ? 0 : -1;
			} else {

				int min = Integer.MAX_VALUE;

				for (int prev : graph.get(position)) {
					int value = getDP(prev, index - 1);
					if (value == -1)
						continue;
					min = Math.min(min, value + (position == log[index] ? 0 : 1));
				}

				dp[position][index] = min == Integer.MAX_VALUE ? -1 : min;

			}
		}
		return dp[position][index];

	}
}