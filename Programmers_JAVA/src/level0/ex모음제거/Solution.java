package level0.ex모음제거;

class Solution {
	public String solution(String my_string) {
		return my_string.replaceAll("[aeiou]", "");
	}
}