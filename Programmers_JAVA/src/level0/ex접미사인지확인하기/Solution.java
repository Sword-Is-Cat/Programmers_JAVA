package level0.ex접미사인지확인하기;

class Solution {
	public int solution(String my_string, String is_suffix) {
		return my_string.endsWith(is_suffix) ? 1 : 0;
	}
}