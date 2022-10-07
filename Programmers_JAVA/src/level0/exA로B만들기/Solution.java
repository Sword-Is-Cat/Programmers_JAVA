package level0.exA로B만들기;

import java.util.Arrays;

class Solution {
	public int solution(String before, String after) {

		char[] arrBf = before.toCharArray();
		char[] arrAf = after.toCharArray();

		Arrays.sort(arrBf);
		Arrays.sort(arrAf);

		for (int i = 0; i < arrAf.length; i++)
			if (arrBf[i] != arrAf[i])
				return 0;

		return 1;
	}
}