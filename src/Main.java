public class PalindromeApp {

    public static void main(String[] args) {
        String input = "Deified";

        // Execute Use Case 4: Character Array Based Check
        boolean isPalindrome = checkWithCharArray(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public static boolean checkWithCharArray(String str) {
        // Normalize the string: lowercase and remove non-alphanumeric
        String cleanStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Convert the string to a character array
        char[] charArray = cleanStr.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        // Compare characters from both ends moving towards the middle
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched
    }
}