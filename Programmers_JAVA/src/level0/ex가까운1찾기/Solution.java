package level0.ex가까운1찾기;

class Solution {
	public int solution(int[] arr, int idx) {
		for (; idx < arr.length; idx++) {
			if (arr[idx] == 1)
				return idx;
		}
		return -1;
	}
}