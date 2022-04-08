package level2.ex가장큰수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

class Solution {
	public String solution(int[] numbers) {

		List<Integer> list = new ArrayList<>();

		for (int no : numbers)
			list.add(no);

		Collections.sort(list, (a, b) -> strSum(b, a) - strSum(a, b));

		StringBuilder sb = new StringBuilder();

		for (int no : list)
			sb.append(no);

		return sb.charAt(0) == '0' ? "0" : sb.toString();
	}

	int strSum(int a, int b) {

		a *= b < 10 ? 10 : b < 100 ? 100 : b < 1000 ? 1000 : 10000;

		return a + b;
	}
}

class Solution_ {
	public String solution(int[] numbers) {

		String[] arr = new String[numbers.length];

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.toString(numbers[i]);

		Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

		StringBuilder sb = new StringBuilder();

		for (String str : arr)
			sb.append(str);

		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		return sb.length() == 0 ? "0" : sb.toString();
	}
}

class Solution__ {
	public String solution(int[] numbers) {

		StringBuilder sb = new StringBuilder();

		String[] arr = new String[numbers.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {

				int s1 = Integer.parseInt(str1 + str2);
				int s2 = Integer.parseInt(str2 + str1);

				if (s1 > s2)
					return -1;
				else if (s1 < s2)
					return 1;
				else
					return 0;
			}
		});

		for (String str : arr) {
			if (!(sb.length() == 0 && str.equals("0")))
				sb.append(str);
		}

		if (sb.length() == 0)
			return "0";

		sb.deleteCharAt(0);

		return sb.toString();
	}
}

class Solution2 {
	public String solution(int[] numbers) {

		No[] noArr = new No[numbers.length];
		for (int i = 0; i < noArr.length; i++) {
			noArr[i] = new No(numbers[i]);
		}

		Arrays.sort(noArr, new Comparator<No>() {
			public int compare(No no1, No no2) {
				if (no1.init1 != no2.init1) {
					return Integer.compare(no2.init1, no1.init1);
				} else if (no1.init2 != no2.init2) {
					return Integer.compare(no2.init2, no1.init2);
				} else if (no1.init3 != no2.init3) {
					return Integer.compare(no2.init3, no1.init3);
				} else if (no1.init1 > no1.init2) {
					return Integer.compare(no2.num, no1.num);
				} else {
					return Integer.compare(no1.num, no2.num);
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for (No no : noArr) {
			sb.append(no.num);
		}

		if (sb.substring(0, 1).equals("0"))
			return "0";
		else
			return sb.toString();
	}
}

class No { // Compare�� ���� ������ ���� Class����

	int init1;
	int init2;
	int init3;
	int num;

	No(int num) {

		this.num = num;

		if (num == 0) {
			init1 = -1;
		} else if (num < 10) {
			init1 = num;
			init2 = init1;
			init3 = init1;
		} else if (num < 100) {
			init1 = num / 10;
			init2 = num % 10;
			init3 = init1;
		} else if (num < 1000) {
			init1 = num / 100;
			init2 = (num % 100) / 10;
			init3 = num % 10;
		} else {
			init1 = 0;
		}

	}

}

/////////////////////////////////
/*
 * �׽�Ʈ 1 �� ��� (73.97ms, 55.8MB) �׽�Ʈ 2 �� ��� (45.48ms, 59.1MB) �׽�Ʈ 3 �� ���
 * (92.05ms, 65.3MB) �׽�Ʈ 4 �� ��� (7.17ms, 52.7MB) �׽�Ʈ 5 �� ��� (76.24ms,
 * 61.3MB) �׽�Ʈ 6 �� ��� (54.94ms, 61.8MB) �׽�Ʈ 7 �� ��� (1.20ms, 45.1MB) �׽�Ʈ 8
 * �� ��� (1.21ms, 45.1MB) �׽�Ʈ 9 �� ��� (1.11ms, 52.2MB) �׽�Ʈ 10 �� ���
 * (1.20ms, 50.5MB) �׽�Ʈ 11 �� ��� (1.26ms, 45.5MB)
 */