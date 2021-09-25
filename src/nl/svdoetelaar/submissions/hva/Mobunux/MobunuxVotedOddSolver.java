package nl.svdoetelaar.submissions.hva.Mobunux;


import nl.svdoetelaar.Main;
import nl.svdoetelaar.OddSolver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mobunux
 */
public class MobunuxVotedOddSolver implements OddSolver {

    @Override
    public boolean isOdd(int n) {
        try {
            Field solvers = Main.class.getDeclaredField("solvers");
            solvers.setAccessible(true);
            Object o = solvers.get(Main.class);

            List<OddSolver> oddSolvers = new ArrayList<>((List<OddSolver>) o);

            oddSolvers.removeIf(oddSolver -> oddSolver.getClass() == MobunuxVotedOddSolver.class);

            Map<OddSolver, Boolean> result = new HashMap<>();

            for (OddSolver oddSolver : oddSolvers) {
                result.put(oddSolver, oddSolver.isOdd(n));
            }

            long oddCount = result.entrySet().stream().filter(oddSolverBooleanEntry -> oddSolverBooleanEntry.getValue()).count();
            long evenCount = result.entrySet().stream().filter(oddSolverBooleanEntry -> !oddSolverBooleanEntry.getValue()).count();

            if (oddCount > evenCount) {
                return true;
            }
            if (evenCount > oddCount) {
                return false;
            }


        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
        throw new RuntimeException("Could not determine if the number was odd or even");
    }

}
