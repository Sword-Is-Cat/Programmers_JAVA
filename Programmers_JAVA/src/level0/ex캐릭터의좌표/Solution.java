package level0.ex캐릭터의좌표;

class Solution {
	public int[] solution(String[] keyinput, int[] board) {

		int minX = board[0] / 2 * -1, maxX = board[0] / 2, minY = board[1] / 2 * -1, maxY = board[1] / 2;
		int curX = 0, curY = 0;

		for (String input : keyinput) {

			switch (input) {
			case "up":
				curY = Math.min(maxY, curY + 1);
				break;
			case "down":
				curY = Math.max(minY, curY - 1);
				break;
			case "left":
				curX = Math.max(minX, curX - 1);
				break;
			case "right":
				curX = Math.min(maxX, curX + 1);
				break;
			}

		}

		return new int[] { curX, curY };
	}
}