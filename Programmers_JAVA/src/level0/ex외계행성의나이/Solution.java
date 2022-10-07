package level0.ex외계행성의나이;

class Solution {
	public String solution(int age) {

		char[] arr = Integer.toString(age).toCharArray();

		for (int i = 0; i < arr.length; i++)
			arr[i] = (char)(arr[i] - '0' + 'a');

		return new String(arr);
	}
}