class ListNode {
    char val;
    ListNode next;
    ListNode(char val) { this.val = val; }
}

public class PalindromeApp {

    public static void main(String[] args) {
        // Create a Linked List: R -> A -> D -> A -> R
        ListNode head = new ListNode('r');
        head.next = new ListNode('a');
        head.next.next = new ListNode('d');
        head.next.next.next = new ListNode('a');
        head.next.next.next.next = new ListNode('r');

        // Execute Use Case 8: Linked List Based Check
        boolean isPalindrome = isLinkedListPalindrome(head);

        System.out.println("Is Linked List Palindrome: " + isPalindrome);
    }

    public static boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle using Fast and Slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // Step 3: Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}