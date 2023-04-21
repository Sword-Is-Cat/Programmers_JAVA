package level0.ex대소문자바꿔서출력하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		char[] arr = a.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Character.isLowerCase(arr[i]) ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
		}
		System.out.println(new String(arr));

	}
}