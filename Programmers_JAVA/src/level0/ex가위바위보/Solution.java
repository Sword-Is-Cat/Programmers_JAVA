package level0.ex가위바위보;

class Solution {
	public String solution(String rsp) {

		char[] arr = rsp.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			switch (arr[i]) {
			case '0':
				arr[i] = '5';
				break;
			case '2':
				arr[i] = '0';
				break;
			case '5':
				arr[i] = '2';
				break;
			}

		}

		return new String(arr);
	}
}