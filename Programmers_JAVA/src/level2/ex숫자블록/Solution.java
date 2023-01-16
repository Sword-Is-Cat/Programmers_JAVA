package level2.ex숫자블록;

class Solution {
	 
	final int LIMIT = 10000000;

	public int[] solution(long begin, long end) {
		int[] answer = new int[(int) (end - begin + 1)];
 
		for (int i = 0; i < answer.length; i++) {
			answer[i] = findLargestDivisor(begin + i);
		}

		return answer;
	}
 
	int findLargestDivisor(long num) {

		if (num == 1)
			return 0;

		int initialDiv = Math.max(2, (int) Math.ceil((double) num / LIMIT));

		for (int i = initialDiv; i * i <= num; i++) {
			if (num % i == 0)
				return (int) (num / i);
		}

		return 1;
	}
}