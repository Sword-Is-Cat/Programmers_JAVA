package level0.ex무작위로k개의수뽑기;

import java.util.HashSet;

class Solution {
	public int[] solution(int[] arr, int k) {

		int[] answer = new int[k];
		HashSet<Integer> dupl = new HashSet<>();
		int idx = 0;

		for (int i = 0; i < arr.length && idx < k; i++) {
			int no = arr[i];
			if (dupl.add(no)) {
				answer[idx++] = no;
			}
		}

		while (idx < k) {
			answer[idx++] = -1;
		}

		return answer;
	}
}