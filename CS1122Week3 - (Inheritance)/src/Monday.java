/**
 * @author SiddheshDM
 * 28th Jan 2019
 *
 * Inheritance
 * Automatic reuse of data and functionality of a parent class
 * Ability to form class hierarchies
 *
 * Animal --> Mammal, reptile --> (Giraffe, tiger) , (snake, turtle)
 *
 * Polymorphism
 * - from one, many
 * The ability to differentiate behavior between subtypes and parents in a class hierarchy
 *
 * Overriding: replace functionality of parent
 * Overloading: enhancing or adding additional functionality in child
 *
 * As you move down the inheritance hierarchy, the elements become more specific
 *
 * Abstraction looks for commonalities, the differences are what make a giraffe a giraffe.
 * The similarities are what make a "super-class".
 * You can go downwards in inheritance or upwards in abstraction: designing decisions made
 *
 * The "is-a" relationship
 *
 * In object-oriented programming, inheritance is a relationship between: a superclass: more generalized, and
 * a subclass: a more specialized class.
 *
 * The subclass inherits information (data) from the superclass.
 *
 * Java is a single - inheritance programming language. C++ allows multiple inheritance
 *
 * Designing for inheritance
 * - use a class for variation in values, inheritance for variation in Behavior
 *
 * If two vehicles vehicles only vary by fuel efficiency, use variation, not inheritance.
 *
 * "extends" denotes inheritance
 *
 * Use getters and setters to access private members of a superclass
 * A subclass cannot directly access private instance variables of a superclass.
 *
 *
 * public class Question {
 *     private String text;
 *     private String asnwer;
 * }
 *
 * public class ChoiceQuestion extends Question {
 *     ...
 *     text = QuestionText; // Complier error
 * }
 *
 * Overriding methods: overriding method occurs when you need to chance the behavior specified in a superclass.
 * Define a method with the same name and parameters and the program will use the normal method instead of the
 * superclass method.
 *
 * "super." keyword used to directly call a method in the superclass.
 *
 * Overloading is when two methods share the same name but have different parameters
 * If you intend to override but change parameters, you will be overloading the inherited method, not overriding it. 
 */

public class Monday {
}
