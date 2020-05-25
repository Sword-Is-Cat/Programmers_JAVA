package level3.ex종이접기;

class Solution {
	public int[] solution(int n) {

		int[] answer = new int[(int) Math.pow(2, n) - 1];
		int count = 0;
		int length = 0;

		while (count < n) {

			count++;
			answer[length] = 0;

			for (int i = length + 1; i < length * 2 + 1; i++) {
				answer[i] = 1 - answer[length * 2 - i];
			}

			length = length * 2 + 1;

		}

		return answer;
	}
}