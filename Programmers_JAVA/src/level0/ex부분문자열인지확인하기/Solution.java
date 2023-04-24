package level0.ex부분문자열인지확인하기;

class Solution {
	public int solution(String my_string, String target) {
		return my_string.contains(target) ? 1 : 0;
	}
}