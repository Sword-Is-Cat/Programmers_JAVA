package level2.ex카펫;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */

class Solution {
	public int[] solution(int brown, int yellow) {

		/* garo, sero 는 각각 노란 칸의 가로의길이, 세로의길이 */
		int garo = 0;
		int sero = 0;

		for (int i = 1; i <= brown / 2 - 2; i++) {
			if (i * (brown / 2 - 2 - i) == yellow) {
				sero = i;
				break;
			}
		}

		garo = yellow / sero;

		int[] answer = { garo + 2, sero + 2 };
		return answer;
	}
}
