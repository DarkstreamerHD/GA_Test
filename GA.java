import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by niklas on 1/21/16.
 * its cool!
 */
public class GA {

    public static void main(String[] args) throws ScriptException {
        List<Genome> ParentalGeneration = createParentalGeneration();
        Genome fittest = sortListByFitness(ParentalGeneration);
        System.out.println("Die beste Gleichung war: " + Vars.bitChainToMathChain(fittest.DNA) +" = " + Vars.solveStuff(Vars.bitChainToMathChain(fittest.DNA)));
        System.out.println("Ihre Fitness betrug: " + fittest.fitness);

        Genome fittestFilial;

        for (int i = 0; i < References.maxAmountOfGenerations;i++){
            List<Genome> FilialGeneraton = createFilialGeneration(fittest);
            fittest = sortListByFitness(FilialGeneraton);
            System.out.println("Die beste Gleichung war: " + Vars.bitChainToMathChain(fittest.DNA) +" = " + Vars.solveStuff(Vars.bitChainToMathChain(fittest.DNA)));
            System.out.println("Ihre Fitness betrug: " + fittest.fitness);
            System.out.println("Generation" + i);
            FilialGeneraton.clear();

        }
    }

    public static List<Genome> createParentalGeneration()
    {
        List<Genome> genomeList = new ArrayList();

        for (int i = References.generationSize;i != 0; i--) {
            String rdm = Random.generateRandomMathString(6);

            String dna = Vars.convertToBitChain(rdm);

            Genome newGenome = new Genome();
            newGenome.DNA = dna;
            newGenome.calculateFitness();
            if (newGenome.valid) {
                genomeList.add(newGenome);
            }
        }
        return genomeList;
    }

    public static Genome sortListByFitness(List<Genome> inputList)
    {
        Genome fittest = inputList.get(0);
        for (int i = 1;i < inputList.size(); i++)
        {
            if (fittest.fitness > inputList.get(i).fitness )
            {
                fittest = inputList.get(i);
            }
        }

        return fittest;

    }

    public static List<Genome> createFilialGeneration(Genome fittestOfLastGeneration)
    {
        List<Genome> genomeList = new ArrayList<>();

        for (int i = 0; i < References.generationSize; i++)
        {
            String mutatedDNA = "";
            try {
                mutatedDNA = Copy.copyAndMutate(fittestOfLastGeneration.DNA);
            } catch (ScriptException e) {
                e.printStackTrace();
                System.out.println("Mutation Error!");
            }

            Genome newGenome = new Genome();
            newGenome.DNA = mutatedDNA;
            newGenome.calculateFitness();

            if (newGenome.valid) {
                genomeList.add(newGenome);
            }
        }

        return genomeList;
    }










}
