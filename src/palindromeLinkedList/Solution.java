package palindromeLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Solution {
    public boolean isPalindrome(ListNode head) {

       ListNode reverse = null;
       ListNode walker = head;
       ListNode runner = head;

       while(runner != null && runner.next != null) {
           runner = runner.next.next;
           reverse = new ListNode(walker.val, reverse);
           walker = walker.next;
       }
       if(runner != null) {
           walker = walker.next;
       }

       while (reverse != null && reverse.val == walker.val) {
           reverse = reverse.next;
           walker = walker.next;
       }
       return reverse == null;
    }
}
