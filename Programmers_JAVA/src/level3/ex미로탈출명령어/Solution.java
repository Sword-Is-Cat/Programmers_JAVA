package level3.ex미로탈출명령어;

class Solution {
	public String solution(int n, int m, int x, int y, int r, int c, int k) {

		if ((x + y + r + c) % 2 != k % 2 || Math.abs(r - x) + Math.abs(c - y) > k)
			return "impossible";

		StringBuilder sb = new StringBuilder();

		// d -> l -> r -> u
		while (k-- > 0) {
			int downX = x + 1, leftY = y - 1, rightY = y + 1, upX = x - 1;

			if (downX <= n && Math.abs(r - downX) + Math.abs(c - y) <= k) {
				// [1] down 가능?
				sb.append('d');
				x = downX;
			} else if (leftY > 0 && Math.abs(r - x) + Math.abs(c - leftY) <= k) {
				// [2] left 가능?
				sb.append('l');
				y = leftY;
			} else if (rightY <= m && Math.abs(r - x) + Math.abs(c - rightY) <= k) {
				// [3] right 가능?
				sb.append('r');
				y = rightY;
			} else if (upX > 0 && Math.abs(r - upX) + Math.abs(c - y) <= k) {
				// [4] up 가능?
				sb.append('u');
				x = upX;
			}
		}
		return sb.toString();
	}
}