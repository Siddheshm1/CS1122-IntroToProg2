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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class ContactList {

    private ArrayList<ContactEntry> list = new ArrayList<>();

    public static void main(String[] args) {
        ContactList testContacts = new ContactList();
        for (int i = 0; i < testContacts.getSize(); i++) {
            System.out.println(testContacts.getEntry(i).getName() + ": " + testContacts.getEntry(i).getEmail());
        }
        testContacts.userInterface();
    }

    /**
     * @param name: Takes the name as an input which will later be added to a contact list.
     * @param email: Takes the corresponding email for the previously entered name.
     */
    public void addEntry(String name, String email) {
        ContactEntry entry = new ContactEntry(name, email);
        list.add(entry);
    }

    /**
     * No parameters - the method is used to obtain the size of elements.
     * @return: returns the size of the ArrayList list.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * @param index: Takes the index number of the entry within the ArrayList.
     * @return: Returns the contact entry.
     */
    public ContactEntry getEntry(int index) {
        return list.get(index);
    }

    /**
     * @param name: Takes the name input from the user with the purpose of searching it through the contacts file.
     * @return: Returns the string email associated with the entered name.
     */

    public String getEmail(String name) {
        for (int index = 0; index < list.size(); index++) {
            if (name.equals(list.get(index).getName())) {
                return list.get(index).getEmail();
            }
        }
        return null;
    }

    /**
     * @param filepath: Takes input of the name of the filepath.
     * @return: Returns the ArrayList.
     */
    private ArrayList<ContactEntry> fillList(String filepath) {

        File file = new File(filepath);
        ArrayList<ContactEntry> tempList = new ArrayList<>();
        Scanner input;

        try {

            input = new Scanner(file);

            while (input.hasNext()) {
                String[] temp = input.nextLine().split(":");
                tempList.add(new ContactEntry(temp[0], temp[1]));
            }

            //use split string method to possibly fix 2-worded-names problem.

        } catch (FileNotFoundException e) {

        }

        return tempList;
    }

    /**
     * @param filepath: Takes input of the filepath from the user.
     * @return: Returns the ContactList.
     */
    public ContactList loadContacts(String filepath) {

        File file = new File(filepath);
        ContactList loadedContacts = new ContactList();
        Scanner input;

        try {

            input = new Scanner(file);

            while (input.hasNext()) {
                String[] temp = input.nextLine().split(":");
                loadedContacts.addEntry(temp[0], temp[1]);
            }

        } catch (FileNotFoundException e) {

        }

        return loadedContacts;
    }

    /**
     * @param filepath: Takes input of the filepath. This method is resposible for storing the contacts into
     *                a file with the print writer within.
     */
    public void storeContacts(String filepath) {

        File file = new File(filepath);
        PrintWriter pwt = null;

        try {

            pwt = new PrintWriter(file);

            for (int i = 0; i < list.size(); i++) {
                pwt.println(list.get(i).getName() + ":" + list.get(i).getEmail());
            }

        } catch (FileNotFoundException e) {

        } finally {
            pwt.close();
        }
    }

    /**
     * This method is resposible for adding entries for the second option in the UserInterface method.
     */
    private void addingEntries() {
        System.out.println("Enter the name of your contact (first letter capitalized), press enter, then type the email address");

        Scanner name = new Scanner(System.in);
        String Name = name.nextLine();


        Scanner email = new Scanner(System.in);
        String Email = email.nextLine();

        addEntry(Name, Email);
        storeContacts("contacts.txt");
    }

    /**
     * @param a: Acts as the parameter for the name.
     * @param b: Acts as the parameter for the email
     * @return: Returns the method itself with Strings a and b within.
     */
    private String addingEntries2(String a, String b) {
        return addingEntries2(a, b);
    }

    /**
     * This important method is responsible for handling the entire User Interface for this program. It has no
     * returns or parameters. Within this method are the implementations for each of the possible options that
     * can be selected by the user.
     */
    private void userInterface() {
        this.list = fillList("contacts.txt");


        System.out.print("\n" + "What would you like to do? Type your option number" + "\n" + "1. Look up an email address" + "\n" +
                "2. Add an entry to the contacts list" + "\n" + "3. Delete an entry from the list" +
                "\n" + "4. Change someone's email" + "\n" + "5. Quit the program" + " \n\n");

        Scanner scan1 = new Scanner(System.in);
        int menuEntry = scan1.nextInt();

        if (menuEntry == 1) { // implementation for the 1st option
            System.out.println("Enter the name of the contact you are looking for (first letter capitalized)");
            Scanner one = new Scanner(System.in);
            String name = one.nextLine();
            System.out.println(getEmail(name));

            userInterface();  // problem looking for lower case names if initially entered in uppercase

        }
        if (menuEntry == 2) { // implementation for the 2nd option

            Boolean cont = true;

            while (cont) {
                addingEntries();
                System.out.println("Continue? (Yes/No)");
                Scanner input = new Scanner(System.in);
                if (input.next().toLowerCase().equals("yes")) {
                    cont = true;
                } else {
                    cont = false;
                }
            }
            userInterface();

        }
        if (menuEntry == 3) { // implementation for the 3rd option
            System.out.println("Enter the name of the contact you would like to delete");
            Scanner three = new Scanner(System.in);
            String name = three.nextLine();

            for (int index = 0; index < list.size(); index++) {
                if (name.equalsIgnoreCase(list.get(index).getName())) { // Found it!
                    list.remove(index);
                    storeContacts("contacts.txt");
                    break;
                }
            }
            userInterface();

        }
        if (menuEntry == 4) { // implementation for the 4th option
            System.out.println("Enter the name of the contact (first letter capitalized) whose email you'd like to change");
            Scanner four = new Scanner(System.in);
            String Four = four.nextLine();

            for (int index = 0; index < list.size(); index++) {
                if (Four.equalsIgnoreCase(list.get(index).getName())) { // Found it!
                    Scanner email = new Scanner(System.in);
                    String Email = email.nextLine();
                    addEntry(Four, Email);
                    list.remove(index);
                    storeContacts("contacts.txt");
                    break;
                }
            }
            userInterface();
        } else {
            return; // this is the implementation if the 5th option is called.
        }
    }
}