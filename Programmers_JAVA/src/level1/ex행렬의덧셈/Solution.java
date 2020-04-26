package level1.ex행렬의덧셈;


/*
 * ���� ����
����� ������ ��� ���� ũ�Ⱑ ���� �� ����� ���� ��, ���� ���� ���� ���� ���� ����� �˴ϴ�. 
2���� ��� arr1�� arr2�� �Է¹޾�, ��� ������ ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
��� arr1, arr2�� ��� ���� ���̴� 500�� ���� �ʽ��ϴ�.
 */

class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = new int[arr1.length][];
		for (int i = 0; i < arr1.length; i++) {

			answer[i] = new int[arr1[i].length];

			for (int j = 0; j < arr1[i].length; j++) {

				answer[i][j] = arr1[i][j] + arr2[i][j];

			}

		}

		return answer;
	}
}