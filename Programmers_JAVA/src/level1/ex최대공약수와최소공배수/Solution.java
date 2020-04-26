package level1.ex최대공약수와최소공배수;


/*
 * ���� ����
�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������. 
�迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�. 
���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.

���� ����
�� ���� 1�̻� 1000000������ �ڿ����Դϴ�.
 */

class Solution {
	public int[] solution(int n, int m) {

		int gcd = 0;
		int multi = n*m;

		while (gcd == 0) {

			if (n > m) {
				int temp = m;
				m = n;
				n = temp;
			}

			if (m % n == 0) {
				gcd = n;
			}

			m -= n;

		}

		int lcm = multi / gcd;
		int[] answer = { gcd, lcm };

		return answer;
	}
}