package level1.ex시저암호;


/*
 * ���� ����
� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
���� ��� AB�� 1��ŭ �и� BC�� �ǰ�, 3��ŭ �и� DE�� �˴ϴ�. z�� 1��ŭ �и� a�� �˴ϴ�. 
���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.

���� ����
������ �ƹ��� �о �����Դϴ�.
s�� ���ĺ� �ҹ���, �빮��, �������θ� �̷���� �ֽ��ϴ�.
s�� ���̴� 8000�����Դϴ�.
n�� 1 �̻�, 25������ �ڿ����Դϴ�.
 */

class Solution {
	public String solution(String s, int n) {

		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray();

		for (char ch : arr) {
			if (ch != 32) {
				if (ch <= 90) {
					ch += n;
					ch -= (ch > 90) ? 26 : 0;
				} else {
					ch += n;
					ch -= (ch > 122) ? 26 : 0;
				}
			}
			sb.append(ch);
		}
		return sb.toString();
	}
}