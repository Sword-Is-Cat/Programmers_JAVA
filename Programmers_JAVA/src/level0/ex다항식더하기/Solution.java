package level0.ex다항식더하기;

class Solution {
	public String solution(String polynomial) {

		String[] arr = polynomial.split("[+ ]+");
		int x = 0, c = 0;

		for (String part : arr) {

			if (part.contains("x"))
				x += part.replace("x", "").isEmpty() ? 1 : Integer.parseInt(part.replace("x", ""));
			else
				c += Integer.parseInt(part);

		}

		StringBuilder sb = new StringBuilder();

		if (x > 0) {
			if (x > 1)
				sb.append(x);
			sb.append("x");
		}

		if (x > 0 && c > 0)
			sb.append(" + ");

		if (c > 0)
			sb.append(c);

		return sb.length() == 0 ? "0" : sb.toString();
	}
}