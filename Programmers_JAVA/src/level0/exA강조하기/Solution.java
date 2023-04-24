package level0.exA강조하기;

class Solution {
	public String solution(String myString) {

		char[] arr = myString.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Character.toLowerCase(arr[i]);
			if (arr[i] == 'a')
				arr[i] = Character.toUpperCase(arr[i]);
		}

		return new String(arr);
	}
}