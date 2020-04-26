package level2.ex영어끝말잇기;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 */

import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
	    String last = "";
	    boolean first = true;
        int i = 0;
        HashSet<String> set = new HashSet<>();
        for(;i<words.length ; i++){
            if(!set.add(words[i]))
                break;
            if(first)
                first = false;
            else{
                if(!words[i].substring(0,1).equals(last))
                    break;    
            }
            last = words[i].substring(words[i].length()-1);
            if(i==words.length-1)
                return answer;
        }
        answer[0] = i%n+1;
        answer[1] = i/n+1;
        return answer;
    }
}