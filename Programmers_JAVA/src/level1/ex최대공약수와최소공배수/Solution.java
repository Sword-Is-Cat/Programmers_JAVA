package level1.ex최대공약수와최소공배수;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */

class Solution {
	public int[] solution(int n, int m) {

		int gcd = gcd(n, m);
		int lcm = n * m / gcd;

		int[] answer = { gcd, lcm };

		return answer;
	}

	public int gcd(int n, int m) {
		return (n % m == 0) ? m : gcd(m, n % m);
	}
}