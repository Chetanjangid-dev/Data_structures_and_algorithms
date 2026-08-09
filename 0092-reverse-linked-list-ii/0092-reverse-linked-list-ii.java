class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode temp = head;
        ListNode before = null;
        int count = 0;

        while (temp != null) {   // head nahi, temp
            count++;

            if (count < left) {
                before = temp;
                temp = temp.next;
            }
            else {
                ListNode curr = temp;
                ListNode prev = null;

                int time = right - left + 1;

                while (time > 0) {
                    ListNode t = curr;
                    curr = curr.next;
                    t.next = prev;
                    prev = t;
                    time--;
                }

                temp.next = curr;

                if (before != null) {
                    before.next = prev;
                }
                else {
                    head = prev;
                }

                return head;
            }
        }

        return head;
    }
}