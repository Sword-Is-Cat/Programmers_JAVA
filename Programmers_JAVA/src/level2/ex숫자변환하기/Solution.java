package level2.ex숫자변환하기;

import java.util.HashSet;

class Solution {
	public int solution(int x, int y, int n) {

		int cnt = 0;
		HashSet<Integer> curr = new HashSet<>(), next = null;
		curr.add(x);
		
		while (!curr.isEmpty()) {
			
			if (curr.contains(y))
				return cnt;
			
			next = new HashSet<>();
			for (int val : curr) {
				int pVal = val + n;
				int dVal = val * 2;
				int tVal = val * 3;
				if (pVal <= y) next.add(pVal);
				if (dVal <= y) next.add(dVal);
				if (tVal <= y) next.add(tVal);
			}
			curr = next;
			cnt++;
		}
		return -1;
	}
}