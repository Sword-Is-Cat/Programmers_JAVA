package level0.ex배열의길이를2의거듭제곱으로만들기;

class Solution {
	public int[] solution(int[] arr) {

		int newLength = 1;

		while (newLength < arr.length) {
			newLength *= 2;
		}

		int[] answer = new int[newLength];

		for (int i = 0; i < newLength; i++) {
			if (i < arr.length)
				answer[i] = arr[i];
			else
				answer[i] = 0;
		}

		return answer;
	}
}