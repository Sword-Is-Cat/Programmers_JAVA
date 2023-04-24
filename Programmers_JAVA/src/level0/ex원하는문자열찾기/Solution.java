package level0.ex원하는문자열찾기;

class Solution {
	public int solution(String myString, String pat) {
		return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
	}
}