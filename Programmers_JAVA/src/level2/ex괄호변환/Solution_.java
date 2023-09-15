package level2.ex괄호변환;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

class Solution_ {

	public String solution(String p) {
		
		if(p.length()==0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		String u = getBalanced(p);
		p = p.substring(u.length());
		
		if(isRight(u)) {
			sb.append(u);
			sb.append(solution(p));
		}else {
			sb.append("(");
			sb.append(solution(p));
			sb.append(")");
			sb.append(getReverse(u));
		}

		return sb.toString();
	}

	public String getBalanced(String str) {

		int balance = 0;
		int i = 0;
		do {
			if (str.substring(i++, i).equals("(")) {
				balance++;
			} else {
				balance--;
			}
		} while (balance != 0);

		return str.substring(0, i);
	}

	public boolean isRight(String str) {
		
		int balance = 0;
		int i = 0;
		while (!(balance < 0)) {
			if (str.substring(i++, i).equals("(")) {
				balance++;
			} else {
				balance--;
			}
			if(i == str.length())
				return true;
		}
		return false;
	}
	
	public String getReverse(String str) {
		
		char[] arr = (str.substring(1, str.length()-1)).toCharArray();
		if(arr.length == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : arr) {
			if(ch == '(')
				sb.append(')');
			else
				sb.append('(');
		}
		
		return sb.toString();
	}
}