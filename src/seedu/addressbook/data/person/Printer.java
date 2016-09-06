package seedu.addressbook.data.person;
 
import java.util.StringJoiner;
 
public class Printer {  
    public static String getPrintableString(Printable...printables) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Printable p : printables) {
            joiner.add(p.getPrintableString());
        }
        return joiner.toString();
    } 
}