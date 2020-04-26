package level2.ex큰수만들기;


/*
 * ���� ����
� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.

���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.

���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.
 */

class Solution {
	public String solution(String number, int k) {

		StringBuilder sb = new StringBuilder();
		String[] strArr = number.split("");
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int start = 0;
		while (k > 0 && arr.length > (start + k)) {
			int index = 0;
			int max = arr[start];
			for (int i = start + 1; i <= start + k; i++) {
				if (max < arr[i]) {
					max = arr[i];
					index = i;
				}
			}
			if (index != 0) {
				k -= index - start;
				start = index;
			}
			sb.append(max);
			start++;
		}
		if (k == 0) {
			for (int i = start; i < arr.length; i++) {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
}