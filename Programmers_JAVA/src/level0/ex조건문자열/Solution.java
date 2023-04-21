package level0.ex조건문자열;

class Solution {
	public int solution(String ineq, String eq, int n, int m) {

		boolean flag = false;

		if (">".equals(ineq) && n > m)
			flag = true;

		if ("<".equals(ineq) && n < m)
			flag = true;

		if ("=".equals(eq) && n == m)
			flag = true;

		return flag ? 1 : 0;
	}
}