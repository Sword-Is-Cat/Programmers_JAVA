package level0.ex문자열이몇번등장하는지세기;

class Solution {
	public int solution(String myString, String pat) {

		int idx = myString.indexOf(pat);
		return idx == -1 ? 0 : (1 + solution(myString.substring(idx + 1), pat));
	}
}