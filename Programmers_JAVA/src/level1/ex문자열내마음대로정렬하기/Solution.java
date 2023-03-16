package level1.ex문자열내마음대로정렬하기;

import java.util.Arrays;

class Solution {
	public String[] solution(String[] strings, int n) {

		Arrays.sort(strings);
		Arrays.sort(strings, (a, b) -> Character.compare(a.charAt(n), b.charAt(n)));

		return strings;
	}
}