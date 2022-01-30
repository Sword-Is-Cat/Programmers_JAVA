package level4.ex선입선출스케쥴링;

import java.util.PriorityQueue;

class Solution {
	public int solution(int n, int[] cores) {

		PriorityQueue<Core> que = new PriorityQueue<>();
		for (int i = 0; i < cores.length; i++)
			que.add(new Core(i + 1, cores[i]));

		while (n > 1) {
			que.add(que.poll().work());
			n--;
		}

		return que.poll().no;
	}
}

class Core implements Comparable<Core> {

	int no;
	int procTime;
	int accTime;

	Core(int no, int procTime) {
		this.no = no;
		this.procTime = procTime;
		this.accTime = 0;
	}

	Core work() {
		accTime += procTime;
		return this;
	}

	@Override
	public int compareTo(Core o) {
		return accTime - o.accTime == 0 ? no - o.no : accTime - o.accTime;
	}

}