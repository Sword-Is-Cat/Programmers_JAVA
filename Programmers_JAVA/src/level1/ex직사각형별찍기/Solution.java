package level1.ex직사각형별찍기;


/*
 * ���� ����
�� �������� ǥ�� �Է����� �� ���� ���� n�� m�� �־����ϴ�.
��(*) ���ڸ� �̿��� ������ ���̰� n, ������ ���̰� m�� ���簢�� ���¸� ����غ�����.

���� ����
n�� m�� ���� 1000 ������ �ڿ����Դϴ�.
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