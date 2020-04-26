package level1.ex자연수뒤집어배열로만들기;


/*
 * ���� ����
�ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. 
������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.

���� ����
n�� 10,000,000,000������ �ڿ����Դϴ�.
 */

class Solution {
	public int[] solution(long n) {
		
		int size = (int)Math.log10(n)+1;
		int[] answer = new int[size];
		for(int i = 0 ; i<size ; i++) {
			
			answer[i] = (int)(n % 10);
			n = n/10;
			
		}
		
		
		return answer;
	}
	
}