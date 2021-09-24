package nl.svdoetelaar;

import nl.svdoetelaar.config.Numbers;

import java.time.Duration;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Arrays.stream(Numbers.NUMBERS).forEach(n -> {
                    long startSampleTime = System.nanoTime();
                    boolean result = SanderPander.isOdd(n);
                    System.out.printf("%10d: %-7s Sample Time: %dns\n", n, result, (System.nanoTime() - startSampleTime));
                }
        );

        long endTime = System.nanoTime();

        System.out.printf("\nTotal Duration: %d.%d seconds\n",
                Duration.ofNanos(endTime - startTime).toSeconds(),
                Duration.ofNanos(endTime - startTime).toMillis() % 1000);
        System.out.printf("Average time %d.%d seconds over %d\n",
                Duration.ofNanos((endTime - startTime) / Numbers.NUMBERS.length).toSeconds(),
                Duration.ofNanos((endTime - startTime) / Numbers.NUMBERS.length).toNanos() % 1_000_000,
                Numbers.NUMBERS.length);
    }
}