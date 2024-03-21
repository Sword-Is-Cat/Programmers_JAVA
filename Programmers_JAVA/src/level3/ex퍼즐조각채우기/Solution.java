package level3.ex퍼즐조각채우기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

	HashMap<int[][], Integer> puzzlePoint = new HashMap<>();

	public int solution(int[][] game_board, int[][] table) {

		ArrayList<int[][]> slots = new ArrayList<>(), puzzles = new ArrayList<>();

		for (int row = 0; row < game_board.length; row++) {
			for (int col = 0; col < game_board.length; col++) {
				if (game_board[row][col] == 0) {
					slots.add(pickBlock(game_board, row, col));
				}
			}
		}

		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table.length; col++) {
				if (table[row][col] == 1) {
					puzzles.add(pickBlock(table, row, col));
				}
			}
		}

		int matchBlocks = 0;

		HashSet<int[][]> matched = new HashSet<>();

		for (int[][] slot : slots) {
			for (int[][] puzzle : puzzles) {
				if (!matched.contains(puzzle) && isMatch(slot, puzzle)) {
					matched.add(puzzle);
					matchBlocks += puzzlePoint.get(puzzle);
					break;
				}
			}
		}

		return matchBlocks;
	}

	HashMap<int[][], int[][]> rotateCache = new HashMap<>();

	private boolean isMatch(int[][] s, int[][] p) {

		int[][] slot = s;
		boolean isMatch = eq(slot, p);
		int rotate = 3;

		while (!isMatch && rotate-- > 0) {
			if (!rotateCache.containsKey(slot))
				rotateCache.put(slot, rotate(slot));
			slot = rotateCache.get(slot);
			isMatch |= eq(slot, p);
		}

		return isMatch;
	}

	private int[][] rotate(int[][] board) {

		int[][] newBoard = new int[board[0].length][board.length];

		for (int row = 0; row < newBoard.length; row++) {
			for (int col = 0; col < newBoard[0].length; col++) {
				newBoard[row][col] = board[col][newBoard.length - row - 1];
			}
		}

		return newBoard;
	}

	private boolean eq(int[][] s, int[][] p) {

		boolean isEq = s.length == p.length && s[0].length == p[0].length;

		for (int row = 0; isEq && row < s.length; row++) {
			for (int col = 0; isEq && col < s[row].length; col++) {
				isEq &= s[row][col] == p[row][col];
			}
		}

		return isEq;
	}

	private int[][] pickBlock(int[][] board, int row, int col) {

		int myValue = board[row][col];

		ArrayList<int[]> coordList = areaSearch(board, row, col, myValue, null);

		int minRow = coordList.get(0)[0], maxRow = coordList.get(0)[0];
		int minCol = coordList.get(0)[1], maxCol = coordList.get(0)[1];

		for (int[] coord : coordList) {
			minRow = Math.min(minRow, coord[0]);
			maxRow = Math.max(maxRow, coord[0]);
			minCol = Math.min(minCol, coord[1]);
			maxCol = Math.max(maxCol, coord[1]);
		}

		int[][] block = new int[maxRow - minRow + 1][maxCol - minCol + 1];

		for (int[] coord : coordList) {
			block[coord[0] - minRow][coord[1] - minCol] = 1;
		}

		if (myValue == 1) {
			puzzlePoint.put(block, coordList.size());
		}

		return block;
	}

	private ArrayList<int[]> areaSearch(int[][] board, int row, int col, int targetValue, ArrayList<int[]> list) {

		if (list == null)
			list = new ArrayList<>();

		if (0 <= row && 0 <= col && row < board.length && col < board.length && board[row][col] == targetValue) {

			board[row][col] = 1 - targetValue;
			list.add(new int[] { row, col });

			areaSearch(board, row + 1, col, targetValue, list);
			areaSearch(board, row - 1, col, targetValue, list);
			areaSearch(board, row, col + 1, targetValue, list);
			areaSearch(board, row, col - 1, targetValue, list);

		}

		return list;
	}
}