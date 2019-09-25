/**
 * This program is based on a learning algorithm and the tree data structure to guess what the user is thinking of
 * and add nodes to the tree when the guess is incorrect so the next time the program is launched, it will have
 * a smarter set of questions and the guesses will be closer to correct.
 *
 * Date last modified: April 25, 2019
 * @author Siddhesh Mahadeshwar / Wyatt Thompson
 *
 * CS1122, Spring 2019
 */

public class Answer extends LinkedBinaryTreeNode {
    /**
     * Constructor
     * @param question: takes in the answer (variable is called question for technical reasons)
     */
    public Answer(Object question) {
        super(question);
    }

    /**
     * toString method for this class
     * @return: returns a string with the alterations made
     */
    @Override
    public String toString() {
        return (String)this.getData();
    }
}
