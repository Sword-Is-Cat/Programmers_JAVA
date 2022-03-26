package level2.ex124나라의숫자;

public class Solution {

	public String solution(int n) {

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			if (n % 3 == 0) {
				sb.append(4);
			} else {
				sb.append(n % 3);
			}
			n = (n - 1) / 3;
		}

		return sb.reverse().toString();
	}
}