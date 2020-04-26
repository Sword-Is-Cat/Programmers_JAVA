package level1.exX만큼간격이있는N개의숫자;


/*
 * ���� ����
�Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ� �մϴ�. 
���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
x�� -10000000 �̻�, 10000000 ������ �����Դϴ�.
n�� 1000 ������ �ڿ����Դϴ�.
 */

class Solution {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		answer[0] = x;

		for (int i = 1; i < n; i++) {

			answer[i] = answer[i-1]+x;
		}

		return answer;
	}
}