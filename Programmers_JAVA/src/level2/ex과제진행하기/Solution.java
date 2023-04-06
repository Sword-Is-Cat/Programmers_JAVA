package level2.ex과제진행하기;

import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
	public String[] solution(String[][] plans) {

		PriorityQueue<Study> plan = new PriorityQueue<>((a, b) -> Integer.compare(a.startTime, b.startTime));
		Stack<Study> stack = new Stack<>();

		for (String[] row : plans)
			plan.add(new Study(row));

		String[] answer = new String[plans.length];
		int index = 0;

		int currTime = 0;

		while (!plan.isEmpty() || !stack.isEmpty()) {

			if (plan.isEmpty()) {
				//[1] 새 작업이 없음 : 진행중인 작업 하나씩 처리(현재시간 갱신없이 stack만 비워내면 된다)
				
				answer[index++] = stack.pop().subject;
				
			} else if (stack.isEmpty()) {
				//[2] 진행중인 작업이 없음 : 새 작업의 시작시간까지 기다린 후 새 작업 시작
				
				currTime = plan.peek().startTime;
				stack.push(plan.poll());
				
			} else {
				//[3] 새 작업과 진행중인 작업 모두 있음 : 시간비교 필요
				
				if (plan.peek().startTime < currTime + stack.peek().remainTime) {
					//[3-a] 새 작업 시작전에 진행중인 작업 완료 불가 : 진행중작업 잔여시간 갱신, 새 작업 식작
					
					stack.peek().remainTime -= plan.peek().startTime - currTime;
					currTime = plan.peek().startTime;
					stack.push(plan.poll());
					
				} else {
					//[3-b] 새 작업 시작전에 진행중인 작업 완료 : 진행중 작업 완료 및 현재시간 갱신
					
					currTime += stack.peek().remainTime;
					answer[index++] = stack.pop().subject;
					
				}
			}
		}
		return answer;
	}
}

class Study {

	String subject;
	int startTime, remainTime;

	public Study(String[] info) {
		subject = info[0];
		String[] split = info[1].split(":");
		startTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		remainTime = Integer.parseInt(info[2]);
	}
}