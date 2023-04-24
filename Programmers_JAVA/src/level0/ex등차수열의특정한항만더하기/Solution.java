package level0.ex등차수열의특정한항만더하기;

class Solution {
	public int solution(int a, int d, boolean[] included) {
		int answer = 0;
		for (boolean flag : included) {
			if (flag)
				answer += a;
			a += d;
		}
		return answer;
	}
}