package level0.exX사이의개수;

import java.util.Arrays;

class Solution {
	public int[] solution(String myString) {
		myString += " ";
		int[] rst = Arrays.stream(myString.split("x")).mapToInt(str -> str.length()).toArray();
		rst[rst.length - 1]--;
		return rst;
	}
}