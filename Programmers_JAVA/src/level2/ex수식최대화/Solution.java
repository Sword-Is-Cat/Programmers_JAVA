package level2.ex수식최대화;

import java.util.ArrayList;

class Solution {
	public long solution(String expression) {

		// 초기값 셋팅
		String[] longArr = expression.split("[^0-9]");
		ArrayList<Long> longList = new ArrayList<Long>();
		for (int i = 0; i < longArr.length; i++)
			longList.add(Long.parseLong(longArr[i]));

		String[] opsArr = expression.split("[0-9]+");
		ArrayList<String> opsList = new ArrayList<String>();
		for (int i = 1; i < opsArr.length; i++)
			opsList.add(opsArr[i]);
		// !초기값셋팅

		// 연산용 변수
		ArrayList<Long> longTemp;
		ArrayList<String> opsTemp;
		long max = 0;
		// !연산용 변수 선언

		// 원본 복사 후 3개의 연산을 순차로 실행, 마지막 남은 수의 절대값을 캐싱
		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "+", "-", "*");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "+", "*", "-");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "-", "+", "*");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "-", "*", "+");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "*", "+", "-");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		longTemp = new ArrayList<Long>(longList);
		opsTemp = new ArrayList<String>(opsList);
		calcProc(longTemp, opsTemp, "*", "-", "+");
		max = Math.max(max, Math.abs(longTemp.get(0)));

		return max;
	}

	public void calcProc(ArrayList<Long> longLi, ArrayList<String> opsLi, String op1, String op2, String op3) {
		calc(longLi, opsLi, op1);
		calc(longLi, opsLi, op2);
		calc(longLi, opsLi, op3);
	}

	public void calc(ArrayList<Long> longLi, ArrayList<String> opsLi, String ops) {

		int i = 0;
		int length = opsLi.size();

		while (i < length) {
			if (ops.equals(opsLi.get(i))) {
				switch (ops) {
				case "+":
					longLi.set(i, longLi.get(i) + longLi.get(i + 1));
					break;
				case "-":
					longLi.set(i, longLi.get(i) - longLi.get(i + 1));
					break;
				case "*":
					longLi.set(i, longLi.get(i) * longLi.get(i + 1));
					break;
				}
				longLi.remove(i + 1);
				opsLi.remove(i);
				i--;
				length--;
			}
			i++;
		}

	}

}