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
}
