package level0.ex조건에맞게수열변환하기1;

class Solution {
	public int[] solution(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];

			if (value % 2 == 0) {
				if (50 <= value)
					arr[i] /= 2;
			} else {
				if (value < 50)
					arr[i] *= 2;
			}
		}
		return arr;
	}
}