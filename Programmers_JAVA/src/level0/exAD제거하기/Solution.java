package level0.exAD제거하기;

import java.util.Arrays;

class Solution {
	public String[] solution(String[] strArr) {

		return Arrays.stream(strArr).filter(str -> !str.toLowerCase().contains("ad")).toArray(String[]::new);
	}
}