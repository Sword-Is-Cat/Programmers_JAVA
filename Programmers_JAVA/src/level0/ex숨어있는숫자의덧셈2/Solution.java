package level0.ex숨어있는숫자의덧셈2;

class Solution {
	public int solution(String my_string) {

		String[] arr = my_string.split("[^0-9]+");
		int sum = 0;

		for (String noStr : arr) {
			if ("".equals(noStr))
				continue;
			sum += Integer.parseInt(noStr);
		}

		return sum;
	}
}