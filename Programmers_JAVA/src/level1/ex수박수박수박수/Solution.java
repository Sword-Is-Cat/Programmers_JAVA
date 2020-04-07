package level1.ex수박수박수박수;

class Solution {
	public String solution(int n) {
		String answer = "";

		StringBuilder sb = new StringBuilder(answer);

		for (int i = 0; i < n / 2; i++) {

			sb.append("수박");

		}

		if (n % 2 == 1) {

			sb.append("수");
		}

		answer = sb.toString();

		return answer;
	}
}
