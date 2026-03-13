/**
 * Service class responsible for palindrome business logic.
 */
class PalindromeService {

    /**
     * Checks if a given string is a palindrome.
     * @param input The string to check.
     * @return true if symmetric, false otherwise.
     */
    public boolean isValid(String input) {
        if (input == null) return false;

        String clean = sanitize(input);
        return checkSymmetry(clean);
    }

    // Encapsulated helper method for data cleaning
    private String sanitize(String str) {
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Encapsulated helper method for logic
    private boolean checkSymmetry(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeApp {
    public static void main(String[] args) {
        // Instantiate the service
        PalindromeService service = new PalindromeService();

        // Data to test
        String sample = "Was it a car or a cat I saw?";

        // Execute the service
        boolean result = service.isValid(sample);

        System.out.println("Testing: " + sample);
        System.out.println("Status: " + (result ? "VALID PALINDROME" : "INVALID"));
    }
}