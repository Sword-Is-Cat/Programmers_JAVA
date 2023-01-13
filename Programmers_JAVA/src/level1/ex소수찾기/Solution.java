package level1.ex소수찾기;

import java.util.Arrays;

class Solution {
	public int solution(int n) {

		int[] primes = new int[n + 1];
		Arrays.fill(primes, 1);

		primes[0] = 0;
		primes[1] = 0;

		for (int no = 2; no * no <= n; no++) {
			if (primes[no] == 1) {
				for (int mul = 2; mul * no <= n; mul++) {
					primes[mul * no] = 0;
				}
			}
		}
		
		return Arrays.stream(primes).sum();

	}
}