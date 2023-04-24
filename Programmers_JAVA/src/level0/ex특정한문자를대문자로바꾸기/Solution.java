package level0.ex특정한문자를대문자로바꾸기;

class Solution {
	public String solution(String my_string, String alp) {

		char[] arr = my_string.toCharArray();
		char target = Character.toLowerCase(alp.charAt(0));

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Character.toLowerCase(arr[i]);
			if (arr[i] == target)
				arr[i] = Character.toUpperCase(arr[i]);
		}

		return new String(arr);
	}
}