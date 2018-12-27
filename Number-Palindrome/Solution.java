//Problem statment : https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
        //int x = -121;
       int safe=x;
       
       long result=0;//Important to declare result as long because, we need to check the integer overflow.
		if(x<0){
			return false;
		}
		try {
			while (x != 0) {
				result = result * 10 + x % 10;
				if(result>Integer.MAX_VALUE)
					return false;
				x /= 10;
			}
			//return Math.toIntExact(result);    
			if(safe==Math.toIntExact(result))
			return true;
			else
			return false;
            
		} catch(ArithmeticException e) {
			return false;
		}
        
    }
}