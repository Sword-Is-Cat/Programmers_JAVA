package level0.ex등수매기기;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] solution(int[][] score) {

		VO[] arr = new VO[score.length];
		int[] answer = new int[score.length];

		for (int idx = 0; idx < score.length; idx++)
			arr[idx] = new VO(idx, score[idx]);

		Arrays.sort(arr);

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			VO vo = arr[i];
			if (!map.containsKey(vo.score))
				map.put(vo.score, i + 1);
		}

		for (int i = 0; i < arr.length; i++) {
			answer[arr[i].idx] = map.get(arr[i].score);
		}

		return answer;
	}
}

class VO implements Comparable<VO> {

	int idx;
	int score;

	VO(int idx, int[] score) {
		this.idx = idx;
		this.score = score[0] + score[1];
	}

	@Override
	public int compareTo(VO o) {
		return o.score - this.score;
	}

}