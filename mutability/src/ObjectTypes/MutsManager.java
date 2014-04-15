package ObjectTypes;

import Properties.TranslationManager;

/**
 * Created on 15.04.14.
 *
 * @author mk
 */
public class MutsManager {
    Mutable tmp;
    Immutable tmp2;


    public MutsManager() {
        tmp = new Mutable();
        tmp2 = new Immutable();
    }

    public void testMutable(){
        System.out.println(TranslationManager.getSentence("shouldBeDiff"));
        System.out.print(tmp.getChars());
        System.out.print(" == ");
        char[] a = tmp.getChars();
        a[1] = 'l';
        System.out.println(tmp.getChars());
        System.out.println("Array a[]:");
        System.out.println(a);
    }

    public void testImmutable(){
        System.out.println(TranslationManager.getSentence("shouldBeSame"));
        System.out.print(tmp2.getChars());
        System.out.print(" == ");
        char[] b = tmp2.getChars();
        b[1] = 'l';
        System.out.println(tmp2.getChars());
        System.out.println("Array b[]:");
        System.out.println(b);
    }
}
