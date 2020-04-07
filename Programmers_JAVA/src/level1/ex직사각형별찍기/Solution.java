package level1.ex직사각형별찍기;

/*
 * 문제 설명
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

제한 조건
n과 m은 각각 1000 이하인 자연수입니다.
 */

import java.util.Scanner;

class Solution {
	public void solution(int n, int m) {

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				System.out.print("*");

			}
			System.out.println();

		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);
        
        sc.close();
    }
}