package level1.ex실패율;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {

	public int[] solution(int N, int[] stages) {

		Integer[] ans = new Integer[N];
		for (int i = 0; i < N; i++) {
			ans[i] = i + 1;
		} // Comparator 사용을 위한 Integer배열. 정답 도출 후 int배열로 변환하여 return.
		
		
		int[] clear = new int[N + 1];
		for (int stg : stages) {
			for (int i = 0; i < N + 1; i++) {
				if (i < stg)
					clear[i]++;
				else
					break;
			}
		} // i번 스테이지를 클리어한 사람의 수 = clear[i]


		Arrays.sort(ans, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Double.compare(failrate(i2), failrate(i1));
			}
			public double failrate(int i) { // 실패율 계산 메소드
				if (clear[i - 1] == 0)
					return 0;
				else
					return (clear[i - 1] - clear[i]) / (double) clear[i - 1];
			}
		}); // ans배열을 failrate 내림차순으로 정렬
		
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = ans[i];
		} // Integer 배열을 int 배열로 변경하여 return

		return answer;
	}

}