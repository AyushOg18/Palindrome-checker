public class PalindromeApp {

    public static void main(String[] args) {
        // Use Case 1: Welcome Message
        displayWelcome();

        // Use Case 2: Hardcoded Palindrome Result
        String testWord = "Madam";

        // Use Case 3: Palindrome Check Using String Reverse
        executeReverseCheck(testWord);
    }

    public static void displayWelcome() {
        System.out.println("*****************************************");
        System.out.println("* WELCOME TO THE PALINDROME CHECKER  *");
        System.out.println("* Checking symmetry since 2024     *");
        System.out.println("*****************************************");
    }

    public static void executeReverseCheck(String original) {
        // Step 1: Normalize (Lowercase & remove non-alphanumeric)
        String clean = original.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Step 2: Reverse the string using StringBuilder
        String reversed = new StringBuilder(clean).reverse().toString();

        // Step 3: Compare and Print Results
        System.out.println("\nOriginal Word: " + original);
        System.out.println("Reversed Word: " + reversed);

        if (clean.equals(reversed)) {
            System.out.println(">>> SUCCESS: This is a palindrome!");
        } else {
            System.out.println(">>> FAILURE: Not a palindrome.");
        }
    }
}