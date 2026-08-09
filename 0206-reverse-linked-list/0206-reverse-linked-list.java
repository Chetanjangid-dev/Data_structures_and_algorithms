class Solution {
    public ListNode reverseList(ListNode head) {
     ListNode first=null;
     ListNode second=head;
     while(second!=null){
        ListNode temp=second;
        second=second.next;
        temp.next=first;
        first=temp;
     }
     head=first;
     return head;
    }
}