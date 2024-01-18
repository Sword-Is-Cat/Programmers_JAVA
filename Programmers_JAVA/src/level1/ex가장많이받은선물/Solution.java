package level1.ex가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(String[] friends, String[] gifts) {

		int length = friends.length;

		Map<String, Integer> index = new HashMap<>();
		for (int i = 0; i < length; i++) {
			index.put(friends[i], i);
		}

		int[][] giftCnt = new int[length][length];
		int[] giftRate = new int[length];
		int[] giftRsv = new int[length];

		for (String gift : gifts) {
			String[] info = gift.split(" ");
			int from = index.get(info[0]), to = index.get(info[1]);
			giftCnt[from][to]++;
			giftRate[from]++;
			giftRate[to]--;
		}

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (giftCnt[i][j] > giftCnt[j][i]) {
					giftRsv[i]++;
				} else if (giftCnt[i][j] < giftCnt[j][i]) {
					giftRsv[j]++;
				} else if (giftRate[i] > giftRate[j]) {
					giftRsv[i]++;
				} else if (giftRate[i] < giftRate[j]) {
					giftRsv[j]++;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < length; i++) {
			answer = Math.max(answer, giftRsv[i]);
		}
		return answer;
	}
}