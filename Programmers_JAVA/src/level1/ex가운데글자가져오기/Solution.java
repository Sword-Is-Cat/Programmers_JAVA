package level1.ex������ڰ�������;

/*
���� ����
�ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������. �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ� �˴ϴ�.

���ѻ���
s�� ���̰� 1 �̻�, 100������ ��Ʈ���Դϴ�.
*/

class Solution {
	public String solution(String s) {
	      String answer = "";
	      
	      char[] arr = s.toCharArray();
	      
	      answer += arr[(arr.length-1)/2];
	      
	      if(arr.length % 2 == 0) {
	    	  
	    	  answer += arr[(arr.length-1)/2+1];
	      }
	      
	      return answer;
	  }
}