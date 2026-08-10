class Solution {
    public boolean isPalindrome(ListNode head) {
     if(head==null || head.next==null){
        return true;
     }  
     ListNode slow=head;
     ListNode fast=head;
     int len=1;
     while(fast.next!=null){
        fast=fast.next.next;
        if(fast==null){break;}
        slow=slow.next;
     }
     ListNode prev=null;
     ListNode curr=slow.next;
     slow.next=null;
     while(curr!=null){
        ListNode temp=curr;
        curr=curr.next;
        temp.next=prev;
        prev=temp;
     }
     ListNode first=head;
     ListNode second=prev;
     while(second!=null)
     {
        if(first.val!=second.val){
            return false;
        }
        first=first.next;
        second=second.next;
     }
     return true;
    }
}