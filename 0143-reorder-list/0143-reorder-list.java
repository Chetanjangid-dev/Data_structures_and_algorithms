class Solution {
    public void reorderList(ListNode head) 
    {
     if(head==null){
        return ;
     }
     //find middle
     ListNode mid=head;
     ListNode fast=head;
     while(fast !=null && fast.next!=null){
        mid=mid.next;
        fast=fast.next.next;
     }
     // reverse mid  to last node;
     ListNode prev=null;
     while(mid!=null){
        ListNode temp=mid;
        mid=mid.next;
        temp.next=prev;
        prev=temp;      
     }
     //revserse list ka head hoga prev
     //ab actual head to mid-1 node and mid to last node reversed wala inke repsective nodes ko connect krna  h
     
     ListNode first=head;
     ListNode second=prev;
     ListNode temp=null;
     while(second!=null && first!=second){
         if(temp!=null )
           temp.next=first;
         temp=first;
         first=first.next; 
         temp.next=second;
         temp=second;
         second=second.next;
     } 
     return ;
    }
}