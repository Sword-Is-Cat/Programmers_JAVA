package level0.ex문자열정수의합;

class Solution {
	public int solution(String num_str) {
		int answer = 0;
		for (char ch : num_str.toCharArray())
			answer += ch - '0';
		return answer;
	}
}