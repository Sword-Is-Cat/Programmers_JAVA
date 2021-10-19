package weekly._10th;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public String[] solution(int[][] line) {

		Set<long[]> set = new HashSet<>();

		/*
		 * 조건에 부합하는 모든 교차점을 set에 저장
		 */
		for (int i = 0; i < line.length; i++) {
			for (int j = 0; j < i; j++) {

				long[] temp = getCrossingCoord(line[i], line[j]);
				if (temp != null)
					set.add(temp);
			}
		}

		/*
		 * 유효한 좌표계의 크기를 계산, 구현 chArr로 모든 좌표를 '.'으로 선언한 후 교차점을 돌면서 '*'로 변경한다
		 */
		long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
		long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;

		for (long[] arr : set) {

			long x = arr[0];
			long y = arr[1];

			maxX = Math.max(maxX, x);
			minX = Math.min(minX, x);
			maxY = Math.max(maxY, y);
			minY = Math.min(minY, y);

		}

		int lengthX = (int) (maxX - minX + 1);
		int lengthY = (int) (maxY - minY + 1);
		String[] answer = new String[lengthY];

		char[][] chArr = new char[lengthY][lengthX];
		for (int i = 0; i < lengthY; i++) 
			for (int j = 0; j < lengthX; j++) 
				chArr[i][j] = '.';

		for (long[] arr : set) {
			chArr[(int) (arr[1] - minY)][(int) (arr[0] - minX)] = '*';
		}

		/*
		 * 좌표계와 2차원배열의 시각적인 순서가 다르기때문에 역순으로 저장 char배열을 String으로 변환
		 */
		for (int i = 0; i < lengthY; i++) {
			answer[lengthY - 1 - i] = new String(chArr[i]);
		}

		return answer;
	}

	// int[] Ax+By+C 형태의 {A,B,C}배열 두개를 받아서 정수교차점을 return하는 메소드
	// 교차점이 없거나 좌표가 int가 아닌 double이라면 null return
	public long[] getCrossingCoord(int[] arr1, int[] arr2) {

		long[] result = null;

		if (arr1.length == 3 && arr2.length == 3) {

			long a = arr1[0], b = arr1[1], e = arr1[2];
			long c = arr2[0], d = arr2[1], f = arr2[2];

			long mo = a * d - b * c;
			long oriX = b * f - e * d;
			long oriY = e * c - a * f;

			if (mo != 0 && oriX % mo == 0 && oriY % mo == 0) {

				long[] rst = { oriX / mo, oriY / mo };
				result = rst;
			}

		}

		return result;
	}
}