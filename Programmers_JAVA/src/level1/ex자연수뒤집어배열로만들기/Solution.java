package level1.ex자연수뒤집어배열로만들기;

/*
 * 문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
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