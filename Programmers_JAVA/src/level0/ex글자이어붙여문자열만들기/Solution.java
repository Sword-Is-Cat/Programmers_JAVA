package level0.ex글자이어붙여문자열만들기;

class Solution {
	public String solution(String my_string, int[] index_list) {

		StringBuilder sb = new StringBuilder();

		for (int idx : index_list)
			sb.append(my_string.charAt(idx));

		return sb.toString();
	}
}