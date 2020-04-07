package level1.exũ���������̱����;

/*
���� : https://programmers.co.kr/learn/courses/30/lessons/64061
*/

import java.util.ArrayList;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		ArrayList<Integer> basket = new ArrayList<>();

		for (int j : moves) { 
        // n��° �̵�
			for (int i = 0; i < board.length; i++) {
				if (board[i][j-1] != 0) {
                // ������ �ִ� ĭ�� ã��
					if (basket.size() == 0) {						
						basket.add(board[i][j-1]);
                    // �Ű��� �ٱ��ϰ� ����ٸ� ���� �߰�
					}else if(basket.get(basket.size()-1) == board[i][j-1]) {						
						basket.remove(basket.size()-1);
						answer += 2;
                    // �ٱ��Ͽ� ����ִ� ������ ���ݳִ� ������ �����ϴٸ� �ٱ��� �ֻ�� ���� ����
                    // ������ �ѹ��� �ΰ��� ���ŵǹǷ� answer+2
					}else {						
						basket.add(board[i][j-1]);
					}
                    // �ƹ� ��Ȳ�� �ƴϹǷ� �ٱ��Ͽ� �����߰�
					board[i][j-1] = 0;					
					break;
                    // ������ ����ĭ�� ��ĭ���� �����ϰ� n��° move ����
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