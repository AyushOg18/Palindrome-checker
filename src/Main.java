import java.util.Stack;

public class PalindromeApp {

    public static void main(String[] args) {
        String input = "Racecar";

        // Execute Use Case 5: Stack-Based Check
        boolean isPalindrome = checkWithStack(input);

        System.out.println("Input: " + input);
        System.out.println("Result: " + (isPalindrome ? "Palindrome" : "Not a Palindrome"));
    }

    public static boolean checkWithStack(String str) {
        // Normalize: lowercase and remove non-alphanumeric
        String cleanStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();

        // Step 1: Push all characters onto the stack
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
        }

        // Step 2: Pop characters and compare with the original string
        for (int i = 0; i < cleanStr.length(); i++) {
            char poppedChar = stack.pop();
            if (cleanStr.charAt(i) != poppedChar) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched in reverse order
    }
}