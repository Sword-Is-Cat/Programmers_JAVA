package level1.ex숫자문자열과영단어;

class Solution {
	
	String[] dictionary;
	
    public int solution(String s) {
    	
    	setDictionary();
    	
    	for(int i = 0 ; i<dictionary.length ; i++) {
    		s = s.replaceAll(dictionary[i], Integer.toString(i));
    	}
    	
        return Integer.parseInt(s);
    }
    
    public void setDictionary() {
    	
    	this.dictionary = new String[10];
    	
    	dictionary[0] = "zero";
    	dictionary[1] = "one";
    	dictionary[2] = "two";
    	dictionary[3] = "three";
    	dictionary[4] = "four";
    	dictionary[5] = "five";
    	dictionary[6] = "six";
    	dictionary[7] = "seven";
    	dictionary[8] = "eight";
    	dictionary[9] = "nine";
    	
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().solution("one4seveneight"));
	}
}