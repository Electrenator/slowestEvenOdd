package nl.svdoetelaar.impl;

import nl.svdoetelaar.OddSolver;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KoningSanderPander
 */
public class SanderOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int number) {
        List<Integer> primes = generatePrimes(number);

        for (Integer prime : primes) {
            if (number % prime == 0) {
                number /= prime;
            }
        }

        return number == 2;
    }

    public static List<Integer> generatePrimes(int number) {
        List<Integer> primes = new LinkedList<>();
        primes.add(2);

        if (number <= 1) return primes;

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

        return primes;
    }

}
