package level2.ex이진변환반복하기;

import java.util.stream.IntStream;

class Solution {

	int changeCnt = 0;
	int removeZero = 0;

	public int[] solution(String s) {

		while (s.length() > 1) {
			s = conBinary(s);
		}

		return new int[] { changeCnt, removeZero };
	}

	public String conBinary(String original) {

		int oriLength = original.length();
		int conLength = IntStream.range(0, oriLength).map(i -> original.charAt(i) - '0').sum();

		removeZero += oriLength - conLength;
		changeCnt++;

		return Integer.toBinaryString(conLength);
	}
}