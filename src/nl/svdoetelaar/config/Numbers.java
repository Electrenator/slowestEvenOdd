package nl.svdoetelaar.config;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Numbers {

   public static final int TEST_LIST_ITEMS = 1000;
   public static final Random random = new Random(69); //always use the same seed to produce the same numbers

   public static final int RANDOM_NUMBER_BOUND = 100_000; //use 100K as bound to reduce the impact of solvers that are only slow with high numbers
   public static final List<Integer> NUMBERS = random.ints(TEST_LIST_ITEMS, 0, RANDOM_NUMBER_BOUND)
            .boxed()
            .collect(Collectors.toList());

}
