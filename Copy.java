import javax.script.ScriptException;

/**
 * Created by niklas on 1/22/16.
 */
public class Copy {
    public static String copyAndMutate(String orgDNA) throws ScriptException {
        String newDna = "";
        int dnaLength = orgDNA.length();
        String currentBit;
        String Expansion;

        for (int i = orgDNA.length(); i != 0; i--) {
            currentBit = String.valueOf(orgDNA.substring(dnaLength - i, dnaLength - i + 1));
            if (Math.random() <= References.mutationChance) {
                switch (currentBit) {
                    case "1":
                        currentBit = "0";
                        break;
                    case "2":
                        currentBit = "1";
                        break;
                }

            }
            newDna = newDna + currentBit;
        }

        if (Math.random() <= References.lengthMutationChance) {
            if (Math.random() < 0.5 & dnaLength > 12) {
                newDna = newDna.substring(0, dnaLength - 8);
            }
            else {
                Expansion = Random.generateValidRandomMathString(2).substring(1, 3);
                newDna = newDna + Vars.convertToBitChain(Expansion);

            }

        }
        return newDna;
    }
}
