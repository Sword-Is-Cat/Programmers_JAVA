package level1.ex소수찾기;

import java.util.Arrays;

class Solution {
	public int solution(int n) {

		int[] primes = new int[n + 1];
		primes[0] = 1;
		primes[1] = 1;

		for (int no = 2; no * no <= n; no++) {
			if (primes[no] == 0) {
				for (int mul = 2; mul * no <= n; mul++) {
					primes[mul * no] = 1;
				}
			}
		}
		return n + 1 - Arrays.stream(primes).sum();
	}
}