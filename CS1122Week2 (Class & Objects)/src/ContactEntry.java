/**
 *
 * Strings set to empty
 * Primitive data types set to 0
 * Booleans set to false
 */

public class ContactEntry {
    private String name;
    private String email;

    public ContactEntry(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ':' + email;
    }
}
