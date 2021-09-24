package nl.svdoetelaar;

import nl.svdoetelaar.config.FastAsFuck;
import nl.svdoetelaar.config.Numbers;
import nl.svdoetelaar.submissions.hva.SanderPander;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] numbers = Numbers.EASY_NUMBERS;

        List<Boolean> correctResults = Arrays.stream(numbers).mapToObj(FastAsFuck::isOdd).collect(Collectors.toList());
        List<Boolean> results = new LinkedList<>();

        long startTime = System.nanoTime();

        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            long startSampleTime = System.nanoTime();
            boolean result = SanderPander.isOdd(numbers[i]);
            if (result != correctResults.get(i)) {
                System.out.printf("incorrect result, aborting. Number: %d, expected: %b, got: %b", numbers[i], correctResults.get(i), result);
                break;
            }
            results.add(result);
            System.out.printf("(%3d:%3d) %10d: %-7s Sample Time: %dns\n", i + 1, numbers.length, numbers[i], result, (System.nanoTime() - startSampleTime));
        }

        long endTime = System.nanoTime();

        System.out.printf("\nTotal Duration: %d.%d seconds\n",
                Duration.ofNanos(endTime - startTime).toSeconds(),
                Duration.ofNanos(endTime - startTime).toMillis() % 1000);
        System.out.printf("Average time: %d.%d of seconds over %d numbers\n",
                Duration.ofNanos((endTime - startTime) / results.size()).toSeconds(),
                Duration.ofNanos((endTime - startTime) / results.size()).toNanos() % 1_000_000,
                Numbers.NUMBERS.length);
    }
}