package level2.ex시소짝궁;

class Solution {
	public long solution(int[] weights) {

		long answer = 0;

		int[] weightCounter = new int[1001];

		for (int weight : weights)
			weightCounter[weight]++;

		for (int weight = 100; weight <= 1000; weight++) {

			long cnt = weightCounter[weight];

			if (cnt == 0)
				continue;

			answer += cnt * (cnt - 1) / 2;

			if (weight * 3 % 2 == 0 && weight * 3 / 2 <= 1000)
				answer += cnt * weightCounter[weight * 3 / 2];

			if (weight * 4 % 2 == 0 && weight * 4 / 2 <= 1000)
				answer += cnt * weightCounter[weight * 4 / 2];

			if (weight * 4 % 3 == 0 && weight * 4 / 3 <= 1000)
				answer += cnt * weightCounter[weight * 4 / 3];
		}
		return answer;
	}
}