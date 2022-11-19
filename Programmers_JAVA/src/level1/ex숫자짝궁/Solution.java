package level1.ex숫자짝궁;

import java.util.Arrays;

class Solution {
	public String solution(String X, String Y) {

		char[] arrX = X.toCharArray();
		char[] arrY = Y.toCharArray();

		Arrays.sort(arrX);
		Arrays.sort(arrY);

		StringBuilder sb = new StringBuilder();

		int x = 0, y = 0;

		while (x < arrX.length && y < arrY.length) {

			if (arrX[x] == arrY[y]) {
				sb.append(arrX[x]);
				x++;
				y++;
			} else if (arrX[x] < arrY[y]) {
				x++;
			} else {
				y++;
			}
		}

		if (sb.length() == 0)
			return "-1";

		String str = sb.reverse().toString();

		if (str.replaceAll("0", "").length() == 0)
			return "0";

		return str;
	}
}