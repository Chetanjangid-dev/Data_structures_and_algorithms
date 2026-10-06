/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */  
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1!=null && list2==null) return list1;
    if(list2!=null && list1==null) return list2;
    ListNode first = list1;
    ListNode second = list2;
    ListNode head = null;
    ListNode prev = head;
    while(first!=null && second!=null){
          if(head==null){
               if(first.val< second.val) {head  = first;first=first.next;}
               else {head =  second ;second=second.next;}
               prev = head;
               continue;
          }
          if(first.val<second.val){
            prev.next = first;
            prev=first;
            first=first.next;
          }
          else{
             prev.next = second;
             prev = second;
             second=second.next;
          }
          
    }
    if(prev!=null){
        if(first==null) prev.next = second;
        else{prev.next=first;}
    }
    return head;
    }
}