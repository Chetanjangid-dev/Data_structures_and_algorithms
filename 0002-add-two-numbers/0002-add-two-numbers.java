
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2= l2;
        ListNode newhead = null;
        int carry = 0;
        int size = 0;
        ListNode prev = null;
        while(p1!=null || p2!=null || carry>0){
            int firstdig = 0;
            int seconddig = 0;
            if(p1!=null){ 
               firstdig = p1.val;
                p1 = p1.next;
            }
            if(p2!=null){ 
                seconddig = p2.val;
                p2 = p2.next;
            }
            int total  = carry + firstdig + seconddig;
            if(total>9){
                carry = 1;
                total = total%10;
            }
            else{
                carry = 0;
            }
            if(size==0){
                newhead = new ListNode(total);            
                prev = newhead;
            }
            else{
                prev.next =  new ListNode(total);   
                prev = prev.next;
            }
            size++;
         }
         return newhead;
    }
}