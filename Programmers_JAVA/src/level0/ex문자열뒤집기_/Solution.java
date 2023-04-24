package level0.ex문자열뒤집기_;

class Solution {
	public String solution(String my_string, int s, int e) {

		char[] arr = my_string.toCharArray();
		while (s < e) {
			char temp = arr[s];
			arr[s++] = arr[e];
			arr[e--] = temp;
		}

		return new String(arr);
	}
}