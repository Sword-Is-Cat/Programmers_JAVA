package level2.ex큰수만들기;

/*
 * 문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */

class Solution {
	public String solution(String number, int k) {

		StringBuilder sb = new StringBuilder();
		String[] strArr = number.split("");
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		int start = 0;
		while (k > 0 && arr.length > (start + k)) {
			int index = 0;
			int max = arr[start];
			for (int i = start + 1; i <= start + k; i++) {
				if (max < arr[i]) {
					max = arr[i];
					index = i;
				}
			}
			if (index != 0) {
				k -= index - start;
				start = index;
			}
			sb.append(max);
			start++;
		}
		if (k == 0) {
			for (int i = start; i < arr.length; i++) {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
}