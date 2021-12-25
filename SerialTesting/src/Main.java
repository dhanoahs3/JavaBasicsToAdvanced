import com.harsimran.myexamples.Serial;

public class Main {


    public static void main(String[]args){

        Serial s  =  new Serial();

        for(int i=0;i<=10;i++){
            System.out.println(Serial.nSum(i));
        }

        System.out.println("********************************************************************");

        for(int i=0;i<=10;i++){
            System.out.println(Serial.factorial(i));
        }

        System.out.println("**********************************************************************");


        for(int i=0;i<=10;i++){
            System.out.println(Serial.fibonacci(i));
        }

    }
}
