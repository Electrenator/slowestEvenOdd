package nl.svdoetelaar.impl;

import nl.svdoetelaar.OddSolver;

/**
 * @author KoningSanderPander
 */
public class FastAsFuckOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

}

