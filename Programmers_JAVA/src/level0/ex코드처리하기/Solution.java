package level0.ex코드처리하기;

class Solution {
	public String solution(String code) {

		int mode = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < code.length(); i++) {
			char ch = code.charAt(i);
			if (ch == '1') {
				mode = 1 - mode;
			} else {
				if (i % 2 == mode) {
					sb.append(ch);
				}
			}
		}

		return sb.length() == 0 ? "EMPTY" : sb.toString();
	}
}