package level1.ex평균구하기;

/*
 * ���� ����
������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution�� �ϼ��غ�����.

���ѻ���
arr�� ���� 1 �̻�, 100 ������ �迭�Դϴ�.
arr�� ���Ҵ� -10,000 �̻� 10,000 ������ �����Դϴ�.
 */

class Solution {
	public double solution(int[] arr) {
		
		double answer = 0;
		double sum = 0;
		
		for(int i : arr) {
			sum += i;
		}
		
		answer = sum / arr.length;
		
		return answer;
	}
}