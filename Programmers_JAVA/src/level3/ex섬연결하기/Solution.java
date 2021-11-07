package level3.ex섬연결하기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(int n, int[][] costs) {

		Map<Integer, Integer> connection = new HashMap<>();
		Arrays.sort(costs, (a, b) -> (a[2] - b[2]));
		int answer = 0;

		for (int[] cost : costs) {

			final int NO1 = cost[0];
			int no1 = NO1;
			final int NO2 = cost[1];
			int no2 = NO2;
			int value = cost[2];

			while (connection.containsKey(no1))
				no1 = connection.get(no1);
			while (connection.containsKey(no2))
				no2 = connection.get(no2);

			if (NO1 != no1)
				connection.put(NO1, no1);
			if (NO2 != no2)
				connection.put(NO2, no2);

			if (no1 != no2) {
				answer += value;
				connection.put(no1, no2);
			}
		}
		return answer;
	}
}