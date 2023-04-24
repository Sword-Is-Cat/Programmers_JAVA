package level0.ex공백으로구분하기2;

class Solution {
    public String[] solution(String my_string) {
        return my_string.trim().split("[ ]+");
    }
}