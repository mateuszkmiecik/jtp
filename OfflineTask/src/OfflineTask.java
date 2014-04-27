import single.Ton;
import nwd.NWD;

/**
 * Created on 23.04.14.
 *
 * @author mk
 */
public class OfflineTask {

    public static void main(String[] argv){

        // singleton
        System.out.println("Singleton");
        Ton p = Ton.getInstance();
        System.out.println(p.getNumber());
        Ton s = Ton.getInstance();
        s.setNumber(3);
        System.out.println(p.getNumber());


        // nwd

        System.out.println("NWD");
        System.out.println(NWD.count(13, 3));

        for(int i = 10; i < 30; i++){
            for(int j = i + 1; j < 31; j++){
                System.out.println("NWD(" + i + ", " + j + "): " + NWD.count(i, j));
            }
        }
        int liczba = 0;
        for(int i = 1; i < 99; i++){
            for(int j = i+1; j < 100; j++){
                if(NWD.count(i,j) == 7) liczba++;
            }
        }
        System.out.println(liczba);
    }
}

// polimorfizm - występowanie danego obiektu, metody w wielu formach
//                  mechanizm dziedziczenia

// kawa - "logo" javy

// interfejs - definiuje metody kt
