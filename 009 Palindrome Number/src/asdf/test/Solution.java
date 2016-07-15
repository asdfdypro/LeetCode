package asdf.test;

public class Solution {

	/**
	 * (判断数字是否是回文数)Determine whether an integer is a palindrome. Do this without extra space.
	 */
	//翻转数字，看是否相等（会有溢出，用例没有溢出情况，使用long要慢许多）
	
	  public boolean isPalindrome(int x) {
	        if(x<0)
	            return false;
	        long old=x;    
	        long copy=0;
	        while(x>0){
	            copy=copy*10+x%10;
	            x=x/10;
	            System.out.println(x);
	        }
	        return copy==old;
	        
	    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(147483648));
		System.out.println(solution.isPalindrome(123));
	}
}