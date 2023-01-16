package level2.ex택배배달과수거하기;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {

		long answer = 0;
		int delivery = 0, pickup = 0;

		for (int home = n - 1; home >= 0; home--) {

			delivery -= deliveries[home];
			pickup -= pickups[home];

			while (delivery < 0 || pickup < 0) {
				delivery += cap;
				pickup += cap;
				answer += (home + 1) * 2;
			}
		}
		return answer;
	}
}