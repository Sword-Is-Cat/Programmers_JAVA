package level3.ex매칭점수;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

	Pattern searchPattern;

	public int solution(String word, String[] pages) {

		searchPattern = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);

		HashMap<String, Web> map = new HashMap<>();
		Web[] web = new Web[pages.length];

		for (int i = 0; i < pages.length; i++) {
			web[i] = new Web(pages[i]);
			map.put(web[i].url, web[i]);
		}

		for (int i = 0; i < pages.length; i++) {
			Web page = web[i];

			for (String url : page.links) {
				if (map.containsKey(url))
					map.get(url).dPoint += page.lPoint;
			}
		}

		int ans = -1;
		double max = -1;

		for (int i = 0; i < pages.length; i++) {
			if (max < web[i].dPoint) {
				ans = i;
				max = web[i].dPoint;
			}
		}

		return ans;
	}

	class Web {

		String url;
		ArrayList<String> links;
		double dPoint, lPoint;

		Pattern urlPattern = Pattern.compile("<meta property=[\"']og:url[\"'] content=[\"'](.*?)[\"']/>");
		Pattern linkPattern = Pattern.compile("<a href=[\"'](.*?)[\"']>");

		Web(String body) {

			Matcher urlMatch = urlPattern.matcher(body);
			url = urlMatch.find() ? urlMatch.group(1) : "";

			links = new ArrayList<>();

			Matcher linkMatch = linkPattern.matcher(body);
			while (linkMatch.find()) {
				links.add(linkMatch.group(1));
			}

			Matcher searchMatch = searchPattern.matcher(body.replaceAll("[^a-zA-Z]+", " "));
			while(searchMatch.find())
				dPoint++;
			lPoint = dPoint / links.size();

			//System.out.println("url:" + url + "\nlinks:" + links.toString() + "\ndp:" + dPoint + ", lp:" + lPoint+ "\n##########");
		}
	}
}
