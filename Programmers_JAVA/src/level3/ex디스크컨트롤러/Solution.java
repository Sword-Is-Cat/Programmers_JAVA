package level3.ex디스크컨트롤러;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public int solution(int[][] jobs) {
		
		/*
		 * jobs 배열을 요청시간순(동시요청 시 처리시간 짧은순)으로 재정렬한다.
		 * 처리시간 오름차순으로 자동정렬되는 PriorityQueue를 선언 
		 */

		Arrays.sort(jobs, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
		PriorityQueue<int[]> que = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

		/*
		 * 다음 요청될 job을 선택할 index, 현재시간 및 총 소요시간을 count할 변수 선언 
		 */
		
		int jobIndex = 0;
		int curTime = 0;
		int sumTime = 0;

		/*
		 * job이 요청되고 처리되는 프로세스 구현
		 */
		
		while (jobIndex < jobs.length || !que.isEmpty()) {

			//System.out.println("");
			//System.out.println("CYCLE STATUS >> curTime:" + curTime + ", queSize:" + que.size() + ", sumTime:" + sumTime);

			while (jobIndex < jobs.length && curTime >= jobs[jobIndex][0]) {

				//System.out.println("# add que(cur:" + curTime + "):" + jobs[jobIndex][0] + "," + jobs[jobIndex][1]);
				que.add(jobs[jobIndex++]);

			}

			if (que.isEmpty()) {

				curTime = jobs[jobIndex][0];
				//System.out.println("# add que(empty):" + jobs[jobIndex][0] + "," + jobs[jobIndex][1]);
				que.add(jobs[jobIndex++]);

			}

			int[] proc = que.poll();
			curTime += proc[1];
			sumTime += curTime - proc[0];
			//System.out.println("proccess >> take:" + proc[1] + ", cur:" + curTime + ", sum:" + sumTime);

		}

		return sumTime / jobs.length;

	}

	public static void main(String[] args) {

		int[][] arr = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 }, { 15, 2 },
				{ 35, 43 }, { 26, 1 } };
		System.out.println(new Solution().solution(arr));

	}

}