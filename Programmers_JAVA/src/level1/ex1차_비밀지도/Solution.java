package level1.ex1차_비밀지도;

/*
 * 문제주소 : https://programmers.co.kr/learn/courses/30/lessons/17681
 */

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] binary;
		StringBuilder sb;
		
		for(int i = 0 ; i<n ; i++) {
			
			binary = new String[n];
			
			for(int j = n-1 ; j>=0 ; j--) {
				if(arr1[i]%2 + arr2[i]%2 == 0)
					binary[j] = " ";
				else binary[j] = "#";
				arr1[i] = arr1[i]/2;
				arr2[i] = arr2[i]/2;
				
			}
			
			sb = new StringBuilder();
			
			for(String s : binary) {
				sb.append(s);
			}
			
			answer[i] = sb.toString();
		}
		
		return answer;
	}
}