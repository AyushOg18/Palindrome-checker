import java.util.stream.IntStream;

public class PalindromeApp {

    public static void main(String[] args) {
        String input = "No 'x' in Nixon";

        // Execute Use Case 10: Case-Insensitive & Space-Ignored
        boolean isPalindrome = checkRobustPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public static boolean checkRobustPalindrome(String str) {
        // Step 1: Normalize and remove all non-alphanumeric characters
        String cleanStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Step 2: Use IntStream to compare characters from both ends
        // We only need to iterate up to half the length
        return IntStream.range(0, cleanStr.length() / 2)
                .allMatch(i -> cleanStr.charAt(i) == cleanStr.charAt(cleanStr.length() - i - 1));
    }
}