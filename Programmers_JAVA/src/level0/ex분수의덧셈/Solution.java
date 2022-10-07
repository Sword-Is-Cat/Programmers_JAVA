package level0.ex분수의덧셈;

class Solution {
	public int[] solution(int denum1, int num1, int denum2, int num2) {

		int son = denum1 * num2 + denum2 * num1;
		int mother = num1 * num2;

		int gcd = gcd(son, mother);

		return new int[] { son / gcd, mother / gcd };
	}

	int gcd(int m, int n) {
		return m % n == 0 ? n : gcd(n, m % n);
	}
}