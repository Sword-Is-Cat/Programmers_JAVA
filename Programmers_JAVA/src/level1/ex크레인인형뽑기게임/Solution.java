package level1.ex크레인인형뽑기게임;

/*
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/64061
*/

import java.util.ArrayList;
//import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		
		int answer = 0;
		ArrayList<Integer> basket = new ArrayList<>();
		//Stack<Integer> stack = new Stack<>();

		for (int j : moves) { 
			for (int i = 0; i < board.length; i++) {
				if (board[i][j-1] != 0) {
					if (basket.size() == 0) {
					//if(stack.empty()) {
						basket.add(board[i][j-1]);
						//stack.push(E);
					}else if(basket.get(basket.size()-1) == board[i][j-1]) {
					//else if(stack.peek() == E)
						basket.remove(basket.size()-1);
						//stack.pop()
						answer += 2;
					}else {	
						basket.add(board[i][j-1]);
						//stack.push(E);
					}
					board[i][j-1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
