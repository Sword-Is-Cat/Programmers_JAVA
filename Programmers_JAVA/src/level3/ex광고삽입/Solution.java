package level3.ex광고삽입;

class Solution {

	int[] viewers;

	public String solution(String play_time, String adv_time, String[] logs) {

		int play = timeParse(play_time), adt = timeParse(adv_time);
		viewers = new int[play + 1];

		for (String log : logs) {
			String[] arr = log.split("-");
			viewers[timeParse(arr[0])]++;
			viewers[timeParse(arr[1])]--;
		}

		for (int t = 1; t < viewers.length; t++) {
			viewers[t] += viewers[t - 1];
		}

		int start_time = 0;
		long max = 0, temp = 0;

		for (int t = 0; t < viewers.length; t++) {
			temp += viewers[t];
			if (adt <= t) {
				temp -= viewers[t - adt];
			}
			if (max < temp) {
				start_time = t - adt + 1;
				max = temp;
			}
		}

		return timeStringify(Math.max(0, start_time));
	}

	protected int timeParse(String str) {
		String[] arr = str.split(":");
		return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
	}

	protected String timeStringify(int time) {
		return new StringBuilder()// hh:mm:ss
				.append(paddingOne(Integer.toString(time / 3600))).append(":")
				.append(paddingOne(Integer.toString(time / 60 % 60))).append(":")
				.append(paddingOne(Integer.toString(time % 60))).toString();
	}

	protected String paddingOne(String str) {
		return ("00" + str).substring(str.length());
	}

	public static void main(String[] args) {
		String rst;
		rst = new Solution().solution("02:03:55", "00:14:15", new String[] { "01:20:15-01:45:14", "00:40:31-01:00:00",
				"00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30" });
		System.out.println(rst); // expect "01:30:59"

		rst = new Solution().solution("99:59:59", "25:00:00",
				new String[] { "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00" });
		System.out.println(rst); // expect "01:00:00"

		rst = new Solution().solution("50:00:00", "50:00:00",
				new String[] { "15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45" });
		System.out.println(rst); // expect "00:00:00"
	}
}