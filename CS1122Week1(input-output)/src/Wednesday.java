/**
 * @author SiddheshDM
 *
 * Input/Output handling
 *
 * Separation of concerns is a design principle - closely related to the Singgle Responsibility Principle of
 * object oriented programming
 *
 * Separate a computer program into distinct clsses such that each calss addresses a single concept.
 *
 * The File class is a description of an external file.
 * File does not read or write to the disk.
 * File only contains information about the file.
 *
 * Always use forward slashes to specify file paths --> (on windows: "C:\home\file.txt") - cannot do this in Java
 * as back slash signifies that the next character is a special character. Such as: \n - new line or \t - new tab
 *
 * To run on any system, create file paths with forward slashes --> ("/home/file.txt")
 *
 * The file class only works with things that are on the computer.
 *
 * Reading from a file:
 * import Scanner
 * Create a new Scanner with a File instance
 *
 * Scanner commands to test if there is data waiting: hasNext(), hasNextLine(), hasNextDouble()
 * Scanner commadns to read in data: nextInt(), nextDouble() etc...
 *
 * File myFile = new File ( "C:/Home/somefile.txt" );
 * Scanner input = new Scanner ((CONTINUE FROM PICTURE))
 *
 * Remember to close Scanner --> input.close ();
 *
 * The next method reas a string that is delimited by a space
 *
 * Scanner in  new Scanner (myFile);
 * while (in.hasNext) {
 *     String myString  = in.nextInt;
 *     }
 *     Sout (myFile);
 *
 * in.useDelimiter --> empty string
 *
 * Testing characters --> Character.isDigit (myChar)
 *
 * Read an entire line of text - in.hasNextLine ();
 *
 * Use nextInt or nextDouble to read numbers - always check if waiting input is a number first otherwise you
 * will have a mismatch number.
 *
 * Scanner is flexible:
 * new Scanner (System.in) - reads from keyboard
 * new Scanner (File) - reads from file
 * new Scanner (String) - parses string data
 * new Scanner (URL) - reads from a webpage
 *
 * Writing to a file:
 * A printwriter instance contains the same print, println, printf methods we use for writing to the console.
 * inport java.io.PrintWriter;
 * Always close Scanner and PrintWriter instances when done using them.
 *
 *
 *
 */

public class Wednesday {
}
