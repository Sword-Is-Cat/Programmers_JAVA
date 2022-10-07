package level0.ex배열회전시키기;

class Solution {
	public int[] solution(int[] numbers, String direction) {

		int length = numbers.length;
		int[] answer = new int[length];

		int direct = "right".equals(direction) ? 1 : -1;

		for (int i = 0; i < length; i++)
			answer[i] = numbers[(i - direct + length) % length];

		return answer;
	}
}