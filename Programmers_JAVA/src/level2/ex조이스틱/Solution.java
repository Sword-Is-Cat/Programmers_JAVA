package level2.ex���̽�ƽ;

/*
 * ���� ����
���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA

���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.

�� - ���� ���ĺ�
�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
�� - Ŀ���� ���������� �̵�
���� ��� �Ʒ��� ������� JAZ�� ���� �� �ֽ��ϴ�.

- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.

���� ����
name�� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
name�� ���̴� 1 �̻� 20 �����Դϴ�.
 */

import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int solution(String name) {

		char[] arr = name.toCharArray();
		int answer = 0;

		for (char ch : arr) {
			int move = Math.min(ch - 'A', 'A' - ch + 26);
			answer += move;
		}

		ArrayList<Integer> list = new ArrayList<>();

		// case1 ������
		char[] arrr = arr.clone();
		for (int i = 0; i < arr.length; i++) {
			arrr[i] = 'A';
			if (check(arrr))
				list.add(i);
		}

		// case2 ������
		for (int i = 0; i * 2 < arr.length - 1; i++) {
			arrr = arr.clone();
			for (int j = 0; j <= i; j++) {
				arrr[j] = 'A';
			}
			for (int j = 1; j < arr.length - (i * 2) - 1; j++) {
				arrr[arr.length - j] = 'A';
				if (check(arrr))
					list.add(2 * i + j);
			}
		}

		////////////////////////////

		Collections.sort(list);
		answer += list.get(0);

		return answer;
	}

	public boolean check(char[] arr) {

		for (char ch : arr) {
			if (ch != 'A')
				return false;
		}
		return true;
	}

}