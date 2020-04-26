package level1.ex나누어떨어지는숫자배열;

/*
���� ����
array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.

���ѻ���
arr�� �ڿ����� ���� �迭�Դϴ�.
���� i, j�� ���� i �� j �̸� arr[i] �� arr[j] �Դϴ�.
divisor�� �ڿ����Դϴ�.
array�� ���� 1 �̻��� �迭�Դϴ�.
*/

import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();

		for (int i : arr) {

			if (i % divisor == 0)
				list.add(i);
		}

		if (list.size() == 0)
			list.add(-1);

		Collections.sort(list);

		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {

			answer[i] = list.get(i);
		}

		return answer;
	}
}