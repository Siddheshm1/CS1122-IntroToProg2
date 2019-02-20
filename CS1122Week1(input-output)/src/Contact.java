import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author SiddheshDM
 *
 * Constructor has same name as class initialized and no return type (void, int, double etc...)
 *
 */

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Contact contact1 = new Contact("Snoopy","555-1212");
        Contact contact2 = new Contact("Charlie Brown","555-1234");

        ArrayList<Contact> list = new ArrayList<>();
        list.add(contact1);
        list.add(contact2);


        File file = new File ("contacts.txt");
        PrintWriter pwt = null;

        try {


            pwt = new PrintWriter(file);


        for (Contact c; list) {
            pwt.println(c.getName());
            pwt.println(c.getPhone());
        }
        } catch (FileNotFoundException e) {

        } finally {

            pwt.close();
        }
    }

}
