package nl.svdoetelaar.submissions.hva.SanderPander;

import nl.svdoetelaar.OddSolver;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KoningSanderPander
 */
public class SanderOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int number) {
        int[] primes = generatePrimes(number);

        for (Integer prime : primes) {
            if (number % prime == 0) {
                number /= prime;
            }
        }

        return (double) number / 2 % 1 != 0;
    }

    public static int[] generatePrimes(int number) {
        List<Integer> primes = new LinkedList<>();
//        primes.add(2);

        if (number <= 1) return primes.stream().mapToInt(value -> value).toArray();

        // Yes, this can be slower. But at this point why bother XD
        for (int i = 3; i < number; i += 2) {
            boolean isPrime = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) primes.add(i);
        }

        return stoogeSort(primes.stream().mapToInt(value -> value).toArray(), 0, primes.size() - 1);
    }

    private static int[] stoogeSort(int[] primes, int low, int high) {
        if (low >= high)
            return primes;

        // If first element is smaller
        // than last, swap them
        if (primes[low] < primes[high]) {
            int t = primes[low];
            primes[low] = primes[high];
            primes[high] = t;
        }

        // If there are more than 2 elements in
        // the array
        if (high - low + 1 > 2) {
            int t = (high - low + 1) / 3;

            // Recursively sort first 2/3 elements
            primes = stoogeSort(primes, low, high - t);

            // Recursively sort last 2/3 elements
            primes = stoogeSort(primes, low + t, high);

            // Recursively sort first 2/3 elements
            // again to confirm
            primes = stoogeSort(primes, low, high - t);
        }
        return primes;
    }
}
