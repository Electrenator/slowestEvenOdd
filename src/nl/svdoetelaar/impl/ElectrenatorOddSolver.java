package nl.svdoetelaar.impl;

import nl.svdoetelaar.OddSolver;

/**
 * @author Electrenator
 */
public class ElectrenatorOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int Number) {
        double doubleNumber = Math.abs((double) Number);
        do {
            doubleNumber -= 2;
        } while (doubleNumber != Integer.MIN_VALUE && doubleNumber != Integer.MIN_VALUE + 1);

        return doubleNumber != Integer.MIN_VALUE;
    }
}
