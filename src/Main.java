import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeApp {

    public static void main(String[] args) {
        String input = "Rotator";

        // Execute Use Case 6: Queue + Stack Based Check
        boolean isPalindrome = checkWithQueueAndStack(input);

        System.out.println("Input: " + input);
        System.out.println("Palindrome Status: " + isPalindrome);
    }

    public static boolean checkWithQueueAndStack(String str) {
        // Normalize: lowercase and remove non-alphanumeric
        String cleanStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Step 1: Fill both structures
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Step 2: Compare characters from both ends simultaneously
        while (!stack.isEmpty()) {
            // stack.pop() gets the end, queue.remove() gets the start
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }
}