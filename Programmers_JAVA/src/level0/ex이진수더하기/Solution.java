package level0.ex이진수더하기;

class Solution {
	public String solution(String bin1, String bin2) {

		int i1 = Integer.parseInt(bin1, 2), i2 = Integer.parseInt(bin2, 2);

		return Integer.toBinaryString(i1 + i2);
	}
}