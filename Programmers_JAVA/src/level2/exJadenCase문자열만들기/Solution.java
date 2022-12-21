package level2.exJadenCase문자열만들기;

class Solution {
	public String solution(String s) {

		char[] array = s.toCharArray();
		char empty = ' ', last = empty;

		for (int i = 0; i < array.length; i++) {
			array[i] = 
					last == empty ? Character.toUpperCase(array[i]) : Character.toLowerCase(array[i]);
			last = array[i];
		}

		return new String(array);
	}
}