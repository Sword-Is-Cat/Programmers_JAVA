package weekly._11th;

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

		// 도형의 테두리를 반시계방향으로 진행하도록 강제하기 위해 가장 아래쪽에 위치한 rectangle의 bottom-left 좌표를 찾는다
		// :: 좌측 하단에 위치한 point에서는 ↑, → 로만 진행할 수 있다
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

		// 시작점에서 → 방향으로 테두리 탐색 시작
		process(start, 1);

		int distance = Math.abs(charaIndex - itemIndex);

		return Math.min(list.size() - distance, distance);
	}

	public void process(int[] coord, int direction) {

		// 한바퀴 돌았으면 탐색종료 return.
		if (isSame(coord, start) && !list.isEmpty())
			return;

		// 테두리를 따라 반시계방향으로 진행하기 때문에 진행방향의 오른쪽, 정면, 왼쪽 순으로 진행가능한지 확인 후 진행한다
		for (int i = 0; i < 3; i++) {
			int newDirection = (direction + 5 - i) % 4;
			int[] next = nextPoint(coord, newDirection);
			if (isLineValid(coord, next)) {
				addPoint(next);
				process(next, newDirection);
				break;
			}
		}
	}

	// 특정 point를 list에 추가하면서 해당 point가 item | character 의 좌표인경우 index-caching
	public void addPoint(int[] coord) {

		if (isSame(coord, item))
			itemIndex = list.size();
		else if (isSame(coord, chara))
			charaIndex = list.size();
		
		list.add(coord);
	}

	// 두 point의 좌표가 같으면 true
	public boolean isSame(int[] coord1, int[] coord2) {

		if (coord1[0] == coord2[0] && coord1[1] == coord2[1])
			return true;
		return false;
	}

	// 인접한 point의 좌표를 생성. direction: 0:↑, 1:→, 2:↓, 3:←
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

	// 특정 point{x,y} 가 rectangle 내부가 아닌 테두리 위에 있는 point인지 확인
	public boolean isPointValid(int[] coord) {

		int x = coord[0];
		int y = coord[1];

		boolean result = false;

		for (int[] rect : rectangle) {

			int blX = rect[0];// bottom-left X
			int blY = rect[1];// bottom-left Y
			int trX = rect[2];// top-right X
			int trY = rect[3];// top-right Y

			if (blX < x && blY < y && x < trX && y < trY) {
				// point는 어떤 rectangle의 내부에도 위치해서는 안된다
				return false;
			} else if (((blX == x || trX == x) && blY <= y && y <= trY)
					|| (blY == y || trY == y) && blX <= x && x <= trX) {
				// point는 적어도 1개 이상의 rectangle의 테두리 위에 위치해야 한다
				result = true;
			}
		}
		return result;
	}

	// 인접한 두 point를 잇는 line이 길 이 될수 있는지 확인
	public boolean isLineValid(int[] coord1, int[] coord2) {

		if (isPointValid(coord1) && isPointValid(coord2)) {// 두 point 모두 rectangle의 테두리 위에 있어야 함

			int x1 = coord1[0];
			int y1 = coord1[1];
			int x2 = coord2[0];
			int y2 = coord2[1];

			for (int[] rect : rectangle) {

				int blX = rect[0];// bottom-left X
				int blY = rect[1];
				int trX = rect[2];// top-right X
				int trY = rect[3];

				// 두 point의 x좌표가 같다면 y좌표가 하나의 rectangle위에있거나 그 반대이거나
				if (x1 == x2 && (blX == x1 || trX == x1) && blY <= y1 && y1 <= trY && blY <= y2 && y2 <= trY) {
					return true;
				} else if (y1 == y2 && (blY == y1 || trY == y1) && blX <= x1 && x1 <= trX && blX <= x2 && x2 <= trX) {
					return true;
				}
			}
		}
		return false;
	}
}