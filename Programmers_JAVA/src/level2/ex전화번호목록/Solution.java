package level2.ex전화번호목록;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
        });
        
        for(int i = 0 ; i<phone_book.length-1 ; i++) {
        	for(int j = i+1 ; j<phone_book.length ; j++) {
        		if(phone_book[j].indexOf(phone_book[i])==0) {
        			answer = false;
        		}
        	}
        }
        
        
        return answer;
    }
}