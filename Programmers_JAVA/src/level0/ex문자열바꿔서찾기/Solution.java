package level0.ex문자열바꿔서찾기;

class Solution {
	public int solution(String myString, String pat) {
		return convert(myString).contains(pat) ? 1 : 0;
	}

	private String convert(String str) {
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray())
			sb.append((char) ('A' + 'B' - ch));
		return sb.toString();
	}
}