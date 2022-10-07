package level0.ex가장큰수찾기;

class Solution {
	public int[] solution(int[] array) {

		int num = Integer.MIN_VALUE;
		int idx = -1;

		for (int i = 0; i < array.length; i++) {

			if (num < array[i]) {
				num = array[i];
				idx = i;
			}

		}

		return new int[] { num, idx };
	}
}