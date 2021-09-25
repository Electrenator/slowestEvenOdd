package nl.svdoetelaar.submissions.waffle_house.Chronoes;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

import nl.svdoetelaar.OddSolver;
import nl.svdoetelaar.config.Numbers;

public class ChronoesRandomOddSolver implements OddSolver {
    public static final int MAX_NUMBERS = Numbers.RANDOM_NUMBER_BOUND * 2;
    private Random randomGen = new Random(8008135);
    // HashSet is way too fast, LinkedList is way too slow.
    // FeelsBadMan
    private List<Integer> generatedNumbers = new ArrayList<>();

    class NoMoreNumbersException extends RuntimeException {
        NoMoreNumbersException(String message) {
            super(message);
        }
    }

    @Override
    public boolean isOdd(int i) {
        if (i < -Numbers.RANDOM_NUMBER_BOUND || i > Numbers.RANDOM_NUMBER_BOUND) {
            throw new IllegalArgumentException("Number is out of bounds");
        }
        generatedNumbers = new ArrayList<>();
        IntStream oddNumbers = IntStream.generate(this::generateOddNumber);
        try {
            return oddNumbers.anyMatch((int candidate) -> {
                return i == candidate;
            });
        } catch (NoMoreNumbersException exception) {
            return false;
        }
    }

    private int generateOddNumber() throws NoMoreNumbersException {
        while (generatedNumbers.size() <= MAX_NUMBERS) {
            int nr;
            int nrIndex;
            do {
                nr = randomGen.nextInt(MAX_NUMBERS + 1) - MAX_NUMBERS / 2;
                nrIndex = findIndex(nr);
                if (nrIndex == -1) {
                    break;
                }
            } while (generatedNumbers.get(nrIndex) == nr);
            generatedNumbers.add(nrIndex + 1, nr);
            if (nr != (nr / 2) * 2) {
                return nr;
            }
        }
        throw new NoMoreNumbersException("No more numbers exist");
    }

    /**
     * I just had to implement binary search because simple iteration over list takes ungodly amount of time
    */
    private int findIndex(int nr) {
        if (generatedNumbers.size() == 0) {
            return -1;
        }
        return binarySearch(0, generatedNumbers.size() - 1, nr);
    }

    private int binarySearch(int first, int last, int nr) {
        int midIdx = (first + last) / 2;
        if (last - first <= 1) {
            return midIdx;
        }
        int midValue = generatedNumbers.get(midIdx);
        if (nr < midValue) {
            return binarySearch(first, midIdx, nr);
        }
        return binarySearch(midIdx, last, nr);
    }
}
