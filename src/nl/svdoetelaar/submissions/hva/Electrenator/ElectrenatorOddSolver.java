package nl.svdoetelaar.submissions.hva.Electrenator;

import nl.svdoetelaar.OddSolver;
import nl.svdoetelaar.config.Numbers;

/**
 * @author Electrenator
 */
public class ElectrenatorOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int number) {
        do {
            number -= 2;
        } while (number != Numbers.RANDOM_NUMBER_BOUND && number != Numbers.RANDOM_NUMBER_BOUND + 1);

        return number != Numbers.RANDOM_NUMBER_BOUND;
    }
}
