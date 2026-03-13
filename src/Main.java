public class PalindromeApp {

    public static void main(String[] args) {
        String input = "Malayalam";

        // Normalize for the recursive check
        String cleanInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Execute Use Case 9: Recursive Check
        boolean isPalindrome = isRecursivePalindrome(cleanInput);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public static boolean isRecursivePalindrome(String str) {
        // Base Case 1: If length is 0 or 1, it's a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Check if first and last characters match
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursive Step: Slice the string to remove first and last chars
            return isRecursivePalindrome(str.substring(1, str.length() - 1));
        }

        // If characters don't match, it's not a palindrome
        return false;
    }
}