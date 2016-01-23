/**
 * Created by niklas on 1/23/16.
 */
public class Genome {

    String DNA;
    double fitness;
    boolean valid;

    public void calculateFitness()
    {
        double result = Vars.solveStuff(Vars.bitChainToMathChain(DNA));

        fitness = (Math.abs(result - References.aim));
        if (Double.isInfinite(fitness) | Double.isNaN(fitness))
        {
            valid = false;
        }
        else
        {
            valid = true;
        }
    }
}