package level3.ex표병합;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

	Cell[][] cells = new Cell[50][50];

	public String[] solution(String[] commands) {

		for (int row = 0; row < 50; row++) {
			for (int col = 0; col < 50; col++) {
				cells[row][col] = new Cell();
			}
		}

		ArrayList<String> ans = new ArrayList<>();

		for (String cmd : commands) {
			String[] arr = cmd.split(" ");

			if ("UPDATE".equals(arr[0])) {

				if (arr.length == 4) {
					updateCellValue(getCell(arr[1], arr[2]), arr[3]);
				} else if (arr.length == 3) {
					updateValue(arr[1], arr[2]);
				}

			} else if ("MERGE".equals(arr[0])) {

				merge(getCell(arr[1], arr[2]), getCell(arr[3], arr[4]));

			} else if ("UNMERGE".equals(arr[0])) {

				unMerge(getCell(arr[1], arr[2]));

			} else if ("PRINT".equals(arr[0])) {
				String value = getCell(arr[1], arr[2]).value;
				ans.add(value.isEmpty() ? "EMPTY" : value);
			}

		}

		return ans.toArray(new String[0]);
	}

	Cell getCell(String r, String c) {
		return cells[Integer.parseInt(r) - 1][Integer.parseInt(c) - 1];
	}

	void updateCellValue(Cell cell, String value) {
		for (Cell c : cell.mergeGroup)
			c.value = value;
	}

	void updateValue(String oldValue, String newValue) {
		for (int row = 0; row < 50; row++) {
			for (int col = 0; col < 50; col++) {
				if (oldValue.equals(cells[row][col].value)) {
					cells[row][col].value = newValue;
				}
			}
		}
	}

	void merge(Cell cell1, Cell cell2) {

		if (cell1.value.isEmpty()) {
			Cell temp = cell2;
			cell2 = cell1;
			cell1 = temp;
		}

		String value = cell1.value;
		HashSet<Cell> oldGroup = cell2.mergeGroup;
		cell1.mergeGroup.addAll(oldGroup);

		for (Cell cell : oldGroup) {
			updateCellValue(cell, value);
			cell.mergeGroup = cell1.mergeGroup;
		}

	}

	void unMerge(Cell cell) {
		String value = cell.value;
		HashSet<Cell> oldGroup = cell.mergeGroup;

		for (Cell oldCell : oldGroup) {
			oldCell.clear();
		}
		updateCellValue(cell, value);
	}

}

class Cell {

	String value;
	HashSet<Cell> mergeGroup;

	Cell() {
		clear();
	}

	void clear() {
		this.value = "";
		this.mergeGroup = new HashSet<>();
		this.mergeGroup.add(this);
	}

}