package level0.ex특정문자열로끝나는가장긴부분문자열찾기;

class Solution {
	public String solution(String myString, String pat) {

		String revStr = reverseString(myString);
		String revPat = reverseString(pat);

		revStr = revStr.substring(revStr.indexOf(revPat));

		return reverseString(revStr);
	}

	private String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}