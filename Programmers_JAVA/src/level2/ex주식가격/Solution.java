package level2.ex주식가격;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; i + j < prices.length; j++) {
				if (prices[i] > prices[i + j]) {
					answer[i] = j;
					break;
				} else if (i + j == prices.length - 1)
					answer[i] = j;
			}
		}
		return answer;
	}
}