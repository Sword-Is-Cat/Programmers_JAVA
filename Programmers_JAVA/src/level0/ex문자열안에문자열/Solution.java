package level0.ex문자열안에문자열;

class Solution {
	public int solution(String str1, String str2) {
		return str1.indexOf(str2) > -1 ? 1 : 2;
	}
}