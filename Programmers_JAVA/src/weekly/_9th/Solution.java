package weekly._9th;

import java.util.HashSet;
import java.util.Set;

class Solution {

	/*
	 * 문제 풀이에 앞서, n개의 송전탑을 n-1개의 전선으로 모두 연결하는 경우, 1-2-3-1 과 같이 닫힌회로의 형태(삼각형, 사각형과 같이
	 * 안과 밖이 구분되는)로 연결되는 경우는 없음을 증명한다.
	 * 
	 * 초기상태 2개의 송전탑 - 1개의 전선을 연결하는 경우는 닫힌회로의 형태를 구성할 수 없으며, 송전탑과 전선이 각각 1개씩 추가되는 경우,
	 * 모든 송전탑이 연결되어야 하므로 새 송전탑이 반드시 새 전선으로 연결되어야 하며, 닫힌회로형태를 구성하기위해서는 새 전선으로 기존의 송전탑
	 * 2개를 연결해야 하므로 위의 명제는 성립한다.
	 */

	public int solution(int n, int[][] wires) {

		int min = Integer.MAX_VALUE;

		// 코드의 가독성 증대를 위해 송전탑의 배열을 송전탑의 갯수+1의 길이로 선언, 0번 index는 버린다
		Tower[] towers = new Tower[n + 1];

		// 송전탑 Tower객체 생성과 wires의 연결상태 반영
		for (int i = 1; i <= n; i++)
			towers[i] = new Tower(i);

		for (int[] wire : wires) {
			towers[wire[0]].connect.add(towers[wire[1]]);
			towers[wire[1]].connect.add(towers[wire[0]]);
		}

		for (int i = 1; i <= n; i++) {
			Tower tower = towers[i];

			for (Tower conn : tower.connect) {
				int temp = countConnection(tower, conn);
				min = Math.min(min, Math.abs(n - 2 * temp));
			}

		}

		return min;
	}

	/*
	 * fromT의 송전탑에서 toT의 연결을 끊었을때 연결이 끊어지는 송전탑의 갯수를 반환하는 method작성
	 */
	public int countConnection(Tower fromT, Tower toT) {

		int cnt = 1;

		int excNum = fromT.no;

		for (Tower tower : toT.connect) {
			if (tower.no != excNum)
				cnt += countConnection(toT, tower);
		}

		return cnt;
	}
}

class Tower {

	int no = 0;
	Set<Tower> connect = new HashSet<>();

	Tower(int no) {
		this.no = no;
	}

}