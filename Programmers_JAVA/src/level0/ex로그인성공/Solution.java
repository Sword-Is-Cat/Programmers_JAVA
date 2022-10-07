package level0.ex로그인성공;

import java.util.HashMap;

class Solution {
	public String solution(String[] id_pw, String[][] db) {

		HashMap<String, String> dbMap = new HashMap<>();

		for (String[] pair : db)
			dbMap.put(pair[0], pair[1]);

		String result = "fail";

		if (dbMap.containsKey(id_pw[0])) {

			result = dbMap.get(id_pw[0]).equals(id_pw[1]) ? "login" : "wrong pw";

		}

		return result;
	}
}