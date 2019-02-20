/**
 * @author SiddheshDM
 *
 * Inheritance
 *
 * "abstract" keyword
 * Java has the keyword abstract that can be applied to both classes and methods
 * When abstract modies a class, it makes so tha class cannot be directly instantiated into an object
 *
 * - Must be first extended by a subclass that is not abstract, that then you can instantiate the subclass
 * - Those subclasses can still be referenced by references of the abstract class type
 * - Abstract class can possess everything a regular class has, including fields and methods
 * - THey may also contain abstract methods
 * - In java, if a clss contains any abstract methods, it must be abstract
 *
 * When developing graphical interfaces, the library developers know that the program will want to do something
 * when the mouse is clicked, but they do not know what. So you can create an abstract class that will have the
 * actions when the mouse is moved/clicked.
 *
 * An abstract method is a method which is defined (name + parameter are stated) but is not implemented.
 * WHen a class has an abstract method, it must be abstract
 *
 *
 * Abstract Class
 *
 * public abstract class Person {
 *     private String name = "" ;
 *
 *     public abtract String getName ().....
 *
 *
 * }
 *
 * Interfaces
 * - Interfaces are similar to Abstract classes, but cannot contain code.
 * We can implement more than 1 interface, but can only extend 1 class.
 *
 * - Interfaces are related to classes
 * - Interfaces define a new data type, but do not procide a machanism for code reuse.
 * - Methods defined in interfaces myst be implemented in the implementing class.
 * - Interfaces provide mechanisms for multiple-inheritacne of type information.
 * - A class can implement multiple interfaces.
 *
 * Polymorphism (Java)
 * - Reference types can be any superclass (or interface) of the actual object type.
 */

public class Friday {
}
