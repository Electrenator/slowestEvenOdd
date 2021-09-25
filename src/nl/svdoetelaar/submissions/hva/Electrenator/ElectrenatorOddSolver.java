package nl.svdoetelaar.submissions.hva.Electrenator;

import nl.svdoetelaar.OddSolver;
import nl.svdoetelaar.config.Numbers;

/**
 * @author Electrenator
 */
public class ElectrenatorOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int number) {
        double n = Math.abs(number);
        do {
            n -= 2;
        } while (n != Numbers.RANDOM_NUMBER_BOUND && n != Numbers.RANDOM_NUMBER_BOUND + 1);

        return n != Numbers.RANDOM_NUMBER_BOUND;
    }
}
