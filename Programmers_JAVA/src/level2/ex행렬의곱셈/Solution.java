package level2.ex행렬의곱셈;


/*
문제 설명
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다.
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