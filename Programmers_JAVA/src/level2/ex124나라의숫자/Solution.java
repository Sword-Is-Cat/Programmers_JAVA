package level2.ex124나라의숫자;


/*
 * ���� ����
124 ���� �ֽ��ϴ�. 124 ���󿡼��� 10������ �ƴ� ������ ���� �ڽŵ鸸�� ��Ģ���� ���� ǥ���մϴ�.

124 ���󿡴� �ڿ����� �����մϴ�.
124 ���󿡴� ��� ���� ǥ���� �� 1, 2, 4�� ����մϴ�.
���� �� 124 ���󿡼� ����ϴ� ���ڴ� ������ ���� ��ȯ�˴ϴ�.

10����	124 ����	10����	124 ����
1	1	6	14
2	2	7	21
3	4	8	22
4	11	9	24
5	12	10	41
�ڿ��� n�� �Ű������� �־��� ��, n�� 124 ���󿡼� ����ϴ� ���ڷ� �ٲ� ���� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
 */

import java.util.ArrayList;

class Solution {
	public String solution(int n) {

		ArrayList<String> list = new ArrayList<>();

		while (n > 0) {
			switch (n % 3) {
			case 1:
				list.add("1");
				n = n/3;
				break;
			case 2:
				list.add("2");
				n = n/3;
				break;
			case 0:
				list.add("4");
				n = n/3 -1;
				break;
			default:
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i<list.size(); i++) {
			sb.append(list.get(list.size()-1-i));
		}

		String answer = sb.toString();
		return answer;
	}
}