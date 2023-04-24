package level0.ex꼬리문자열;

class Solution {
	public String solution(String[] str_list, String ex) {
		StringBuilder sb = new StringBuilder();
		for (String str : str_list) {
			if (!str.contains(ex))
				sb.append(str);
		}
		return sb.toString();
	}
}