package level0.ex배열에서문자열대소문자변환하기;

class Solution {
	public String[] solution(String[] strArr) {

		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toUpperCase();
		}
		return strArr;
	}
}