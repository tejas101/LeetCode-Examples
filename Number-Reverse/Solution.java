//Problem Statment : https://leetcode.com/problems/reverse-integer/
class Solution {
	public int reverse(int x) {
		long result=0;//Important to declare result as long because, we need to check the integer overflow.
		if(x%10==0)
			x /= 10;
		try {
			while (x != 0) {
				result = result * 10 + x % 10;
				if(result>Integer.MAX_VALUE)
					return 0;
				x /= 10;
			}
			return Math.toIntExact(result);    
		} catch(ArithmeticException e) {
			return 0;
		}


	}



}