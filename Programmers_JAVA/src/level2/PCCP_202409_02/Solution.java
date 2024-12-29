package level2.PCCP_202409_02;

class Solution {
	public int solution(int[] diffs, int[] times, long limit) {

		int failLev = diffs[0] - 1, succLev = diffs[0];
		for (int diff : diffs)
			succLev = Math.max(succLev, diff);

		while (succLev - failLev > 1) {
			int level = (failLev + succLev) / 2;
			if (calculateTimeTaken(diffs, times, level) > limit)
				failLev = level;
			else
				succLev = level;
		}

		return succLev;
	}

	public long calculateTimeTaken(int[] diffs, int[] times, int level) {
		long result = times[0];
		for (int i = 1; i < diffs.length; i++) {
			int failLoop = Math.max(0, diffs[i] - level);
			result += times[i - 1] * failLoop;
			result += times[i] * (failLoop + 1);
		}
		return result;
	}
}