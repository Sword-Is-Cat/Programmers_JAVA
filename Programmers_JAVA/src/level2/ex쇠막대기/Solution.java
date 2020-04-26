package level2.ex쇠막대기;


/*
* https://programmers.co.kr/learn/courses/30/lessons/42585
*/

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        int cnt = 0;

        char[] arr = arrangement.toCharArray();
        
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] == '('){
                cnt++;
                answer++;
            }else{
                if(arr[i-1] == '('){
                    cnt--;
                    answer--;
                    answer += cnt;
                }else{
                    cnt--;
                }
            }
        }
        
        return answer;
    }
}