package level0.ex암호해독;

class Solution {
	public String solution(String cipher, int code) {

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i * code - 1 < cipher.length(); i++) {
			sb.append(cipher.charAt(i * code - 1));
		}

		return sb.toString();
	}
}