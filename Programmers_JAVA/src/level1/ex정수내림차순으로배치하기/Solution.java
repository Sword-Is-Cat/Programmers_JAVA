package level1.ex���������������ι�ġ�ϱ�;

/*
 * ���� ����
�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. n�� �� �ڸ����� ū�ͺ��� ���� ������ ������
���ο� ������ �������ּ���. ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.

���� ����
n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.
 */

import java.util.Arrays;

class Solution {
	public long solution(long n) {
		long answer = 0;

		String[] arr = Long.toString(n).split("");
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1 ; i>=0 ; i--) {
			
			answer = answer*10 + Integer.parseInt(arr[i]);
		}

		return answer;
	}
}