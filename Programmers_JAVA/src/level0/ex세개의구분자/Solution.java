package level0.ex세개의구분자;

import java.util.Arrays;

class Solution {
	public String[] solution(String myStr) {
		String[] arr = Arrays.stream(myStr.split("[abc]+")).filter(str -> !str.isEmpty()).toArray(String[]::new);
		return arr.length == 0 ? new String[] { "EMPTY" } : arr;
	}
}