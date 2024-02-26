package level3.ex에어컨;

import java.util.Arrays;

class Solution {
	public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {

		if (t1 <= temperature && temperature <= t2) {
			return 0;
		}

		int target, max;
		if (temperature < t1) {
			target = t1 - temperature;
			max = t2 - temperature;
		} else {
			target = temperature - t2;
			max = temperature - t1;
		}

		int[][] dp = new int[onboard.length][max + 1];
		Arrays.fill(dp[0], -1);
		dp[0][0] = 0;

		for (int time = 1; time < onboard.length; time++) {
			Arrays.fill(dp[time], -1);
			for (int temp = 0; temp <= max; temp++) {
				if (onboard[time] == 1 && temp < target) {
					continue;
				}
				int tempUp = getValue(dp, time - 1, temp - 1);
				int tempEq = getValue(dp, time - 1, temp);
				int tempDn = getValue(dp, time - 1, temp + 1);
				if (tempUp != -1) {
					tempUp += a;
					dp[time][temp] = dp[time][temp] == -1 ? tempUp : Math.min(dp[time][temp], tempUp);
				}
				if (tempEq != -1) {
					if (temp != 0)
						tempEq += b;
					dp[time][temp] = dp[time][temp] == -1 ? tempEq : Math.min(dp[time][temp], tempEq);
				}
				if (tempDn != -1) {
					dp[time][temp] = dp[time][temp] == -1 ? tempDn : Math.min(dp[time][temp], tempDn);
				}
			}
			//System.out.println(Arrays.toString(dp[time]));
		}

		return Arrays.stream(dp[dp.length - 1]).filter(v -> v != -1).min().getAsInt();
	}

	private int getValue(int[][] dp, int time, int temp) {
		if (0 <= time && 0 <= temp && time < dp.length && temp < dp[time].length)
			return dp[time][temp];
		return -1;
	}
}