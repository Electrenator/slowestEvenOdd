package nl.svdoetelaar.fast;

public class FastAsFuck {
    public static void main(String[] args) {
        for (long i = 10_000_000L; i > 0; i--) {
            System.out.println(i + ": " + (i%2==0));
        }
    }
}
