import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeApp {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";

        // Execute Use Case 7: Deque-Based Optimized Check
        boolean isPalindrome = checkWithDeque(input);

        System.out.println("Input: " + input);
        System.out.println("Palindrome Status: " + isPalindrome);
    }

    public static boolean checkWithDeque(String str) {
        // Normalize: lowercase and remove non-alphanumeric
        String cleanStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        // ArrayDeque is more efficient than LinkedList for this purpose
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to the Deque
        for (char c : cleanStr.toCharArray()) {
            deque.addLast(c);
        }

        // Compare from both ends simultaneously
        while (deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();

            if (!first.equals(last)) {
                return false; // Symmetry broken
            }
        }

        return true; // Symmetric throughout
    }
}