package level1.PCCE_202409_09;

import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);
        int answer = 0;
        while(wallet[0]<bill[0]||wallet[1]<bill[1]){
            bill[1]/=2;
            Arrays.sort(bill);
            answer++;
        }
        return answer;
    }
}