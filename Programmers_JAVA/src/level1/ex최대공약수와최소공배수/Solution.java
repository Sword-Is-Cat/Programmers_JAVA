package level1.ex최대공약수와최소공배수;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */

class Solution {
	public int[] solution(int n, int m) {
		return new int[]{gcd(n,m), lcm(n,m)};
	}

	int gcd(int n, int m) {
		return (n % m == 0) ? m : gcd(m, n % m);
	}
    
    int lcm(int n, int m){
        return n / gcd(n, m) * m ;
    }
}