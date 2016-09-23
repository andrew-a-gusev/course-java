import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Никита on 21.09.2016.
 */
public class calculator {
    public static void main(String[] args)throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter in format: number sign number");
        String base = reader.readLine();
        String sign = "";
        String snumb1 = "";
        String snumb2 = "";
        boolean fl = true;
        
        /**
         * 1. It is always better to re-use existing fuctions if their interface matches your needs 
         *    (in this casle String.indexOf, String.substring or String.split)
         *    If any any moment of time performance of existing function
         * 2. Standard best practice dictates us to hide such functional blocks inside a function
         *    For example:
         *    snumb1 = getFirst(base);
         *      OR
         *    Tuple<String,String> operands = getOperands(base);
         * 
         */
        for (char c : base.toCharArray()) {
            if (Character.isDigit(c)) {
                if(fl)snumb1 += c;
                else snumb2 += c;
            }
            else {
                if( c != ' ') {
                    sign += c;
                    fl = false;
                }
            }
        }

        double numb1 = Double.parseDouble(snumb1);
        double numb2 = Double.parseDouble(snumb2);
        /**
         * Please think of how to minimize changes when extending the calculator with new functions (say x^y).
         * What are the objects ? What are the relationships between them ? How to comply to Open/Close principle ?
         */
        switch (sign){
            case "*": {
                System.out.print("=" + (numb1*numb2));
                break;
            }
            case "/": {
                if (numb2!=0) {
                    System.out.print("=" + (numb1/numb2));
                    break;
                }
                else {
                    System.out.print("="+"Infinity");
                    break;
                }
            }
            case "+": {
                System.out.print("=" + (numb1+numb2));
                break;
            }
            case "-": {
                System.out.print("=" + (numb1-numb2));
                break;
            }
        }
    }
}
