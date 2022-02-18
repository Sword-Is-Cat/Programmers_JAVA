package level2.ex프렌즈4블록;

class Solution {

	char[][] chArr;
	static final char EMPTY = ' ';
	static final boolean DEBUG = false;

	public int solution(int m, int n, String[] board) {

		chArr = initialize(m, board);
		int answer = 0;

		int poped = 1;

		while (poped != 0) {
			poped = popMatch();
			answer += poped;
			drop();
		}

		return answer;
	}

	public char[][] initialize(int m, String[] board) {

		char[][] charArr = new char[m][];
		for (int i = 0; i < m; i++) {
			charArr[i] = board[i].toCharArray();
		}

		return charArr;
	}

	public int popMatch() {

		boolean[][] isPop = new boolean[chArr.length][chArr[0].length];
		int poped = 0;

		for (int i = 0; i < chArr.length - 1; i++) {
			for (int j = 0; j < chArr[i].length - 1; j++) {

				char temp = chArr[i][j];
				if (temp != EMPTY) {
					if (chArr[i + 1][j] == temp && chArr[i][j + 1] == temp && chArr[i + 1][j + 1] == temp) {
						isPop[i][j] = true;
						isPop[i + 1][j] = true;
						isPop[i][j + 1] = true;
						isPop[i + 1][j + 1] = true;
						print("pop["+i+","+j+"]:"+temp);
					}
				}
			}
		}

		for (int i = 0; i < chArr.length; i++) {
			for (int j = 0; j < chArr[i].length; j++) {
				if (isPop[i][j]) {
					chArr[i][j] = EMPTY;
					poped++;
				}
			}
		}
		print("poped:"+poped);
		return poped;
	}

	public void drop() {
		
		print("DO DROP");

		for (int j = 0; j < chArr[0].length; j++) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i<chArr.length ; i++) {
				if(chArr[i][j]!=EMPTY)
					sb.append(chArr[i][j]);
			}
			char[] temp = sb.reverse().toString().toCharArray();
			for(int i = 0 ; i<chArr.length ; i++) {
				if(i<temp.length) {
					chArr[chArr.length-1-i][j] = temp[i];
				}else {
					chArr[chArr.length-1-i][j] = EMPTY;
				}
			}
		}
	}
	
	public void print(Object obj) {
		if(DEBUG)System.out.println(obj); 
	}
	
	public static void main(String[] args) {
		String[] arr = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		new Solution().solution(6, 6, arr);
	}
}