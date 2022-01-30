package level4.ex사칙연산;

import java.util.HashMap;
import java.util.Map;

class Solution {

	int[] nums;
	char[] signs;
	Map<Integer, Integer> map;

	public int solution(String arr[]) {

		nums = new int[arr.length / 2 + 1];
		signs = new char[arr.length / 2 + 1];
		map = new HashMap<>();

		nums[0] = Integer.parseInt(arr[0]);

		for (int i = 1; i < signs.length; i++) {

			nums[i] = Integer.parseInt(arr[i * 2]);
			signs[i] = arr[i * 2 - 1].charAt(0);

		}

		return dfs(nums[0], 0, 1, '+');
	}

	public int dfs(int value, int stack, int index, char lastSign) {

		if (map.containsKey(index)) {
			int cache = map.get(index);
			if (cache >= value)
				return Integer.MIN_VALUE;
			else
				map.put(index, value);
		} else {
			map.put(index, value);
		}

		if (index == nums.length) {
			return value;
		} else {

			int num = nums[index];
			char sign = signs[index];
			int result = 0;

			if (sign == '+') {

				result = dfs(calc(value, lastSign, num), stack, index + 1, lastSign);
				if (stack > 0) {
					lastSign = reverseSign(lastSign);
					result = Math.max(result, dfs(calc(value, lastSign, num), stack - 1, index + 1, lastSign));
				}
			} else {

				lastSign = reverseSign(lastSign);
				result = dfs(calc(value, lastSign, num), stack + 1, index + 1, lastSign);
				if (stack > 0) {
					lastSign = reverseSign(lastSign);
					result = Math.max(result, dfs(calc(value, lastSign, num), stack, index + 1, lastSign));
				}
			}
			return result;
		}
	}

	public char reverseSign(char sign) {
		return sign == '+' ? '-' : '+';
	}

	public int calc(int no1, char sign, int no2) {
		return sign == '+' ? no1 + no2 : no1 - no2;
	}
}