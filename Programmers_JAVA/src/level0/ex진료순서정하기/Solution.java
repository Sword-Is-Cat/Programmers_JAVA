package level0.ex진료순서정하기;

import java.util.Arrays;

class Solution {
	public int[] solution(int[] emergency) {

		VO[] arr = new VO[emergency.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new VO(i, emergency[i]);
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			VO t = arr[i];
			emergency[t.idx] = i + 1;
		}

		return emergency;
	}
}

class VO implements Comparable<VO> {

	int idx;
	int emerg;

	VO(int no, int emerg) {
		this.idx = no;
		this.emerg = emerg;
	}

	@Override
	public int compareTo(VO o) {
		return o.emerg - this.emerg;
	}
}