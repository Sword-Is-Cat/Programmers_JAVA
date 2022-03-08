package level2.ex파일명정렬;

import java.util.Arrays;

class Solution {
	public String[] solution(String[] files) {

		File[] fileArray = new File[files.length];

		for (int i = 0; i < files.length; i++)
			fileArray[i] = new File(files[i], i);

		String[] answer = new String[files.length];

		Arrays.sort(fileArray);

		for (int i = 0; i < files.length; i++)
			answer[i] = fileArray[i].fileName;

		return answer;
	}
}

class File implements Comparable<File> {

	String fileName;
	String head;
	int num;
	int index;

	File(String file, int i) {

		fileName = file;
		index = i;
		head = file.toLowerCase().split("[0-9]+")[0];
		num = Integer.parseInt(file.split("[^0-9]+")[1]);

	}

	@Override
	public int compareTo(File o) {
		int result = head.compareToIgnoreCase(o.head);
		if (result == 0) result = num - o.num;
		if (result == 0) result = index - o.index;
		return result;
	}
}