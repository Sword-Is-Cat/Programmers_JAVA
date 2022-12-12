package level1.ex문자열나누기;

class Solution {
	public int solution(String s) {

		char cache = ' ';
		int cntHit = 0, cntNhit = 0, ans = 0;

		for (char ch : s.toCharArray()) {

			if (cntHit == 0 && cntNhit == 0) {
				cache = ch;
				cntHit++;
			} else {

				if (ch == cache) {
					cntHit++;
				} else {
					cntNhit++;
				}

				if (cntHit == cntNhit) {
					cntHit = 0;
					cntNhit = 0;
					ans++;
				}

			}

		}

		if (cntHit != 0)
			ans++;

		return ans;
	}
}