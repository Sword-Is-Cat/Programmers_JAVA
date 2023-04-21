package level0.ex문자열섞기;

class Solution {
	public String solution(String str1, String str2) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Math.max(str1.length(), str2.length()); i++) {

			if (i < str1.length())
				sb.append(str1.charAt(i));

			if (i < str2.length())
				sb.append(str2.charAt(i));

		}

		return sb.toString();
	}
}