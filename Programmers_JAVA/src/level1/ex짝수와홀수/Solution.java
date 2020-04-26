package level1.ex짝수와홀수;


/*
 * ���� ����
���� num�� ¦���� ��� Even�� ��ȯ�ϰ� Ȧ���� ��� Odd�� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
num�� int ������ �����Դϴ�.
0�� ¦���Դϴ�.
 */

class Solution {
	public String solution(int num) {
		
		if(num%2 == 0)
			return "Even";
		return "Odd";
	}
}