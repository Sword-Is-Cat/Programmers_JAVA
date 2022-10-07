package level0.ex유한소수판별하기;

class Solution {
	public int solution(int a, int b) {
		b /= gcd(a, b);

		while (b % 2 == 0)
			b /= 2;

		while (b % 5 == 0)
			b /= 5;

		return b == 1 ? 1 : 2;
	}

	int gcd(int m, int n) {
		return m % n == 0 ? n : gcd(n, m % n);
	}
}