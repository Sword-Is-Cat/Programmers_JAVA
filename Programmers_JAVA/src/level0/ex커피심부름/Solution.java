package level0.ex커피심부름;

class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for(String menu : order) {
        	answer += menu.contains("cafelatte")?5000:4500;
        }
        return answer;
    }
}