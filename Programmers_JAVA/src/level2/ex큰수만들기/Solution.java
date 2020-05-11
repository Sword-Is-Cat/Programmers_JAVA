package level2.ex큰수만들기;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */

class Solution {
	public String solution(String number, int k) {

		/* number를 int 배열로 변환 */
		String[] strArr = number.split("");
		int[] arr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		StringBuilder sb = new StringBuilder();
		int start = 0;
		int index = 0;

		/* k==0이거나(이미 모두 잘랐거나), arr.length>start+k(뒤에서 모두 자르거나)인 경우 에 while 탈출 */
		while (k > 0 && arr.length > (start + k)) {
			int max = arr[start];

			/*
			 * index = start 부터 start + k까지 (k+1)개 돌면서 그중 최대값과 그 index를 저장(최대값과 동일한경우 앞숫자의
			 * index를 사용하므로 갱신하지 않음)
			 */
			for (int i = start + 1; i <= start + k; i++) {
				if (max < arr[i]) {
					max = arr[i];
					index = i;
				}
			}

			/* 저장된 최대값 이전의 모든 수를 버리고 최대값을 가지는 수를 StringBuilder(answer)에 append시킴 */
			k -= index - start;
			start = ++index;
			sb.append(max);
		}

		/* 이미 모두 잘라내어 while문을 탈출한경우 남은 배열의 숫자들을 StringBuilder에 추가 */
		if (k == 0) {
			for (int i = start; i < arr.length; i++) {
				sb.append(arr[i]);
			}
		}

		return sb.toString();
	}
}