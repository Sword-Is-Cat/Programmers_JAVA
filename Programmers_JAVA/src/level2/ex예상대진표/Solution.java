package level2.ex예상대진표;

/*
* https://programmers.co.kr/learn/courses/30/lessons/12985
*/

class Solution{
	public int solution(int n, int a, int b)    {
		
		int m = log2(n);
		// �־����� n�� 2^m ������ �ڿ���
		// �ʿ��� ���� �¼� �̹Ƿ� log2�� ������ʿ�
		// Math���� lon_natural�� log10�� ���ǵǾ� log2 �޼ҵ� �ۼ��ʿ�
		char[] aa = toBinaryChar(m,a-1);
		char[] bb = toBinaryChar(m,b-1);
		// toBynaryChar �޼ҵ� Ȯ��
		int i = 0;
		for(; i<m ; i++) {
			if(aa[i] != bb[i])
				break;
		}
		// �� �迭�� ���ڸ����� ���Ͽ� ��������� �� �����ڰ� ����ϴ��� Ȯ��
		return m-i;
		//
    }	
	
	public char[] toBinaryChar(int m, int a) {
		
		char[] answer = new char[m];
		char[] arr = Integer.toBinaryString(a).toCharArray();
		for(int i = 0 ; i<m-arr.length ; i++) {
			answer[i] = '0';
		}
		for(int i = 0 ; i<arr.length ; i++) {
			answer[m-arr.length+i] = arr[i];
		}
		return answer;
	}
	// 7 -> 111(2) -> {1,1,1} -> {0,0,0,0,0,1,1,1}(length=m) �� ���ϴ� �޼ҵ�
	
	public int log2(int n) {

		int answer = 0;
		while(n>1) {
			n = n/2;
			answer++;
		}
		return answer;
	}
	// ���� ���ǿ� n�� �ݵ�� 2^m �����̹Ƿ� �Ҽ��� ����, log2(2^m) return m; �� �����ϸ� �ȴ�
}