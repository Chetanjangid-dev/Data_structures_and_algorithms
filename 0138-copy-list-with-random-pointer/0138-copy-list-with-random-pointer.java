class Solution {
    public Node copyRandomList(Node head) {
     HashMap<Node,Integer> original  =  new HashMap<>();         
     HashMap<Integer,Node> copy  =  new HashMap<>();         
     Node temp  =  head;
     int seq=1;
     while(temp!=null){
      original.put(temp,seq);
      temp=temp.next;
      seq++;
     }
     temp=head;
     Node head2 = null;
     Node prev = null;
     seq = 1;
     while(temp!=null){
         Node  n =  new Node(temp.val);
         if(head2==null){
            head2 =n;
            prev = head2;
         }
         else{
            prev.next = n;
            prev = n;
         }
         copy.put(seq,n);
         seq++;
         temp=temp.next;
     }
     temp = head;
     Node temp2 = head2;
     while(temp!=null && temp2!=null){
       if(temp.random==null){
         temp2.random =null;
       } 
       else{
       int randseq = original.get(temp.random);
       temp2.random = copy.get(randseq);
       }
       temp=temp.next;
       temp2 = temp2.next;
     }  
    return head2;          
    }
}