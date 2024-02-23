package level1.PCCE10;

import java.util.Arrays;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

		int ext_idx = getIndexOfCategory(ext), sort_idx = getIndexOfCategory(sort_by);

		Arrays.sort(data, (a, b) -> a[ext_idx] - b[ext_idx]);
		for (int i = 0; i < data.length; i++) {
			if (data[i][ext_idx] >= val_ext) {
				data = Arrays.copyOfRange(data, 0, i);
				break;
			}
		}
		Arrays.sort(data, (a, b) -> a[sort_idx] - b[sort_idx]);
		return data;

	}

	private int getIndexOfCategory(String type) {
		int index = -1;
		switch (type) {
		case "code":
			index = 0;
			break;
		case "date":
			index = 1;
			break;
		case "maximum":
			index = 2;
			break;
		case "remain":
			index = 3;
			break;
		}
		return index;
	}
}