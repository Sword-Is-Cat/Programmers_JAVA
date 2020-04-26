package level2.ex올바른괄호;


/*
 * ���� ����
��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�. 

���� ���
()() �Ǵ� (())() �� �ùٸ� ��ȣ�Դϴ�.
)()( �Ǵ� (()( �� �ùٸ��� ���� ��ȣ�Դϴ�.
'(' �Ǵ� ')' �θ� �̷���� ���ڿ� s�� �־����� ��, ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�, 
�ùٸ��� ���� ��ȣ�̸� false�� return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
���ڿ� s�� ���� : 100,000 ������ �ڿ���
���ڿ� s�� '(' �Ǵ� ')' �θ� �̷���� �ֽ��ϴ�.
 */

class Solution {
	boolean solution(String s) {
		char[] arr = s.toCharArray();
		int balance = 0;
		for(int i = 0; i<arr.length ; i++) {
			if(arr[i] == '(') {
				balance++;
			}else {
				balance--;
			}
			if(balance<0)
				return false;
		}
		return (balance==0)?true:false;
	}
}