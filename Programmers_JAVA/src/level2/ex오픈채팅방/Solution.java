package level2.ex오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public String[] solution(String[] record) {

		Map<String, String> map = new HashMap<>();
		List<Record> list = new ArrayList<>();

		for (String log : record) {
			
			String[] arr = log.split(" ");
			
			if (arr[0].equals("Change"))
				map.replace(arr[1], arr[2]);
			
			else if (arr[0].equals("Enter")) {
				
				list.add(new Record(arr[0], arr[1]));
				
				if (!map.containsKey(arr[1]))
					map.put(arr[1], arr[2]);
				
				else
					map.replace(arr[1], arr[2]);
				
			} else
				list.add(new Record(arr[0], arr[1]));
		}

		String[] answer = new String[list.size()];

		for (int i = 0; i < answer.length; i++) {
			
			if (list.get(i).sort.equals("Enter"))
				answer[i] = map.get(list.get(i).uid) + "님이 들어왔습니다.";
			
			else
				answer[i] = map.get(list.get(i).uid) + "님이 나갔습니다.";
		}

		return answer;
	}

}

class Record {

	String sort;
	String uid;

	public Record(String inOut, String name) {
		this.sort = inOut;
		this.uid = name;
	}
}