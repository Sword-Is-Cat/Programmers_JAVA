package level0.ex카운트다운;

class Solution {
	public int[] solution(int start, int end) {
		int[] answer = new int[start - end + 1];
		answer[0] = start;
		for (int i = 1; i < answer.length; i++)
			answer[i] = answer[i - 1] - 1;
		return answer;
	}
}