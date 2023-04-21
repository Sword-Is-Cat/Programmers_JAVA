package level0.ex문자열곱하기;

class Solution {
	public String solution(String my_string, int k) {
		StringBuilder sb = new StringBuilder();
		while (k-- > 0)
			sb.append(my_string);
		return sb.toString();
	}
}