package level1.ex이상한문자만들기;

class Solution {
	public String solution(String s) {

		StringBuilder sb = new StringBuilder();

		boolean isUpper = true;
		char blank = ' ';

		for (char ch : s.toCharArray()) {

			if (ch == blank) {
				isUpper = true;
				sb.append(ch);
			} else {
				sb.append(isUpper ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
				isUpper = !isUpper;
			}
		}
		return sb.toString();
	}
}