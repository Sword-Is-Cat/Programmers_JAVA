package weekly._5th;

class Solution {
	public int solution(String word) {

		word = word.replace('A', '1').replace('E', '2').replace('I', '3').replace('O', '4').replace('U', '5');

		char[] chArr = word.toCharArray();

		int answer = 0;

		for (int i = 0; i < chArr.length; i++) {

			answer += (chArr[i] - 49) * cntNthLengthWords(4 - i) + 1;

		}

		return answer;
	}

	public int cntNthLengthWords(int length) {

		int sum = 0;

		for (int i = 0; i < length; i++) {
			sum += Math.pow(5, i + 1);
		}
		return sum + 1;
	}

	public static void main(String[] args) {

		System.out.println(new Solution().solution("AAAAE"));
	}
}