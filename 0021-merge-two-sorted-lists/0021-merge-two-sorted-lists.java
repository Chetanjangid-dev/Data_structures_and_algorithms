class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2!=null) return list2;
        if(list2==null && list1!=null) return list1; 
        ListNode first = list1;
        ListNode second = list2;
        ListNode head = null;
        ListNode prev= null;
        boolean headnotsetted = true;
        while(first!=null && second!=null){
            ListNode temp = null;
            if(first.val<second.val)
            {
               temp = new ListNode(first.val);
               first=first.next;
            }
            else{
               temp = new ListNode(second.val);
               second=second.next;
            } 
            if(headnotsetted){
                head = temp;
                prev = head;
                headnotsetted=false;
            }
            else{
                prev.next = temp;
                prev = temp;
            }
        }
        while(first!=null && prev!=null){
             prev.next = first;
             prev = first;
             first=first.next;
        }
        while(second!=null && prev!=null){
            prev.next = second;
             prev= second;
             second=second.next;
        }
       return head;
    }
}