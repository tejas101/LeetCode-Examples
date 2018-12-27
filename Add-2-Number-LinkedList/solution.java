//https://leetcode.com/problems/add-two-numbers/
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head= new ListNode(0);
		ListNode finR= head;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		int carry=0;
		while(l1!=null || l2!=null){
			int result=l1.val+ l2.val+carry;
			if(result>9){
				int temp=result;
				result=result%10;
				carry=temp/10;
			}
			else carry=0;//whenever carry is not generated, always reset it.
			head.val=result;

			if(l1.next!=null && l2.next!=null)
			{head.next=new ListNode(carry);
			head=head.next;}
			else if(l1.next==null && l2.next==null && carry>0)
				head.next=new ListNode(carry);
			l1=l1.next;
			l2=l2.next;
			if(l1==null && l2!=null){ //l1 ends and l2 is still there
				while(l2!=null){
					head.next=new ListNode(0);
					head=head.next;
					result=l2.val+carry;
					carry=0;//whenever carry is not generated, always reset it.
					if(result>9)
					{

						int temp=result;
						result=result%10;
						carry=temp/10;  
					}
					head.val = result;
					if(carry!=0 && l2.next ==null){//if there is a carry and l2 also ends, then just add carry to left most node
						head.next=new ListNode(0);
						head=head.next;
						head.val = carry;
						carry=0;//after carray is added to the node, always reset it.
					}

					l2 = l2.next;
				}
				return finR;

			}
			else if(l1!=null && l2==null) //l2 ends and l1 is still there
			{  
				while(l1!=null){
					head.next=new ListNode(0);
					head=head.next;
					result=l1.val+carry;
					carry=0;//whenever carry is not generated, always reset it.
					if(result>9)
					{

						int temp=result;
						result=result%10;
						carry=temp/10;  
					}
					head.val = result;
					if(carry!=0 && l1.next ==null){//if there is a carry and l1 also ends, then just add carry to left most node
						head.next=new ListNode(0);
						head=head.next;
						head.val = carry;
						carry=0;//after carray is added to the node, always reset it.
					}
					l1 = l1.next;


				}
				return finR;
			}
		}
		return finR;  
	}
}