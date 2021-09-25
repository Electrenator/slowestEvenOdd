package nl.svdoetelaar;

import nl.svdoetelaar.submissions.hva.Electrenator.ElectrenatorOddSolver;
import nl.svdoetelaar.submissions.hva.Mobunux.MobunuxEvenFasterAsFuckOddSolver;
import nl.svdoetelaar.submissions.hva.Mobunux.MobunuxOddSolver;
import nl.svdoetelaar.submissions.hva.SanderPander.FastAsFuckOddSolver;
import nl.svdoetelaar.submissions.hva.SanderPander.SanderOddSolver;
import nl.svdoetelaar.submissions.waffle_house.Chronoes.ChronoesRandomOddSolver;

import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nl.svdoetelaar.config.Numbers.NUMBERS;
import static nl.svdoetelaar.config.Numbers.TEST_LIST_ITEMS;

public class Main {

    private static final List<OddSolver> solvers = List.of(
            new FastAsFuckOddSolver(),
            new MobunuxEvenFasterAsFuckOddSolver(),
            new MobunuxOddSolver(),
            new SanderOddSolver(),
            new ElectrenatorOddSolver(),
            new ChronoesRandomOddSolver()
            //TODO: ADD NEW SOLVERS HERE
    );


    public static void main(String[] args) {
        Map<OddSolver, Long> results = new HashMap<>();

        for (OddSolver solver : solvers) {
            System.out.println("\rTesting solver: " + solver.getClass().getSimpleName());

            long totalTime = 0;

            for (int j = 0; j < TEST_LIST_ITEMS; j++) {
                Integer i = NUMBERS.get(j);
                long startTime = System.nanoTime();
                solver.isOdd(i);
                totalTime += System.nanoTime() - startTime;
                System.out.printf("\rprogress: %.4s%%", ((double) j / TEST_LIST_ITEMS) * 100);
            }

            results.put(solver, totalTime);
        }

        System.out.print("\r");
        results.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(timing -> {
                    System.out.println("====================");
                    System.out.println("Solver: " + timing.getKey().getClass().getSimpleName());
                    System.out.println("Time taken: " + Duration.ofNanos(timing.getValue()).toNanos() + " nanoseconds");
                    System.out.println("Time per number: " + Duration.ofNanos(timing.getValue() / TEST_LIST_ITEMS).toNanos() + " nanoseconds");
                    System.out.println("====================");
                });


    }
}