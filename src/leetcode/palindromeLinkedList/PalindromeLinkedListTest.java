package leetcode.palindromeLinkedList;

public class PalindromeLinkedListTest {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(23);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(node1);
        System.out.println("result = " + result);
    }
}
