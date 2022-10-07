package level0.ex배열두배만들기;

class Solution {
	public int[] solution(int[] numbers) {

		for (int i = 0; i < numbers.length; i++)
			numbers[i] *= 2;

		return numbers;
	}
}