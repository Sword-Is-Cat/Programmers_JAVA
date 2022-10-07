package level0.ex머쓱이보다키큰사람;

class Solution {
	public int solution(int[] array, int height) {

		int answer = 0;

		for (int tall : array) {
			if (tall > height)
				answer++;
		}

		return answer;
	}
}