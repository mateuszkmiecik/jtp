package nwd;

/**
 * Created on 23.04.14.
 *
 * @author mk
 */
public class NWD {
    public static int count(int a, int b){
        int c;
        if(a < b){
            c = a;
            a = b;
            b = c;
        }

        while(b != 0){
            a = a%b;

            c = a;
            a = b;
            b = c;
        }

        return a;
    }
}