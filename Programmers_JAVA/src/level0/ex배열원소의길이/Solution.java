package level0.ex배열원소의길이;

class Solution {
	public int[] solution(String[] strlist) {
		
		int[] ans = new int[strlist.length];

		for (int i = 0; i < ans.length; i++)
			ans[i] = strlist[i].length();

		return ans;
	}
}