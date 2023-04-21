package level0.ex더크게합치기;

class Solution {
	public int solution(int a, int b) {
		String as = Integer.toString(a), bs = Integer.toString(b);
		return Math.max(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
	}
}