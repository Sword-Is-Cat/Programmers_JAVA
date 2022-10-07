package level0.ex합성수찾기;

class Solution {
	public int solution(int n) {

		int answer = 0;
		for (int no = 4; no <= n; no++) {

			if (!isPrime(no))
				answer++;
		}

		return answer;
	}

	boolean isPrime(int no) {

		for (int div = 2; div * div <= no; div++) {
			if (no % div == 0)
				return false;
		}

		return true;
	}
}