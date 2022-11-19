package level1.ex기사단원의무기;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

	HashMap<Integer, int[]> divisors = new HashMap<>();

	public int solution(int number, int limit, int power) {

		ArrayList<Integer> primes = new ArrayList<>();

		int answer = 1;
		for (int no = 2; no <= number; no++) {

			int divs = cntDivisor(no, primes);
			if (divs == 2)
				primes.add(no);

			answer += divs > limit ? power : divs;

		}

		return answer;
	}

	int cntDivisor(int no, ArrayList<Integer> primes) {

		int[] arr = null;

		for (int i = 0; i < primes.size(); i++) {

			if (no % primes.get(i) == 0) {
				arr = divisors.get(no / primes.get(i)).clone();
				arr[i]++;
				break;
			}
		}

		if (arr == null) {
			arr = new int[primes.size() + 1];
			arr[primes.size()]++;
		}

		divisors.put(no, arr);

		int cnt = 1;

		for (int val : arr)
			cnt *= val + 1;

		return cnt;
	}
}