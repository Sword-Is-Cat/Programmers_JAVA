package level2.exK진수에서소수개수구하기;

class Solution {
	public int solution(int n, int k) {
		int answer = 0;

		String str = Integer.toUnsignedString(n, k);
		String[] strArr = str.split("[0]+");
		for (String numStr : strArr) {

			if (isPrime(numStr)) {
				answer++;
			}
		}

		return answer;
	}

	public boolean isPrime(String numStr) {

		boolean result = !numStr.isEmpty();

		if (result) {

			long num = Long.parseLong(numStr);

			if (num == 1)
				result = false;

			for (long i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}