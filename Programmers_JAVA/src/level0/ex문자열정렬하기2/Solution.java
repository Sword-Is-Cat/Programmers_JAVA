package level0.ex문자열정렬하기2;

import java.util.Arrays;

class Solution {
	public String solution(String my_string) {

		char[] arr = my_string.toLowerCase().toCharArray();
		Arrays.sort(arr);

		return new String(arr);
	}
}