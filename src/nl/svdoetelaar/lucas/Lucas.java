package nl.svdoetelaar.lucas;

public class Lucas {
    public static boolean isOdd(long n) {
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
