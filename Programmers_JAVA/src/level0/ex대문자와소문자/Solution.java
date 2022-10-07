package level0.ex대문자와소문자;

class Solution {

	public String solution(String my_string) {
		char[] arr = my_string.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			if (Character.isLowerCase(arr[i]))
				arr[i] = Character.toUpperCase(arr[i]);
			else
				arr[i] = Character.toLowerCase(arr[i]);
		}
		return new String(arr);
	}
}