package level0.ex숨어있는숫자의덧셈;

class Solution {
	public int solution(String my_string) {

		my_string = my_string.replaceAll("[^0-9]", "");
		int answer = 0;

		for (char ch : my_string.toCharArray())
			answer += ch - '0';

		return answer;
	}
}