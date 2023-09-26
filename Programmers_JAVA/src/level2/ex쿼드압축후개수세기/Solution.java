package level2.ex쿼드압축후개수세기;

class Solution {

	public int[] solution(int[][] arr) {
		return compress(arr, 0, 0, arr.length, new int[2]);
	}

	/**
	 * 실제 로직
	 * 
	 * @param arr     전체정수배열
	 * @param row     시작점의 행번
	 * @param col     시작점의 열번
	 * @param length  현재 검사중인 쿼드의 행/열 길이
	 * @param counter answer container
	 * @return
	 */
	private int[] compress(int[][] arr, int row, int col, int length, int[] counter) {

		// value는 해당 영역의 첫칸의 값, allMatch는 현재쿼드 전체값의 일치여부
		int value = arr[row][col];
		boolean match = true;

		// 현재쿼드 전체값 일치여부 검증
		for (int i = row; match && i < row + length; i++)
			for (int j = col; match && j < col + length; j++)
				match &= value == arr[i][j];

		if (match) {
			counter[value]++;
		} else {
			length /= 2;
			// 일치하지 않는 경우 쿼드 4등분 후 각각 재검증
			compress(arr, row			, col			, length, counter);
			compress(arr, row + length	, col			, length, counter);
			compress(arr, row			, col + length	, length, counter);
			compress(arr, row + length	, col + length	, length, counter);
		}

		return counter;
	}
}