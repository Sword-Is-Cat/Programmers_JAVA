package level1.ex이상한문자만들기;

/*
 * ���� ����
���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�. 
�� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, 
solution�� �ϼ��ϼ���.

���� ����
���ڿ� ��ü�� ¦/Ȧ�� �ε����� �ƴ϶�, �ܾ�(������ ����)���� ¦/Ȧ�� �ε����� �Ǵ��ؾ��մϴ�.
ù ��° ���ڴ� 0��° �ε����� ���� ¦����° ���ĺ����� ó���ؾ� �մϴ�.
 */

class Solution {
	public String solution(String s) {
		String answer = "";

		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != ' ') {

				if (i == 0) {
					arr[i] = Character.toUpperCase(arr[i]);
					
				} else if (Character.isUpperCase(arr[i - 1])) {
					arr[i] = Character.toLowerCase(arr[i]);
					
				} else {
					arr[i] = Character.toUpperCase(arr[i]);
				}

			}
			sb.append(arr[i]);
		}

		answer = sb.toString();
		return answer;
	}

}