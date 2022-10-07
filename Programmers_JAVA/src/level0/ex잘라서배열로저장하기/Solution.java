package level0.ex잘라서배열로저장하기;

class Solution {
	public String[] solution(String my_str, int n) {

		String[] answer = new String[(my_str.length() - 1) / n + 1];

		for (int i = 0; i < answer.length; i++) {

			if (i == answer.length - 1)
				answer[i] = my_str.substring(i * n);
			else
				answer[i] = my_str.substring(i * n, (i + 1) * n);

		}

		return answer;
	}
}