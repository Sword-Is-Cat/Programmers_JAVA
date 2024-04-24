package level4.ex블록게임;

class Solution {

	int[][] board;
	Block[] blocks;

	public int solution(int[][] board) {

		this.board = board;
		blocks = new Block[201];

		// board 전체 순회하며 블럭정보 수집
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				int value = board[row][col];
				if (value != 0) {
					if (blocks[value] == null)
						blocks[value] = new Block(value);
					blocks[value].addCoord(row, col);
				}
			}
		}

		int answer = 0;

		// 제거 가능한 블럭 수 count
		for (Block block : blocks) {
			if (block != null && block.breakable()) {
				answer++;
			}
		}

		return answer;
	}

	class Block {

		int minRow, maxRow, minCol, maxCol, value;
		boolean breakable, checked;

		Block(int value) {
			this.value = value;
			minRow = minCol = Integer.MAX_VALUE;
			maxRow = maxCol = Integer.MIN_VALUE;
		}

		void addCoord(int row, int col) {
			minRow = Math.min(minRow, row);
			maxRow = Math.max(maxRow, row);
			minCol = Math.min(minCol, col);
			maxCol = Math.max(maxCol, col);
		}

		/**
		 * 내 블럭영역(minRow~maxRow,minCol~maxCol)내의 칸들 중,
		 * 내 블럭이 아닌칸(빈칸 혹은 타블럭)에 대해
		 * 해당 블럭과 그 위의 모든칸은
		 * 1. 빈칸이거나
		 * 2. 내 블럭이 아닌 파괴가능블럭이어야
		 * @return 블럭이 파괴가능
		 */
		boolean breakable() {
			// checked는 불필요한 재연산을 막기위해 설정
			if (!checked) {
				checked = true;
				breakable = true;
				// 내 블럭영역(minRow~maxRow,minCol~maxCol)내의 칸들 중
				for (int row = minRow; row <= maxRow; row++) {
					for (int col = minCol; col <= maxCol; col++) {
						// 내 블럭이 아닌칸(빈칸 혹은 타블럭)에 대해
						if (board[row][col] != value) {
							// 해당 블럭과 그 위의 모든칸은
							for (int tempRow = 0; tempRow <= row; tempRow++) {
								// 1. 빈칸이거나
								// 2. 내 블럭이 아닌 파괴가능블럭이어야
								int tempVal = board[tempRow][col];
								breakable &= tempVal == 0 || (tempVal != value && blocks[tempVal].breakable());
							}
						}
					}
				}
			}
			return breakable;
		}
	}
}