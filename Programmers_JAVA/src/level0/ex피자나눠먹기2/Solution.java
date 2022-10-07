package level0.ex피자나눠먹기2;

class Solution {
	public int solution(int n) {

		return n / gcd(6, n);
	}

	int gcd(int m, int n) {
		return m % n == 0 ? n : gcd(n, m % n);
	}
}