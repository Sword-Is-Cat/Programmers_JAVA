package level0.ex직각삼각형출력하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        char star = '*';
        
        while(n-->0) {
        	sb.append(star);
        	System.out.println(sb.toString());
        }
        
    }
}