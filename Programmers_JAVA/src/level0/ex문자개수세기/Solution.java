package level0.ex문자개수세기;

class Solution {
	public int[] solution(String my_string) {

		int[] answer = new int[52];

		for (char ch : my_string.toCharArray()) {
			int idx = Character.isUpperCase(ch) ? (ch - 'A') : (ch - 'a' + 26);
			answer[idx]++;
		}

		return answer;
	}
}