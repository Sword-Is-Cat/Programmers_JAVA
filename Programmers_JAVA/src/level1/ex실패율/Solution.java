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
		} // Comparator ����� ���� Integer�迭. ���� ���� �� int�迭�� ��ȯ�Ͽ� return.
		
		
		int[] clear = new int[N + 1];
		for (int stg : stages) {
			for (int i = 0; i < N + 1; i++) {
				if (i < stg)
					clear[i]++;
				else
					break;
			}
		} // i�� ���������� Ŭ������ ����� �� = clear[i]


		Arrays.sort(ans, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Double.compare(failrate(i2), failrate(i1));
			}
			public double failrate(int i) { // ������ ��� �޼ҵ�
				if (clear[i - 1] == 0)
					return 0;
				else
					return (clear[i - 1] - clear[i]) / (double) clear[i - 1];
			}
		}); // ans�迭�� failrate ������������ ����
		
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = ans[i];
		} // Integer �迭�� int �迭�� �����Ͽ� return

		return answer;
	}

}