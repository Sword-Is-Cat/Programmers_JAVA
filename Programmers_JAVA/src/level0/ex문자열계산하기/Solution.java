package level0.ex문자열계산하기;

class Solution {
	public int solution(String my_string) {

		String[] arr = my_string.split(" ");
		String sign = "+";
		int result = 0;

		for (String query : arr) {

			if ("+".equals(query) || "-".equals(query)) {
				sign = query;
			} else {
				int val = Integer.parseInt(query);
				if ("+".equals(sign))
					result += val;
				else if ("-".equals(sign))
					result -= val;
			}
		}
		return result;
	}
}