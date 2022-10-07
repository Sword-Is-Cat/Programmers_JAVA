package level0.ex문자반복출력하기;

class Solution {
	public String solution(String my_string, int n) {

		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < my_string.length(); idx++) {
			for (int cnt = 0; cnt < n; cnt++) {
				sb.append(my_string.charAt(idx));
			}
		}

		return sb.toString();
	}
}