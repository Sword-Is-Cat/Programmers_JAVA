package level1.ex푸드파이트대회;

class Solution {
	public String solution(int[] food) {

		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < food.length; idx++) {
			for (int cnt = 0; cnt < food[idx] / 2; cnt++) {
				sb.append(idx);
			}
		}

		return new StringBuilder().append(sb).append(0).append(sb.reverse()).toString();
	}
}