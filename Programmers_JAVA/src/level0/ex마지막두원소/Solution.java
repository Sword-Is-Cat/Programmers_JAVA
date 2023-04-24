package level0.ex마지막두원소;

class Solution {
	public int[] solution(int[] num_list) {

		int length = num_list.length;

		int last = num_list[length - 1], befo = num_list[length - 2];
		int suff = befo < last ? (last - befo) : (last * 2);

		int[] arr = new int[length + 1];
		for (int i = 0; i < length; i++) {
			arr[i] = num_list[i];
		}
		arr[length] = suff;

		return arr;
	}
}