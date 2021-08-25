package level2.ex행렬테두리회전하기;

class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {

		// 원본배열 arr를 생성, 값 대입
		int[][] arr = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = 1 + i * (columns) + j;
			}
		}

		// return값을 담을 배열 생성
		int[] answer = new int[queries.length];

		// 회전진행
		for (int i = 0; i < queries.length; i++) {
			answer[i] = turn(arr, queries[i]);
		}

		return answer;
	}

	// 회전 진행하며 담긴 값들 중 최소값을 return 할 method 정의
	int turn(int[][] arr, int[] turnPoints) {

		// 각 포인트. turnPoints의 좌표는 1~rows / 1~columns로 표시되지만 연산은 0~rows-1 / 0~columns-1로 해야하므로 1씩 감소
		int x1 = turnPoints[0]-1;
		int y1 = turnPoints[1]-1;
		int x2 = turnPoints[2]-1;
		int y2 = turnPoints[3]-1;

		// 최소값을 caching
		int minVal = Integer.MAX_VALUE;

		// 초기 point 및 해당 값을 caching
		int x = x1;
		int y = y1;
		int last = arr[x][y];

		// x1,y1 -> x1,y2로 이동
		while (y < y2) {

			y++;

			minVal = Math.min(minVal, last);

			int temp = arr[x][y];
			arr[x][y] = last;
			last = temp;

		}
		//x1,y2 -> x2,y2로 이동
		while (x < x2) {

			x++;

			minVal = Math.min(minVal, last);

			int temp = arr[x][y];
			arr[x][y] = last;
			last = temp;

		}
		//x2,y2->x2,y1로 이동
		while (y > y1) {

			y--;

			minVal = Math.min(minVal, last);

			int temp = arr[x][y];
			arr[x][y] = last;
			last = temp;

		}
		//x2,y1->x1,y1로 이동
		while (x > x1) {

			x--;

			minVal = Math.min(minVal, last);

			int temp = arr[x][y];
			arr[x][y] = last;
			last = temp;

		}

		return minVal;
	}
}