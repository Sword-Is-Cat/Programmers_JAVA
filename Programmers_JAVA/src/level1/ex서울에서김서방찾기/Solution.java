package level1.ex서울에서김서방찾기;


import java.util.Arrays;

/*
 * ���� ����
String�� �迭 seoul�� element�� Kim�� ��ġ x�� ã��, �輭���� x�� �ִٴ� String�� ��ȯ�ϴ� �Լ�, 
solution�� �ϼ��ϼ���. seoul�� Kim�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.

���� ����
seoul�� ���� 1 �̻�, 1000 ������ �迭�Դϴ�.
seoul�� ���Ҵ� ���� 1 �̻�, 20 ������ ���ڿ��Դϴ�.
Kim�� �ݵ�� seoul �ȿ� ���ԵǾ� �ֽ��ϴ�.
 */

class Solution {
	public String solution(String[] seoul) {

		String answer = "";

		int index = Arrays.asList(seoul).indexOf("Kim");
		
		answer = "�輭���� " + index + "�� �ִ�";

		return answer;
	}
}