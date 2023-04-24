package level0.exN보다커질때까지더하기;

class Solution {
	public int solution(int[] numbers, int n) {
		int sum = 0;

		for (int num : numbers) {
			sum += num;
			if (sum > n)
				break;
		}

		return sum;
	}
}