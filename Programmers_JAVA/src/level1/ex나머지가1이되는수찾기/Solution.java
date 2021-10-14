package level1.ex나머지가1이되는수찾기;

class Solution {
	public int solution(int n) {

		n--;
		for (int i = 2; i * i <= n; i++) 
			if (n % i == 0) return i;

		return n;
	}
}