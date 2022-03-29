package level3.ex기둥과보설치;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<Integer, Map<Integer, Map<Integer, Integer>>> building = new HashMap<>();

	public int[][] solution(int n, int[][] build_frame) {

		int cnt = 0;
		for (int[] order : build_frame) {
			if (isPossibleOrder(order)) {
				cnt += executeOrder(order);
			}
		}

		int[][] answer = new int[cnt][];
		int index = 0;

		for (int x : building.keySet()) {
			for (int y : building.get(x).keySet()) {
				for (int a : building.get(x).get(y).keySet()) {
					if (building.get(x).get(y).get(a) == 1) {
						answer[index++] = new int[] { x, y, a };
					}
				}
			}
		}

		Arrays.sort(answer, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

		return answer;
	}

	int executeOrder(int[] order) {

		int x = order[0], y = order[1], a = order[2], b = order[3];
		int before = 0;

		if (!building.containsKey(x))
			building.put(x, new HashMap<>());

		if (!building.get(x).containsKey(y))
			building.get(x).put(y, new HashMap<>());

		if (building.get(x).get(y).containsKey(a))
			before = building.get(x).get(y).get(a);

		building.get(x).get(y).put(a, b);

		return b - before;

	}

	boolean isPossibleOrder(int[] order) {

		boolean result = true;
		int x = order[0], y = order[1], a = order[2], b = order[3];

		if (b == 0) {// b==0 파괴
			result = isPossibleDestroy(x, y, a);
		} else {// b==1 생성
			result = isPossibleBuild(x, y, a);
		}

		return result;
	}

	boolean isPossibleBuild(int x, int y, int a) {
		return isPossibleBuild(x, y, a, !isExist(x, y, a));
	}

	boolean isPossibleBuild(int x, int y, int a, boolean do_it) {
		boolean result = do_it;
		if (result) {
			if (a == 0) {// a==0 기둥
				result = y == 0 || isExist(x, y - 1, 0) || isExist(x - 1, y, 1) || isExist(x, y, 1);
			} else {// a==1 보
				result = isExist(x, y - 1, 0) || isExist(x + 1, y - 1, 0)
						|| (isExist(x - 1, y, 1) && isExist(x + 1, y, 1));
			}
		}
		return result;
	}

	boolean isPossibleDestroy(int x, int y, int a) {
		boolean result = isExist(x, y, a);

		if (result) {

			executeOrder(new int[] { x, y, a, 0 });

			if (a == 0) { // a==0 기둥

				result = (!isExist(x, y + 1, 0) || isPossibleBuild(x, y + 1, 0, true))
						&& (!isExist(x - 1, y + 1, 1) || isPossibleBuild(x - 1, y + 1, 1, true))
						&& (!isExist(x, y + 1, 1) || isPossibleBuild(x, y + 1, 1, true));

			} else {// a==1 보

				result = (!isExist(x, y, 0) || isPossibleBuild(x, y, 0, true))
						&& (!isExist(x + 1, y, 0) || isPossibleBuild(x + 1, y, 0, true))
						&& (!isExist(x - 1, y, 1) || isPossibleBuild(x - 1, y, 1, true))
						&& (!isExist(x + 1, y, 1) || isPossibleBuild(x + 1, y, 1, true));

			}
			executeOrder(new int[] { x, y, a, 1 });
		}

		return result;
	}

	boolean isExist(int x, int y, int a) {

		int result = 0;
		if (building.containsKey(x)) {
			if (building.get(x).containsKey(y)) {
				if (building.get(x).get(y).containsKey(a)) {
					result = building.get(x).get(y).get(a);
				}
			}
		}
		return result == 1;
	}
}