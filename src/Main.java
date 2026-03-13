// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// 2. Implementation: Two-Pointer Strategy
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String s = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

// 3. Implementation: Recursive Strategy
class RecursiveStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String s = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isRecursive(s);
    }
    private boolean isRecursive(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isRecursive(s.substring(1, s.length() - 1));
    }
}

// 4. The Context Class (The "App" or Service)
class PalindromeValidator {
    private PalindromeStrategy strategy;

    // We can swap strategies at any time
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String text) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.check(text);
    }
}

// 5. Execution
public class PalindromeApp {
    public static void main(String[] args) {
        PalindromeValidator validator = new PalindromeValidator();
        String testText = "A man, a plan, a canal: Panama";

        // Use Two-Pointer Algorithm
        validator.setStrategy(new TwoPointerStrategy());
        System.out.println("Two-Pointer Result: " + validator.validate(testText));

        // Switch to Recursive Algorithm at runtime
        validator.setStrategy(new RecursiveStrategy());
        System.out.println("Recursive Result: " + validator.validate(testText));
    }
}