package level2.exN진수게임;


/*
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 */

import java.util.Stack;

class Solution {
	public String solution(int n, int t, int m, int p) {
		Stack<Character> stack = new Stack<>();
		stack.push('0');
		char[] arr = new char[t];
		int no = 0;
		int i = 0;
		while(arr[t-1] == '\u0000') {
			if(stack.empty()) {
				fillStack(stack, ++no, n);
			}
			if(i%m == p-1) {
				arr[i/m] = stack.peek();
			}
			stack.pop();
			i++;
		}
		return new String(arr);
	}
	public void fillStack(Stack<Character> stack, int no, int n) {
		char[] note = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (no > 0) {
			stack.push(note[no%n]);
			no=no/n;
		}
		return;
	}
}