package level4.ex지형이동;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

	int sectionNo = 0;

	public int solution(int[][] land, int height) {

		int[][] section = getSection(land, height);
		PriorityQueue<Cost> costQ = getCostMap(land, section);

		return buildLadder(new HashMap<>(), costQ);

	}

	// int[][] section을 만드는 method
	public int[][] getSection(int[][] land, int height) {

		int[][] section = new int[land.length][land[0].length];

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				if (section[i][j] == 0) {
					sectionNo++;
					markingSection(section, land, height, i, j, sectionNo);
				}
			}
		}

		return section;
	}

	// 하나의 section을 채우는 method, myheight 이하의 높이차가 나는 상/하/좌/우 의 블럭으로 dfs
	public void markingSection(int[][] section, int[][] land, int height, int i, int j, int sectionNo) {

		if (section[i][j] != 0)
			return;

		section[i][j] = sectionNo;
		int myHeight = land[i][j];

		if (i > 0 && Math.abs(land[i - 1][j] - myHeight) <= height)
			markingSection(section, land, height, i - 1, j, sectionNo);
		if (i < land.length - 1 && Math.abs(land[i + 1][j] - myHeight) <= height)
			markingSection(section, land, height, i + 1, j, sectionNo);
		if (j > 0 && Math.abs(land[i][j - 1] - myHeight) <= height)
			markingSection(section, land, height, i, j - 1, sectionNo);
		if (j < land[0].length - 1 && Math.abs(land[i][j + 1] - myHeight) <= height)
			markingSection(section, land, height, i, j + 1, sectionNo);
	}

	// costMap을 작성하는 method
	// 1,2구간을 연결하는 cost를 map("1,2", 5) 형태로 저장
	public PriorityQueue<Cost> getCostMap(int[][] land, int[][] section) {

		Map<Key, Integer> map = new HashMap<>();

		for (int i = 0; i < section.length; i++) {
			for (int j = 1; j < section[0].length; j++) {

				int section1 = section[i][j];
				int section2 = section[i][j - 1];
				if (section1 != section2) {
					int cost = Math.abs(land[i][j] - land[i][j - 1]);
					updateCost(map, new Key(section1, section2), cost);
				}

				int revSection1 = section[j][i];
				int revSection2 = section[j - 1][i];
				if (revSection1 != revSection2) {
					int revCost = Math.abs(land[j][i] - land[j - 1][i]);
					updateCost(map, new Key(revSection1, revSection2), revCost);
				}

			}
		}

		PriorityQueue<Cost> costQ = new PriorityQueue<>((a, b) -> (a.value - b.value));

		for (Key key : map.keySet())
			costQ.add(new Cost(key, map.get(key)));

		return costQ;
	}

	// costMap에 key-cost를 주입. 새 key라면 단순 삽입, 기존 key라면 기존값/새값중 작은값
	public void updateCost(Map<Key, Integer> costMap, Key key, int cost) {
		if (costMap.containsKey(key)) {
			if (cost < costMap.get(key))
				costMap.replace(key, cost);
		} else {
			costMap.put(key, cost);
		}
	}

	// costMap에서 value 최소값을 찾아 해당하는 두 섹션을 연결.
	// section1, section2와 연결된 costMap은 전부 제거하고 새 세션 으로 cost 재 계산
	public int buildLadder(Map<Integer, Integer> changeLog, PriorityQueue<Cost> costQ) {

		int result = 0;

		while (!costQ.isEmpty()) {

			Cost cost = costQ.poll();

			int section1 = cost.key.section1;
			int finalSec1 = section1;
			int section2 = cost.key.section2;
			int finalSec2 = section2;

			while (changeLog.containsKey(section1)) {
				section1 = changeLog.get(section1);
				changeLog.put(finalSec1, section1);
			}

			while (changeLog.containsKey(section2)) {
				section2 = changeLog.get(section2);
				changeLog.put(finalSec2, section2);
			}

			if (section1 != section2) {
				result += cost.value;
				changeLog.put(section1, section2);
			}

		}

		return result;
	}
}

class Key {

	int section1;
	int section2;

	Key(int section1, int section2) {
		this.section1 = section1;
		this.section2 = section2;
	}

	@Override
	public boolean equals(Object obj) {

		boolean isEquals = false;

		if (obj instanceof Key) {
			Key key = (Key) obj;
			isEquals = key.section1 * key.section2 == this.section1 * this.section2
					&& key.section1 + key.section2 == this.section1 + this.section2;
		}

		return isEquals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[').append(section1).append(',').append(section2).append(']');
		return sb.toString();
	}
}

class Cost {
	Key key;
	int value;

	Cost(Key key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {

		boolean isEquals = false;
		if (obj instanceof Cost) {
			Cost cost = (Cost) obj;
			isEquals = cost.key.equals(this.key) && cost.value == this.value;
		}
		return isEquals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.key.toString()).append(':').append(this.value);
		return sb.toString();
	}
}