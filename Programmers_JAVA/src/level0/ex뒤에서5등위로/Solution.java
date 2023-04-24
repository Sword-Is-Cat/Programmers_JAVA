package level0.ex뒤에서5등위로;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOfRange(num_list, 5, num_list.length);
	}
}