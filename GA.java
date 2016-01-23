import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niklas on 1/21/16.
 * its cool!
 */
public class GA {

    public static void main(String[] args) throws ScriptException {
        List<Genome> ParentalGeneration = createParentalGeneration();
        System.out.print("");

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

            genomeList.add(newGenome);
        }


        return genomeList;



    }








}
