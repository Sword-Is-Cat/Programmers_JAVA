package level0.ex부분문자열이어붙여문자열만들기;

class Solution {
	public String solution(String[] my_strings, int[][] parts) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < my_strings.length; i++) {
			sb.append(my_strings[i].substring(parts[i][0], parts[i][1] + 1));
		}

		return sb.toString();
	}
}