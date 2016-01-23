import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by niklas on 1/21/16.
 * its cool
 */
public class GA {

    public static void main(String[] args) throws ScriptException {

        String rdm = Random.generateRandomMathString(6);
        System.out.println("[Information] The random chain is " + rdm);

        solveStuff(rdm);
        String dna = Vars.convertToBitChain(rdm);
        System.out.println(dna);
        String newDna = Copy.copyAndMutate(dna);
        System.out.println(newDna);


    }


    public static void solveStuff(String equation)
    {

        if (equation != "") {
            try {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");

                System.out.println(engine.eval(equation));
            } catch (Exception e) {
                System.out.println("[Error] Invalid Equation");
            }
        }
        else {
            System.out.println("[Error] No Equation!");
        }
    }






}
