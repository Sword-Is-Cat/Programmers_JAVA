package level1.exK번째수;


/*
 * ���� ����
�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��

array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� 
���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
 */

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < commands.length; i++) {

			int[] cut = new int[commands[i][1] - commands[i][0] + 1];
			for (int j = 0; j < cut.length; j++) {

				cut[j] = array[commands[i][0] - 1 + j];
			}
			Arrays.sort(cut);
			list.add(cut[commands[i][2] - 1]);
		}

		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {

			answer[i] = list.get(i);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		Solution.solution(	a, b);
		
	}
}
