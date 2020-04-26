package level1.ex수박수박수박수;


class Solution {
	public String solution(int n) {
		String answer = "";

		StringBuilder sb = new StringBuilder(answer);

		for (int i = 0; i < n / 2; i++) {

			sb.append("����");

		}

		if (n % 2 == 1) {

			sb.append("��");
		}

		answer = sb.toString();

		return answer;
	}
}
