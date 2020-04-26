package level1.ex제일작은수제거하기;


/*
 * ���� ����
������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���. ��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. ������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.

���� ����
arr�� ���� 1 �̻��� �迭�Դϴ�.
�ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.
 */

class Solution {
	public int[] solution(int[] arr) {

		int[] answer = { -1 };

		if (arr.length == 1) {
			return answer;
		}

		int min = arr[0];

		for (int i : arr) {

			if (min > i)
				min = i;

		}

		answer = new int[arr.length - 1];

		for (int i = 0; i < answer.length; i++) {

			if (arr[i] != min)
				answer[i] = arr[i];
			else {

				for (int j = i; j < answer.length; j++) {

					answer[j] = arr[j + 1];
				}
				break;

			}
		}

		return answer;
	}
}