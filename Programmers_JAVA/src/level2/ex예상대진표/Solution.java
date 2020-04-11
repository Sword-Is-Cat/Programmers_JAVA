package level2.ex예상대진표;
/*
* https://programmers.co.kr/learn/courses/30/lessons/12985
*/

class Solution{
	public int solution(int n, int a, int b)    {
		
		int m = log2(n);
		// 주어지는 n은 2^m 형태의 자연수
		// 필요한 값은 승수 이므로 log2의 결과값필요
		// Math에는 lon_natural과 log10만 정의되어 log2 메소드 작성필요
		char[] aa = toBinaryChar(m,a-1);
		char[] bb = toBinaryChar(m,b-1);
		// toBynaryChar 메소드 확인
		int i = 0;
		for(; i<m ; i++) {
			if(aa[i] != bb[i])
				break;
		}
		// 두 배열의 앞자리부터 비교하여 어느시점에 두 참가자가 경기하는지 확인
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
	// 7 -> 111(2) -> {1,1,1} -> {0,0,0,0,0,1,1,1}(length=m) 을 구하는 메소드
	
	public int log2(int n) {

		int answer = 0;
		while(n>1) {
			n = n/2;
			answer++;
		}
		return answer;
	}
	// 문제 조건에 n은 반드시 2^m 형태이므로 소수점 무시, log2(2^m) return m; 만 구현하면 된다
}