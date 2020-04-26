package level1.ex핸드폰번호가리기;


/*
 * ���� ����
���α׷��ӽ� ������� �������� ��ȣ�� ���� �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�.
��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, ��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
s�� ���� 4 �̻�, 20������ ���ڿ��Դϴ�.
 */

class Solution {
	public String solution(String phone_number) {

		StringBuilder sb = new StringBuilder();

		int length = phone_number.length();

		for (int i = 0; i < length-4; i++) {

			sb.append('*');

		}

		sb.append(phone_number.substring(length - 4));

		return sb.toString();
	}
}