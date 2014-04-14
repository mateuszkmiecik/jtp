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


        Mutable tmp = new Mutable();

        char[] a = tmp.getChars();
        char[] a_copy = tmp.getChars().clone();
        a[1] = 'l';
        System.out.println(a_copy);

        System.out.println();

        Immutable tmp2 = new Immutable();
        char[] b = tmp2.getChars();
        char[] b_copy = tmp.getChars().clone();
        b[1] = 'l';
        System.out.println(b_copy.toString() + " == " + tmp2.getChars().toString());


    }
}
