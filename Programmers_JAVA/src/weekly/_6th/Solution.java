package weekly._6th;

import java.util.Arrays;

class Solution {

	public int[] solution(int[] weights, String[] head2head) {

		// 선수체중배열로 선수배열을 생성
		Boxer[] boxers = new Boxer[weights.length];

		for (int i = 0; i < boxers.length; i++) {
			boxers[i] = new Boxer(i + 1, weights[i]);
		}

		// 대전결과 적용
		for (int i = 0; i < head2head.length; i++) {

			char[] myRst = head2head[i].toCharArray();

			for (int j = 0; j < myRst.length; j++) {

				boxers[i].fight(boxers[j], myRst[j]);

			}

		}

		// Boxer클래스에서 재 정의한 정렬조건으로 정렬
		Arrays.sort(boxers);

		// 선수번호 배열을 생성하여 return
		int[] answer = new int[boxers.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = boxers[i].num;
		}

		return answer;
	}

}

/**
 * 
 * @num 선수번호
 * @weight 선수체중
 * 
 * @cntFight 대전 수
 * @cntWin 승수
 * @cntWAH 본인보다 무거운 상대에게 승리수(WinAgainstHeavy)
 *
 */
class Boxer implements Comparable<Boxer> {

	int num = 0;
	int weight = 0;

	int cntFight = 0;
	int cntWin = 0;
	int cntWAH = 0; // (WinAgainstHeavy)

	Boxer(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}

	/**
	 * 대전결과 적용. 각 조건에 따라 대전수, 승수, 무거운상대승수가 캐싱됨
	 * 
	 * @param enemy 상대선수
	 * @param rst   결과 'W'승리, 'L'패배, 'N'미대전
	 */
	public void fight(Boxer enemy, char rst) {

		if (rst != 'N') {
			cntFight++;

			if (rst == 'W') {
				cntWin++;

				if (weight < enemy.weight) {
					cntWAH++;
				}
			}
		}
	}

	/**
	 * 정렬순서 재정의 
	 * 1. 승률 내림차순 
	 * 2. 무거운상대승수 내림차순 
	 * 3. 체중내림차순 
	 * 4. 순번오름차순
	 */
	@Override
	public int compareTo(Boxer o) {

		double myWinRate = this.cntFight == 0 ? 0D : (double)this.cntWin / this.cntFight;
		double enemyWinRate = o.cntFight == 0 ? 0D : (double)o.cntWin / o.cntFight;

		if (myWinRate != enemyWinRate)
			return enemyWinRate - myWinRate > 0 ? 1 : -1;

		if (this.cntWAH != o.cntWAH)
			return o.cntWAH - this.cntWAH;

		if (this.weight != o.weight)
			return o.weight - this.weight;

		return this.num - o.num;
	}

}