package level0.ex영어가싫어요;

class Solution {
	public long solution(String numbers) {

		String[] nums = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for(int i = 0 ; i<nums.length ; i++)
			numbers = numbers.replaceAll(nums[i], Integer.toString(i));
		
		return Long.parseLong(numbers);
	}
}