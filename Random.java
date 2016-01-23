import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by niklas on 1/21/16.
 */
public class Random {


    /**
     *
     * @param length defines how many bits will be generated
     * @return returns a random bit chain with the length "length"
     */
    public static String generateRandomBitChain(int length)
    {
        String bitChain = "";

        for (int i = length;i != 0;i -- )
        {
            bitChain = bitChain + String.valueOf(Math.round(Math.random()));

        }
        return  bitChain;
    }


    public static String generateValidRandomMathString(int charCount) throws ScriptException {
       boolean done = false;
        String mathChain = "";

        while (!done) {
            mathChain = generateRandomMathString(charCount);
            if (mathChainValid(mathChain)) {
                done = true;
            }
        }

        if (done) {
            return mathChain;
            }
        else return "a";



    }

    /**
     *
     * @param mathChain
     * @return true for valid mathString / false for invalid mathString
     * @throws ScriptException
     */
    public static boolean mathChainValid(String mathChain) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");



        try {
            engine.eval(mathChain);
            return true;

        }
        catch (Exception ScriptException){
            return false;
        }
    }


    /**
     * Generates a random MathString
     *
     * @param charCount Defines how many numbers are used in the equation
     * @return
     */

    public static String generateRandomMathString(int charCount){
       String chain = "";
        String digitToAdd = "";
        boolean lastLinkNumber = false;


        for (int i = charCount;i!=0;i--)
        {
            boolean number = false;
            boolean valid = true;
            int foo = Integer.parseInt(generateRandomBitChain(4), 2);

            if (foo<10) {
                digitToAdd = String.valueOf(foo);
                number = true;

            }

                switch (foo) {
                    case 10:
                        digitToAdd = "+";
                        number = false;
                        break;
                    case 11:
                         digitToAdd = "-";
                        number = false;
                        break;
                    case 12:
                        digitToAdd = "/";
                        number = false;
                        break;
                    case 13:
                        digitToAdd = "*";
                        number = false;
                    break;
                }

            if (foo > 13){
                i ++;
                digitToAdd = "";
                valid = false;
            }

            //goes here if las chain link was a number and the type of chrarcter is a math operator
            if (lastLinkNumber & !number & valid) {
                chain = chain + digitToAdd;
                lastLinkNumber = false;
            //goes here if las chain link was a math operator and the type of chrarcter is a digit
            }
            if (!lastLinkNumber & number & valid){
                chain = chain + digitToAdd;
                lastLinkNumber = true;
            }

            else{
                if (valid) {
                    i++;
                }
                valid = true;
            }

        }
        return chain;
    }
}
