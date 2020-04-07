package level1.ex크레인인형뽑기게임;

/*
문제 : https://programmers.co.kr/learn/courses/30/lessons/64061
*/

import java.util.ArrayList;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		ArrayList<Integer> basket = new ArrayList<>();

		for (int j : moves) { 
        // n번째 이동
			for (int i = 0; i < board.length; i++) {
				if (board[i][j-1] != 0) {
                // 인형이 있는 칸을 찾음
					if (basket.size() == 0) {						
						basket.add(board[i][j-1]);
                    // 옮겨질 바구니가 비었다면 인형 추가
					}else if(basket.get(basket.size()-1) == board[i][j-1]) {						
						basket.remove(basket.size()-1);
						answer += 2;
                    // 바구니에 들어있는 인형이 지금넣는 인형과 동일하다면 바구니 최상단 인형 제거
                    // 인형은 한번에 두개가 제거되므로 answer+2
					}else {						
						basket.add(board[i][j-1]);
					}
                    // 아무 상황도 아니므로 바구니에 인형추가
					board[i][j-1] = 0;					
					break;
                    // 인형을 뽑은칸을 빈칸으로 설정하고 n번째 move 종료
				}
			}
		}
		return answer;
	}

//	public static void main(String[] args) {
//		Solution s = new Solution();
//		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//		int[] moves = {1,5,3,5,1,2,1,4};
//		System.out.println(s.solution(board, moves));
//	}
}