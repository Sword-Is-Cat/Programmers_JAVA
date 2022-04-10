package level2.ex방금그곡;

import java.util.HashMap;
import java.util.Map;

class Solution {

	Map<String, String> sharpMap;

	public String solution(String m, String[] musicinfos) {

		sharpMap = buildSharpMap();

		m = convertSharp(m);

		String title = "(None)";
		int length = -1;

		for (String musicinfo : musicinfos) {
			VO music = checkContain(m, musicinfo);
			if (music != null) {
				if (music.length > length) {
					length = music.length;
					title = music.title;
				}
			}
		}

		return title;
	}

	Map<String, String> buildSharpMap() {

		Map<String, String> map = new HashMap<>();

		map.put("C#", "H");
		map.put("D#", "I");
		map.put("F#", "J");
		map.put("G#", "K");
		map.put("A#", "L");

		return map;
	}

	String convertSharp(String oriStr) {

		String result = oriStr;

		for (String key : sharpMap.keySet()) {
			result = result.replace(key, sharpMap.get(key));
		}

		return result;

	}

	VO checkContain(String key, String info) {

		String[] infos = info.split(",");
		int length = convertTime(infos[1]) - convertTime(infos[0]);
		infos[3] = convertSharp(infos[3]);

		StringBuilder sb = new StringBuilder();

		while (sb.length() < length)
			sb.append(infos[3]);

		String melody = sb.substring(0, length);

		return melody.indexOf(key) == -1 ? null : new VO(length, infos[2]);
	}

	int convertTime(String time) {

		String[] times = time.split(":");

		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}
}

class VO {
	int length;
	String title;

	VO(int length, String title) {
		this.length = length;
		this.title = title;
	}
}