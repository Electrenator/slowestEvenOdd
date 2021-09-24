package nl.svdoetelaar.impl;


import nl.svdoetelaar.OddSolver;

/**
 * @author Mobunux
 */
public class MobunuxEvenFasterAsFuckOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int n) {
        return (n & 0x1) == 1;
    }

}
