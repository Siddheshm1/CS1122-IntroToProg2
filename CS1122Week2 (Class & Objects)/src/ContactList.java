import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<ContactEntry> list = new ArrayList<ContactEntry>();
    int entries = 0; // Actual number of entries in the list.

    void addEntry(String name, String email) {
        // Add a new item at the end of the list.
        ContactEntry entry = new ContactEntry(name, email);
        list.add(entry);
        entries++;
    }

    String getEmail(String name) {
        for (ContactEntry entry : list) {
            if (entry.getName().equals(name)) { // Found it!
                return entry.getEmail();
            }
        }
        return null; // Name wasn't found.
    }

    public static ContactList loadContacts (String filepath) {
        File file = new File (filepath);
        ContactList list = new ContactList();
        try (Scanner scan = new Scanner (file)) {
            while (scan.hasNext() ) {
                String line = scan.nextLine();
                int pos = line.indexOf( ":");
                String name = line.substring(0,pos) ;
                String email = line.substring(pos + 1);
                list.addEntry(name, email);
                return list;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return list;
    }

    public void storeContacts (String filepath) {
        File file = new File (filepath);
        try (PrintWriter pwt = new PrintWriter( file )) {
            for (ContactEntry entry : list) {
                pwt.println(entry.getName() + " : " + entry.getEmail());
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.addEntry("Larry", "larry@mtu.edu");
        contactList.addEntry("Joe", "joe@mtu.edu");
        contactList.addEntry("Moe", "moe@mtu.edu");
        contactList.addEntry("Curly Joe", "curlyjoe@mtu.edu");

        contactList.storeContacts("contacts.txt");

        String email = contactList.getEmail("Moe");

        assert email.equals("moe1234@mtu.edu");
    }

}
