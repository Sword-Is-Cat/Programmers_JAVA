package level1.ex문자열다루기기본;


/*
 * ���� ����
���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. 
���� ��� s�� a234�̸� False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.

���� ����
s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
 */

class Solution {
	public boolean solution(String s) {

		boolean b1 = (s.length() == 4 || s.length() == 6);
		boolean b2 = (s.replaceAll("[0-9]", "").length() == 0);
		
		return (b1 & b2);
	}
}