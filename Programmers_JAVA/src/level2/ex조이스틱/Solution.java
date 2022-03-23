package level2.ex조이스틱;

class Solution {
	public int solution(String name) {

		char[] arr = name.toCharArray();
		int cnt = 0;
		int move = arr.length - 1;

		int index = -1;

		for (int i = 0; i < arr.length; i++) {

			char ch = arr[i];
			int gap = ch - 'A';
			cnt += Math.min(gap, 26 - gap);
			//System.out.println(ch + ":" + Math.min(gap, 26 - gap));

			if (ch == 'A' && index == -1) {
				index = i == 0 ? 1 : i;
			} else if (ch != 'A' && index != -1) {
				move = Math.min(move, (index - 1) * 2 + arr.length - i);
				move = Math.min(move, index - 1 + (arr.length - i) * 2);
				//System.out.println("move:" + move);
				index = -1;
			}

		}
		if (index != -1) {
			move = Math.min(move, index - 1);
		}

		//System.out.println("cnt:" + cnt + ",move:" + move);

		return cnt + move;
	}

	public static void main(String[] args) {
		new Solution().solution("JAN");
	}
}