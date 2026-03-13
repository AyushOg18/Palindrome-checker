import java.util.ArrayList;
import java.util.List;

// Reuse the Strategy Interface from UC12
interface PalindromeStrategy {
    boolean check(String input);
}

// Strategy 1: String Reverse (Using StringBuilder)
class ReverseStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
}

// Strategy 2: Two-Pointer (Manual Array Traversal)
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

public class PalindromeApp {
    public static void main(String[] args) {
        String testInput = "A man, a plan, a canal: Panama".repeat(100); // Larger string for better measurement

        System.out.println("--- Palindrome Performance Benchmark ---");
        System.out.println("Input Length: " + testInput.length() + " characters\n");

        runBenchmark("String Reverse", new ReverseStrategy(), testInput);
        runBenchmark("Two-Pointer   ", new TwoPointerStrategy(), testInput);
    }

    private static void runBenchmark(String name, PalindromeStrategy strategy, String input) {
        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.printf("Strategy: %s | Result: %b | Time: %d ns%n",
                name, result, duration);
    }
}