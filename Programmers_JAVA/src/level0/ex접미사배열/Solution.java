package level0.ex접미사배열;

import java.util.Arrays;

class Solution {
	public String[] solution(String my_string) {

		StringBuilder sb = new StringBuilder();
		String[] arr = new String[my_string.length()];

		for (int i = arr.length - 1; i >= 0; i--) {
			sb.insert(0, my_string.charAt(i));
			arr[i] = sb.toString();
		}

		Arrays.sort(arr);

		return arr;
	}
}