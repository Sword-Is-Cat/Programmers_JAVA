package level0.ex문자리스트를문자열로변환하기;

class Solution {
	public String solution(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (String str : arr)
			sb.append(str);
		return sb.toString();
	}
}