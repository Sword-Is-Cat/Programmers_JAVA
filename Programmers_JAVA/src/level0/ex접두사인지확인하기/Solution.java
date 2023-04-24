package level0.ex접두사인지확인하기;

class Solution {
	public int solution(String my_string, String is_prefix) {
		return my_string.startsWith(is_prefix) ? 1 : 0;
	}
}