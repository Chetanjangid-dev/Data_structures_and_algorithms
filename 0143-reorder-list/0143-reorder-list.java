class Solution {
    public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast!= null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode first = head;
    ListNode second = slow.next;
    slow.next=null;
    ListNode prev = null;
    ListNode curr = second;
    while(curr!=null){
        ListNode temp = curr;
        curr=curr.next;
        temp.next=prev;
        prev=temp;
    } 
    second = prev;
    //wehnever u use 2 pointers  approach in linked list  alswya truy to main two diff temp 1 temp2 for bth pointers
    while(first!=null && second!=null){
        ListNode temp1 = first.next;
        ListNode temp2 =second.next;
        first.next = second;
        second.next = temp1;
        first=temp1;
        second=temp2;   
    }
    }
}