/**
 * @author SiddheshDM
 * Created: 23rd Jan 2019
 *
 *
 * Classes:
 * Classes encapsulate information and behavior
 * Information is stored in variables
 * Behavior is captured in methods
 * --> No other code is allowed in class
 *
 * Can have contents within methods but cannot have free code floating within a class.
 *    for(int i = 1; i < 99; i++);
 *    {System.out.print(x)}; --> will not execute as there is a semicolon at the end of "for loop" and S.out is
 *    not in any methods
 *
 * Classes names in camelcase
 *
 * Instance variables are declared as private within classes
 * Getters are methods used to retrieve the value of instance variables
 * Setters are methods used to chnge the value of instance variables
 *
 * Most setter methods are often called mutators because they make changes to the data
 *    public void setX (double x) {
 *        this.x = x;
 *    }
 *
 * "this" keyword used to refer to the class variable outside that method - to avoid confusion with the parameter
 * variable in the method
 *
 *
 * Constructors are used to initialize data when the class is instantiated using the keyword "new"
 * Constructors have no return type.
 * Instance variables are "private" so you have complete control over them in constructors
 * Instance of a class can be created with the "new" command
 * ONCE A CONSTRUCTOR IS CREATED, THE DEFAULT CONTRUCTOR DISAPPEARS.
 * Can have as many constructors desired as long as parameter list is different.
 *
 * Main method:
 * Command line arguments are passed to the main method in a String array
 * MAIN IS THE ONLY METHOD YOU SHOULD USE STATIC
 *
 */

public class Wednesday {
}
