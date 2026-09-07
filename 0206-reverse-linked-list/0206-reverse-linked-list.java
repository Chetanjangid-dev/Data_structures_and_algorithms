
class Solution {
    public ListNode reverseList(ListNode head) {
     ListNode prev = null;
     ListNode curr = head;
     ListNode temp = null;
     while(curr!=null){
        temp = curr;
        curr=curr.next;
        temp.next = prev;
        prev = temp;
     }   
     head = prev;
     return head;
    }
}