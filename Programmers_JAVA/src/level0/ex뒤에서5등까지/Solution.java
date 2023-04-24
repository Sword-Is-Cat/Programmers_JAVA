package level0.ex뒤에서5등까지;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOf(num_list, 5);
	}
}