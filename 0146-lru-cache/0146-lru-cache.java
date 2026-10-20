class Node {
    int key;
    int val;
    Node prev ;
    Node next;
 
    Node(int val,int key) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev=null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node head=null;
    Node tail =  null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    public int get(int key) {
      if(!map.containsKey(key)) return -1;
      Node curr = map.get(key);
      Node prevnode = curr.prev;
      Node nextnode = curr.next;
      if(nextnode == null) return curr.val;
      if(prevnode == null) head = nextnode;
      if(prevnode!=null) prevnode.next = nextnode;  
      if(nextnode!=null) nextnode.prev = prevnode;
      tail.next = curr;
      curr.prev = tail;
      curr.next=null;
      tail = curr;
      return curr.val;
    }
    public void put(int key, int value) {
       if(capacity == 0) return ;
       if(map.containsKey(key)){
         get(key);
         map.get(key).val = value;
         return ;
       }
       Node n  =  new Node(value,key);
       if(head==null && tail==null){
         head = n;
         tail = head;
       }
       else{
        tail.next = n;
        n.prev = tail;
        tail = n;
       }
       map.put(key,n);       
       if(map.size()>capacity){
         map.remove(head.key);
         head = head.next;
         head.prev = null;
       }
    }
}

