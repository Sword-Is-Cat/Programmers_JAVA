package level0.ex배열의원소삭제하기;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int[] solution(int[] arr, int[] delete_list) {
		HashSet<Integer> delete = new HashSet<>();
		for (int del : delete_list)
			delete.add(del);
		return Arrays.stream(arr).filter(i -> !delete.contains(i)).toArray();
	}
}