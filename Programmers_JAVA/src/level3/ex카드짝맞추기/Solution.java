package level3.ex카드짝맞추기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int solution(int[][] board, int r, int c) {

		Map<Integer, Card> map = new HashMap<>();
		Set<Card> cards = new HashSet<>();

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				int val = board[row][col];
				if (val != 0) {
					Card card = new Card(row, col, val);
					cards.add(card);
					if (map.containsKey(val))
						map.get(val).pairing(card);
					else
						map.put(val, card);
				}
			}
		}

		return dfs(board, cards, 0, new Card(r, c, -1), 0, cards.size(), false);
	}

	int dfs(int[][] board, Set<Card> cards, int moved, Card card, int visited, int goal, boolean pairNext) {

		if (visited == goal) {
			return moved + goal;
		}

		int result = Integer.MAX_VALUE;

		if (!card.visit) {

			card.visit();
			if (card.val != -1)
				board[card.row][card.col] = 0;
			visited++;

			if (pairNext) {

				int moving = move(board, card.coord(), card.pair.coord());
				result = dfs(board, cards, moved + moving, card.pair, visited, goal, !pairNext);

			} else {

				for (Card next : cards) {
					if (!next.visit) {
						int moving = move(board, card.coord(), next.coord());
						int newMoved = dfs(board, cards, moved + moving, next, visited, goal, !pairNext);
						result = Math.min(result, newMoved);
					}
				}

			}

			if (card.val != -1)
				board[card.row][card.col] = card.val;
			card.visit();
		}

		return result;
	}

	int move(int[][] board, int[] from, int[] to) {

		if (from[0] == to[0] && from[1] == to[1])
			return 0;

		boolean[][] visit = new boolean[4][4];
		visit[from[0]][from[1]] = true;
		int move = 0;
		Set<int[]> prev = new HashSet<>(), next = null;
		prev.add(from);

		while (move < 6) {

			next = new HashSet<>();
			move++;

			for (int[] coord : prev) {

				for (int i = 0; i < 8; i++) {

					int row = coord[0], col = coord[1];

					switch (i) {
					case 0:
						row++;
						break;
					case 1:
						row--;
						break;
					case 2:
						col++;
						break;
					case 3:
						col--;
						break;
					case 4:
						do {
							row++;
						} while (isValid(row + 1) && board[row][col] == 0);
						break;
					case 5:
						do {
							row--;
						} while (isValid(row - 1) && board[row][col] == 0);
						break;
					case 6:
						do {
							col++;
						} while (isValid(col + 1) && board[row][col] == 0);
						break;
					case 7:
						do {
							col--;
						} while (isValid(col - 1) && board[row][col] == 0);
						break;
					}

					int[] nextCoord = { row, col };
					if (isValid(nextCoord) && !visit[row][col]) {
						next.add(nextCoord);
						visit[row][col] = true;
					}

					if (row == to[0] && col == to[1]) {
						return move;
					}

				}

			}

			prev = next;

		}
		return 6;
	}

	boolean isValid(int[] coord) {
		return isValid(coord[0]) && isValid(coord[1]);
	}

	boolean isValid(int point) {
		return point >= 0 && point < 4;
	}
}

class Card {

	int row;
	int col;
	int val;

	boolean visit;

	Card pair;

	Card(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
		visit = false;
	}

	void pairing(Card card) {
		if (card != null) {
			this.pair = card;
			card.pair = this;
		}
	}

	void visit() {
		visit = !visit;
	}

	int[] coord() {
		return new int[] { row, col };
	}
}