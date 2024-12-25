package level1.PCCP_202409_01;

class Solution {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

		int totalLength = convert(video_len);
		int currentTime = convert(pos);
		int[] opening = { convert(op_start), convert(op_end) };

		if (opening[0] <= currentTime && currentTime <= opening[1])
			currentTime = opening[1];

		for (String command : commands) {

			if ("prev".equals(command))
				currentTime = Math.max(0, currentTime - 10);
			else if ("next".equals(command))
				currentTime = Math.min(totalLength, currentTime + 10);

			if (opening[0] <= currentTime && currentTime <= opening[1])
				currentTime = opening[1];
		}

		return convert(currentTime);
	}

	private int convert(String str) {
		String[] arr = str.split(":");
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}

	private String convert(int value) {
		return String.format("%02d:%02d", value / 60, value % 60);
	}
}