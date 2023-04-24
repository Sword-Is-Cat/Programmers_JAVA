package level0.ex길이에따른연산;

class Solution {
	public int solution(int[] num_list) {

		int ans = 0;

		if (10 < num_list.length) {
			for (int num : num_list) {
				ans += num;
			}
		} else {
			ans = 1;
			for (int num : num_list) {
				ans *= num;
			}
		}

		return ans;
	}
}