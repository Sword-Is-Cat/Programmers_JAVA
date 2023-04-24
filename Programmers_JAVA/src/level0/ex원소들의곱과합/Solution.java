package level0.ex원소들의곱과합;

class Solution {
	public int solution(int[] num_list) {

		int sum = 0, app = 1;

		for (int num : num_list) {
			sum += num;
			app *= num;
		}

		return app < sum * sum ? 1 : 0;
	}
}