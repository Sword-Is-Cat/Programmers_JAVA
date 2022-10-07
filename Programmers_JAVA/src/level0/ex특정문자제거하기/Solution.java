package level0.ex특정문자제거하기;

class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }
}