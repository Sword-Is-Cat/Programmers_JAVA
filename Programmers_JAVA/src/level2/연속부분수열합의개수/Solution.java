package level2.연속부분수열합의개수;

import java.util.HashSet;

class Solution {
	public int solution(int[] elements) {

		int length = elements.length;
		int[] arr = new int[length * 2];
		for (int i = 0; i < length; i++) {
			arr[i] = elements[i];
			arr[i + length] = elements[i];
		}

		HashSet<Integer> set = new HashSet<>();

		for (int leng = 1; leng <= length; leng++) {
			for (int stIdx = 0; stIdx < length; stIdx++) {

				int temp = 0;
				for (int idx = stIdx; idx < stIdx + leng; idx++) {
					temp += arr[idx];
				}
				set.add(temp);
			}
		}

		return set.size();
	}
}