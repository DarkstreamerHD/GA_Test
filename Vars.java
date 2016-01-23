/**
 * Created by niklas on 1/21/16.
 */
public class Vars {


    public Vars()
    {

    }





    public static String convertToBitChain(String mathChain){
        String bitChain = "";
        String bitsToAdd = "";
        int mathChainOriginalLength = mathChain.length();

        for (int i = mathChain.length();i != 0;i--)
        {

                bitsToAdd = String.valueOf(digitToBits(mathChain.substring(mathChainOriginalLength - i, mathChainOriginalLength - i + 1)));
                bitChain = bitChain + bitsToAdd;
                bitsToAdd = "";


        }
        return bitChain;

    }

    public static String digitToBits(String digitToConvert){
        String bitChain="";



            switch (digitToConvert) {


                case "0":
                    bitChain = "0000";
                    break;
                case "1":
                    bitChain = "0001";
                    break;
                case "2":
                    bitChain = "0010";
                    break;
                case "3":
                    bitChain = "0011";
                    break;
                case "4":
                    bitChain = "0100";
                    break;
                case "5":
                    bitChain = "0101";
                    break;
                case "6":
                    bitChain = "0110";
                    break;
                case "7":
                    bitChain = "0111";
                    break;
                case "8":
                    bitChain = "1000";
                    break;
                case "9":
                    bitChain = "1001";
                    break;
                case "+":
                    bitChain = "1010";
                    break;
                case "-":
                    bitChain = "1011";
                    break;
                case "/":
                    bitChain = "1100";
                    break;
                case "*":
                    bitChain = "1101";
                    break;

        }


        return bitChain;

    }

    public static boolean isNumber(String bits){
        String mathToReturn = "";
        int foo;
        foo = Integer.parseInt(bits,2);


        if (foo<10) {
            return true;
        }

        else
        {
            return false;
        }


    }

    public static String bitsToMath(String bits)
    {
        String mathToReturn = "";
        int foo;
        foo = Integer.parseInt(bits,2);

        if (foo<10) {
            mathToReturn = String.valueOf(foo);
        }

        switch (foo) {
            case 10:
                mathToReturn = "+";
                break;
            case 11:
                mathToReturn = "-";
                break;
            case 12:
                mathToReturn = "/";
                break;
            case 13:
                mathToReturn = "*";
                break;
        }
        if (foo >13)
        {
            //makes the final equation invalid if a mutation decides so!
            mathToReturn = "x";
        }

        return mathToReturn;

    }

    public static String bitChainToMathChain(String bitChain)
    {
        String mathChain = "";
        String charToAdd = "";
        String currentBits;
        int bitChainLength = bitChain.length();

        for (int i = bitChainLength/4; i != 0; i--)
        {
            currentBits= String.valueOf(bitChain.substring(bitChainLength - (i*4), bitChainLength - (i*4) + 4));
           if (i%2 == 0 & !isNumber(currentBits))
           {
               charToAdd = bitsToMath(currentBits);
               mathChain = mathChain + charToAdd;
           }

            if (i%2 != 0 & isNumber(currentBits))
            {
                charToAdd = bitsToMath(currentBits);
                mathChain = mathChain + charToAdd;
            }

            if (i%2 == 0 & isNumber(currentBits))
            {
                charToAdd = "z";
                mathChain = mathChain + charToAdd;
            }
            if (i%2 != 0 & !isNumber(currentBits))
            {
                charToAdd = "z";
                mathChain = mathChain + charToAdd;
            }

        }

        return mathChain;
    }

}
