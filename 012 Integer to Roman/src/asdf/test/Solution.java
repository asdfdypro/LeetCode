package asdf.test;

public class Solution {

	/**
	 * (数字转罗马数字)Given an integer, convert it to a roman numeral. * Input is
	 * guaranteed to be within the range from 1 to 3999.
	 */
	private static String[][] table={
			{"","I","II","III","IV","V","VI","VII","VIII","IX"},
			{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
			{"","M","MM","MMM"}};
	
	//查表法  使用StringBuffer 16ms  使用String7ms 使用StringBuilder(线程不安全)7ms
	public String intToRoman(int num) {
		StringBuilder romanStr = new StringBuilder();
		int[] pos = new int[4];

		for (int i = 0; i < pos.length && num > 0; i++) {
			pos[i] = num % 10;
			num = num / 10;
		}			
		for (int i = 3; i >=0; i--) {
			romanStr.append(table[i][pos[i]]);
		}				
		return romanStr.toString();
	}
	

	public static void main(String[] args) {

		
		Solution solution = new Solution();

		System.out.println(solution.intToRoman(1));
		System.out.println(solution.intToRoman(3999));

		for (int i = 1; i < 11; i++) {
			System.out.println(solution.intToRoman(i));
		}

	}
}