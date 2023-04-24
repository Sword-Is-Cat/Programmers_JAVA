package level0.ex배열만들기5;

import java.util.ArrayList;

class Solution {
	public int[] solution(String[] intStrs, int k, int s, int l) {

		ArrayList<Integer> list = new ArrayList<>();

		for (String myStr : intStrs) {
			int num = Integer.parseInt(myStr.substring(s, s + l));
			if (k < num)
				list.add(num);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}