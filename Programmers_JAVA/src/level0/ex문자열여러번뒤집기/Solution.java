package level0.ex문자열여러번뒤집기;

class Solution {

	char[] arr;

	public String solution(String my_string, int[][] queries) {

		arr = my_string.toCharArray();

		for (int[] query : queries) {
			reverse(query[0], query[1]);
		}

		return new String(arr);
	}

	private void reverse(int s, int e) {
		while (s < e) {
			char temp = arr[s];
			arr[s++] = arr[e];
			arr[e--] = temp;
		}
	}
}