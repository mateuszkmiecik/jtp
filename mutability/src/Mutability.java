import sun.beans.editors.IntegerEditor;

/**
 * Created on 14.04.14.
 *
 * @author mk
 */
public class Mutability {

    public static void main(String[] argv){
        String s = "ABC";
        Boolean equal = s.equals(s.toLowerCase());

        System.out.println("String s = \"ABC\";");
        System.out.println("check: s.equals(s.toLowerCase())");
        System.out.println("This should be [false]: " + equal);



        System.out.println();


        Mutable tmp = new Mutable();
        System.out.println("This should be different after changes:");
        System.out.print(tmp.getChars());
        System.out.print(" == ");
        char[] a = tmp.getChars();
        a[1] = 'l';
        System.out.println(tmp.getChars());
        System.out.println("Array a[]:");
        System.out.println(a);


        System.out.println();


        Immutable tmp2 = new Immutable();
        System.out.println("This should stay the same after changes:");
        System.out.print(tmp2.getChars());
        System.out.print(" == ");
        char[] b = tmp2.getChars();
        b[1] = 'l';
        System.out.println(tmp2.getChars());
        System.out.println("Array b[]:");
        System.out.println(b);


    }
}
