package level1.ex문자열내림차순으로배치하기;


/*
���� ����
���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.

���� ����
str�� ���� 1 �̻��� ���ڿ��Դϴ�.
*/

import java.util.Arrays;

class Solution {
	public String solution(String s) {
		
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1 ; i>=0 ; i--) {
			
			sb.append(arr[i]);
			
		}
		
		s = sb.toString();
		
		return s;
	}
	
}