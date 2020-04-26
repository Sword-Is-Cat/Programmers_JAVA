package level1.ex약수의합;


/*
 * ���� ����
���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
n�� 0 �̻� 3000������ �����Դϴ�.
 */

class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i * i <= n; i++) {

			if (n % i == 0) {

				answer += i;

				if (n / i != i)
					answer += n / i;

			}
		}

		return answer;
	}
}