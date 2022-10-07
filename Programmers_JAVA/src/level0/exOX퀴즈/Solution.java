package level0.exOX퀴즈;

class Solution {
	public String[] solution(String[] quiz) {

		String[] answer = new String[quiz.length];

		for (int i = 0; i < quiz.length; i++)
			answer[i] = judge(quiz[i]);

		return answer;
	}

	String judge(String query) {

		String sign = null;

		if (query.contains(" + ")) {

			sign = "+";
			query = query.replace(" + ", " ");
		} else {
			sign = "-";
			query = query.replace(" - ", " ");
		}

		String[] arr = query.split("[^-0-9]+");
		int a1 = Integer.parseInt(arr[0]);
		int a2 = Integer.parseInt(arr[1]);
		int a3 = Integer.parseInt(arr[2]);

		int res = "+".equals(sign) ? a1 + a2 : a1 - a2;

		return a3 == res ? "O" : "X";
	}
	
}