/**
 * Created on 31.03.14.
 *
 * @author mk
 */
public class Contact {
    private String number;
    private String mail;
    private Integer occurrence;


    public Contact(String number, String mail) {
        this.number = number;
        this.mail = mail;
        this.occurrence = 1;
    }

    public void increaseOccurence(){
        this.occurrence++;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
