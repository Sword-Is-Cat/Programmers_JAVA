package level3.ex최고의집합;

class Solution {

	public int[] solution(int n, int s) {

		if (n > s) {
			int[] wrong = { -1 };
			return wrong;
		}

		int[] answer = new int[n];

		int base = s / n + 1;
		int cnt = (base * n) - s;

		for (int i = 0; i < n; i++) {
			
			if(i<cnt)
				answer[i] = base-1;
			else
				answer[i] = base;

		}

		return answer;
	}

}