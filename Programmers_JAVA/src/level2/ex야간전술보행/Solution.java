package level2.ex야간전술보행;

class Solution {
	public int solution(int distance, int[][] scope, int[][] times) {

		for (int i = 0; i < scope.length; i++)
			distance = Math.min(distance, calcDistance(scope[i], times[i]));

		return distance;
	}

	public int calcDistance(int[] scope, int[] time) {

		int stt = Math.min(scope[0], scope[1]), end = Math.max(scope[0], scope[1]);

		for (int sec = stt; sec <= end; sec++) {
			int rest = sec % (time[0] + time[1]);
			if (0 < rest && rest <= time[0])
				return sec;
		}

		return Integer.MAX_VALUE;
	}

}