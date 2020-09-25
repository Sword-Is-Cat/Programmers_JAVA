package level3.ex순위;

import java.util.HashSet;
import java.util.Set;

class Solution {
	
	Member[] arr;
	
	public int solution(int n, int[][] results) {

		arr = new Member[n];

		for (int i = 0; i < n; i++)
			arr[i] = new Member();

		for (int[] match : results)
			process(match[0], match[1]);

		int count = 0;

		for (Member member : arr) {
			if (member.win.size() + member.lose.size() == n - 1)
				count++;
		}
		return count;
	}
	
	void process(int winner, int loser) {
		
		if(arr[winner-1].lose.add(loser)) {
			for(int winnerOfWinner : arr[winner-1].win) {
				process(winnerOfWinner, loser);
			}
		}
		
		if(arr[loser-1].win.add(winner)) {
			for(int loserOfLoser : arr[loser-1].lose) {
				process(winner, loserOfLoser);
			}
		}
	}
}

class Member {
	Set<Integer> win = new HashSet<>();
	Set<Integer> lose = new HashSet<>();
}