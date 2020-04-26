package level1.ex2016년;

/*
���� ����
2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��? �� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, 
solution�� �ϼ��ϼ���. ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT

�Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

���� ����
2016���� �����Դϴ�.
2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
*/

class Solution {
	public String solution(int a, int b) {
		String answer = "";
		int[] arr = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
		String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int count = 0;

		for (int i = 0; i < a; i++) {

			count += arr[i];
		}

		count += b;

		answer = day[(count+4) % 7];

		return answer;
	}
}
