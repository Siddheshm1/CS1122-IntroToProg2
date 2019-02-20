/**
 * @author: Siddhesh Mahadeshwar
 * Last Modified: 27th January 2019
 * CS 1122 Spring 2019
 *
 * Description: This is a program which deals which contact lists, most specifically Contact names and their
 * corresponding email addresses. The program holds the ability to view email addresses when prompted, add entries to
 * the contact list, delete entries from the contact list, change a contact's email, or quit the program if nothing
 * is desired.
 */


public class ContactEntry {
    private String name;
    private String email;

    /**
     * @param name: Assigns the string name to the String name within the constructor.
     * @param email: Assigns the string email to the String email within the constructor.
     */
    public ContactEntry(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @return: Getter method for the private String name that returns the name string.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name: Setter method for the private String name that returns the name string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return: Getter method for the private string email that returns the string email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email: Setter method for the private string email that returns the string email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}



