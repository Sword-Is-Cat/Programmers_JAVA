package level0.ex연속된두수의합;

class Solution {
	public int[] solution(int num, int total) {

		int[] answer = new int[num];
		int init = (total - (num * (num - 1) / 2)) / num;

		for (int i = 0; i < num; i++)
			answer[i] = init + i;

		return answer;
	}
}