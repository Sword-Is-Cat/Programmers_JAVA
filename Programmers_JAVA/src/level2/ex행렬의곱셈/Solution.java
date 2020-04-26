package level2.ex행렬의곱셈;



/*
���� ����
2���� ��� arr1�� arr2�� �Է¹޾�, arr1�� arr2�� ���� ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.
���� ����
��� arr1, arr2�� ��� ���� ���̴� 2 �̻� 100 �����Դϴ�.
��� arr1, arr2�� ���Ҵ� -10 �̻� 20 ������ �ڿ����Դϴ�.
���� �� �ִ� �迭�� �־����ϴ�.
*/

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];       
        for(int a = 0; a<arr1.length ; a++){
            for(int c = 0; c<arr2[0].length ; c++){
                for(int b = 0; b<arr2.length ; b++){
                    answer[a][c] += arr1[a][b] * arr2[b][c];
                }
            }
        }        
        return answer;
    }
}