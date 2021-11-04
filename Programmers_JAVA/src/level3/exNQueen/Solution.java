package level3.exNQueen;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int n) {

		Checker checker = new Checker();
		return dfs(0, n, checker);
	}

	public int dfs(int row, int n, Checker checker) {

		if (row == n)
			return 1;

		int result = 0;

		for (int col = 0; col < n; col++) {
			if (checker.isPossible(row, col)) {
				checker.putQueen(row, col);
				result += dfs(row + 1, n, checker);
				checker.unPutQueen(row, col);
			}
		}

		return result;
	}
}

class Checker {

	Set<Integer> rowSet;
	Set<Integer> colSet;
	Set<Integer> sumSet;
	Set<Integer> difSet;

	Checker() {
		rowSet = new HashSet<>();
		colSet = new HashSet<>();
		sumSet = new HashSet<>();
		difSet = new HashSet<>();
	}

	public boolean isPossible(int row, int col) {
		return !rowSet.contains(row) && !colSet.contains(col) && !sumSet.contains(row + col)
				&& !difSet.contains(row - col);
	}

	public void putQueen(int row, int col) {
		rowSet.add(row);
		colSet.add(col);
		sumSet.add(row + col);
		difSet.add(row - col);
	}

	public void unPutQueen(int row, int col) {
		rowSet.remove(row);
		colSet.remove(col);
		sumSet.remove(row + col);
		difSet.remove(row - col);
	}
}