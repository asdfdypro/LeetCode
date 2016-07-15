package asdf.test;

public class Solution {

	/**
	 * (数字转英文) Convert a non-negative integer to its english words
	 * representation. Given input is guaranteed to be less than 231 - 1.
	 * 
	 * For example,
	 * 
	 * 123 -> "One Hundred Twenty Three"
	 * 
	 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
	 * 
	 * 1234567 ->
	 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
	 * 
	 * 
	 * Did you see a pattern in dividing the number into chunk of words? For
	 * example, 123 and 123000.
	 * 
	 * Group the number by thousands (3 digits). You can write a helper function
	 * that takes a number less than 1000 and convert just that chunk to words.
	 * 
	 * There are many edge cases. What are some good test cases? Does your code
	 * work with input such as 0? Or 1000010? (middle chunk is zero and should
	 * not be printed out)
	 */

	private String[] nums = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ",
			"Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
			"Sixteen ", "Seventeen ", "Eighteen ", "Nineteen " };
	private String[] dozens = { "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
			"Eighty ", "Ninety ", "Hundred " };
	private String[] units = { "", "Thousand ", "Million ", "Billion " };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String res = "";
		int n, m, h;
		int unitPos = 0;
		do {
			n = num % 1000;
			num /= 1000;
			if(n==0){//某些级别没有
				unitPos++;
				continue;
			}
			
			res = units[unitPos++] + res;
			h = n / 100;
			n = n % 100;
			

			if (n < 20) {
				res = nums[n] + res;
			} else {
				m = n / 10;
				n = n % 10;
				if (n > 0)
					res = nums[n] + res;
				res = dozens[m - 2] + res;
			}

			if (h > 0) {
				res = nums[h] + dozens[dozens.length - 1] + res;
			}
		} while (num > 0);

		return res.trim();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 25; i++) {
			System.out.println(solution.numberToWords(i));
		}
		for (int i = 99; i < 103; i++) {
			System.out.println(solution.numberToWords(i));
		}

		for (int i = 999; i < 1003; i++) {
			System.out.println(solution.numberToWords(i));
		}
		System.out.println(solution.numberToWords(123000));
		System.out.println(solution.numberToWords(1000010));//跨级为0
		System.out.println(solution.numberToWords(9990));
		System.out.println(solution.numberToWords(Integer.MAX_VALUE));// Two
																		// Billion
																		// One
																		// Hundred
																		// Forty
		// Seven Million Four Hundred
		// Eighty Three Thousand Six
		// Hundred Forty Seven

	}
}
