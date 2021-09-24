package nl.svdoetelaar.lucas;

public class LucasIsOdd {
    public static void main(String[] args) {
        for (long i = 10_000_000L; i > 0; i--) {
            System.out.println(i + ": " + isOdd(i));
        }


    }

    private static boolean isOdd(long n) {
        if (n == Long.MAX_VALUE) {
            return true;
        }
        try {
            return isOdd(n + 2);
        } catch (StackOverflowError e) {
            return false;
        }
    }
}
