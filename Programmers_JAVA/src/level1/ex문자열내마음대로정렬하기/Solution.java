package level1.ex문자열내마음대로정렬하기;


/*
���� ����
���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�.
���� ��� strings�� [sun, bed, car]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� u, e, a�� strings�� �����մϴ�.

���� ����
strings�� ���� 1 �̻�, 50������ �迭�Դϴ�.
strings�� ���Ҵ� �ҹ��� ���ĺ����� �̷���� �ֽ��ϴ�.
strings�� ���Ҵ� ���� 1 �̻�, 100������ ���ڿ��Դϴ�.
��� strings�� ������ ���̴� n���� Ů�ϴ�.
�ε��� 1�� ���ڰ� ���� ���ڿ��� ���� �� ���, ���������� �ռ� ���ڿ��� ���ʿ� ��ġ�մϴ�.
*/


import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String[] solution(String[] strings, int n) {
		String[] answer = {};
		
		Arrays.sort(strings);
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1.charAt(n) < o2.charAt(n))
					return -1;
				else if (o1.charAt(n) > o2.charAt(n))
					return 1;
				else
					return 0;

			}

		});

		return answer;
	}
}