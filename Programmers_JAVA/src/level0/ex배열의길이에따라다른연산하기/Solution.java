package level0.ex배열의길이에따라다른연산하기;

class Solution {
	public int[] solution(int[] arr, int n) {

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[arr.length - 1 - i] += n;
			}
		}

		return arr;
	}
}