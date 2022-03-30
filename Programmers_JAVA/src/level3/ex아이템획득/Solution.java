package level3.ex아이템획득;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int[][] rectangle;
	int[] chara = new int[2];
	int[] item = new int[2];
	int[] start = new int[2];

	int charaIndex = -1;
	int itemIndex = -1;

	List<int[]> list = new ArrayList<>();

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		this.rectangle = rectangle;
		chara[0] = characterX;
		chara[1] = characterY;
		item[0] = itemX;
		item[1] = itemY;

		int startX = -1;
		int startY = Integer.MAX_VALUE;

		for (int[] rect : rectangle) {
			if (startY > rect[1]) {
				startX = rect[0];
				startY = rect[1];
			}
		}

		start[0] = startX;
		start[1] = startY;

		// System.out.println("start Point:[" + start[0] + "," + start[1] + "]");
		process(start, 1);

		int distance = Math.abs(charaIndex - itemIndex);

		return Math.min(list.size() - distance, distance);
	}

	public void process(int[] coord, int direction) {

		if (isSame(coord, start) && !list.isEmpty())
			return;

		for (int i = 0; i < 3; i++) {
			int[] next = nextPoint(coord, direction + 5 - i);
			if (isLineValid(coord, next)) {
				addPoint(next);
				process(next, (direction + 5 - i) % 4);
				break;
			}
		}

	}

	public void addPoint(int[] coord) {

		if (isSame(coord, item)) {
			// System.out.println("itemIndex:" + list.size());
			itemIndex = list.size();
		} else if (isSame(coord, chara)) {
			// System.out.println("charaIndex:" + list.size());
			charaIndex = list.size();
		}

		// System.out.println("insert Point:[" + coord[0] + "," + coord[1] + "]");
		list.add(coord);

	}

	public boolean isSame(int[] coord1, int[] coord2) {

		if (coord1[0] == coord2[0] && coord1[1] == coord2[1])
			return true;
		return false;

	}

	public int[] nextPoint(int[] coord, int direction) {

		int[] newCoord = coord.clone();

		switch (direction % 4) {
		case 0:
			newCoord[1]++;
			break;
		case 1:
			newCoord[0]++;
			break;
		case 2:
			newCoord[1]--;
			break;
		case 3:
			newCoord[0]--;
			break;
		}

		return newCoord;

	}

	// 특정 point{x,y} 가 길 위에 있는 point인지 확인
	public boolean isPointValid(int[] coord) {

		int x = coord[0];
		int y = coord[1];

		boolean result = false;

		for (int[] rect : rectangle) {

			int blX = rect[0];// bottom-left X
			int blY = rect[1];
			int trX = rect[2];// top-right X
			int trY = rect[3];

			if (blX < x && blY < y && x < trX && y < trY) {
				// point는 어떤 rectangle의 내부에 위치해서는 안된다
				return false;
			} else if (((blX == x || trX == x) && blY <= y && y <= trY)
					|| (blY == y || trY == y) && blX <= x && x <= trX) {
				// point는 적어도 1개 이상의 rectangle의 선 위에 위치해야 한다
				result = true;
			}

		}

		return result;

	}

	// 두 point를 잇는 line이 길 이 될수 있는지 확인
	public boolean isLineValid(int[] coord1, int[] coord2) {

		if (isPointValid(coord1) && isPointValid(coord2)) {// 두 point 모두 길 위에 있어야 함

			int x1 = coord1[0];
			int y1 = coord1[1];
			int x2 = coord2[0];
			int y2 = coord2[1];

			if (Math.abs(x1 - x2) + Math.abs(y1 - y2) == 1) {// 두 point 는 x축 혹은 y축으로 1의 거리만 있어야함

				for (int[] rect : rectangle) {

					int blX = rect[0];// bottom-left X
					int blY = rect[1];
					int trX = rect[2];// top-right X
					int trY = rect[3];

					if (x1 == x2 && (blX == x1 || trX == x1) && blY <= y1 && y1 <= trY && blY <= y2 && y2 <= trY) {
						return true;
					} else if (y1 == y2 && (blY == y1 || trY == y1) && blX <= x1 && x1 <= trX && blX <= x2
							&& x2 <= trX) {
						return true;
					}

				}

			}

		}

		return false;

	}
	/*
	 * public static void main(String[] args) { int[][] arr1 = { { 1, 1, 7, 4 }, {
	 * 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } }; int[][] arr2 = { { 1, 1, 8, 4
	 * }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } }; int[][] arr3 = { { 1, 1,
	 * 5, 7 } }; int[][] arr4 = { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } }; int[][] arr5 =
	 * { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } };
	 * 
	 * int rst = 0; // rst = new Solution().solution(arr1, 1, 3, 7, 8); // rst = new
	 * Solution().solution(arr2, 9, 7, 6, 1); // rst = new Solution().solution(arr3,
	 * 1, 1, 4, 7); // rst = new Solution().solution(arr4, 3, 1, 7, 10); // rst =
	 * new Solution().solution(arr5, 1, 4, 6, 3);
	 * 
	 * System.out.println(rst); }
	 */

}