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
