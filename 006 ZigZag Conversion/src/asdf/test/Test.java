package asdf.test;

public class Test {

	public String convert(String s, int numRows) {

		if (numRows == 1)
			return s;
		StringBuffer sb = new StringBuffer();
		int n = numRows + numRows - 2, j, k;
		for (int i = 0; i < numRows; i++) {
			j = i;
			k = n - i - i;
			while (j < s.length()) {
				sb.append(s.charAt(j));
				if (i != 0 && i != numRows - 1 && j + k < s.length())
					sb.append(s.charAt(j + k));
				j += n;
			}
		}
		return sb.toString();

	}

	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 */
	// P A H N
	// A P L S I I G
	// Y I R
	/**
	 * And then read line by line: "PAHNAPLSIIGYIR" Write the code that will
	 * take a string and make this conversion given a number of rows:
	 * 
	 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
	 * should return "PAHNAPLSIIGYIR".
	 */

	public static void main(String[] args) {

		Test t = new Test();
		System.out.println((t.convert("ABV", 1)));
System.out.println(Integer.valueOf(""));
	}

}
