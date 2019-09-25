import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Program4 {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        Program4 running = new Program4();
        //Initial message on start of the program
        System.out.println("Welcome to 20 Questions! Can we guess what you're thinking of?");
        System.out.println("Answer with 'y' or 'n' for yes or no ONLY" + "\n");
        // common root for every run of the program
        // declared outside the rest of the of the tree as it's required for eery run of the program
        LinkedBinaryTreeNode root = new LinkedBinaryTreeNode("Shall we play a game?");

        // current keeps
        LinkedBinaryTreeNode current = root;
        Scanner scanner = new Scanner(System.in);
        String isPlaying = "";

        // used to hold node values when they are loaded from the file, before they're put in nods
        ArrayList<String> lines = new ArrayList<>();
        File file1 = new File("tree.data");
        Scanner input = null;

        String temp = "";
        String temp1 = "";
        String temp2 = "";

        try {
            input = new Scanner(file1);

            while (input.hasNext()) {
                temp = input.nextLine();
                lines.add(temp);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int linesSize = lines.size();
        for (int i = 0; i < linesSize; i++) {

            temp = lines.get(i);
            temp1 = Character.toString(temp.charAt(0));
            temp2 = Character.toString(temp.charAt(1));
            temp = temp1 + temp2;

            if (i == 0) {
                root.setRight(new Question(lines.get(0)));
                current = (LinkedBinaryTreeNode) root.getRight();
                continue;
            }

            // this area is used to identify if the loaded node from file is a Question
            if (temp.equalsIgnoreCase("Q:")) {
                if (current.getLeft() == null) {
                    current.setLeft(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getLeft()).setParent(current);
                    current = (LinkedBinaryTreeNode) current.getLeft();
                    continue;
                } else if (current.getRight() == null) {
                    current.setRight(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getRight()).setParent(current);
                    current = (LinkedBinaryTreeNode) current.getRight();
                    continue;
                } else {
                    while (current.getParent() != null && current.getRight() != null) {
                        current = (LinkedBinaryTreeNode) current.getParent();
                    }
                    current.setRight(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getRight()).setParent(current);
                    current = (LinkedBinaryTreeNode) current.getRight();
                    continue;

                }
                // this area is used to identify if the loaded node from file is an answer as if it is not a question,
                // it will ultimately be an answer.
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getLeft()).setParent(current);
                    continue;
                } else if (current.getRight() == null) {
                    current.setRight(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getRight()).setParent(current);
                    continue;
                } else {
                    while (current.getParent() != null && current.getRight() != null) {
                        current = (LinkedBinaryTreeNode) current.getParent();
                    }
                    current.setRight(new Question(lines.get(i)));
                    ((LinkedBinaryTreeNode) current.getLeft()).setParent(current);
                    continue;

                }
            }

        }

        System.out.println(root.getData());

        isPlaying = scanner.nextLine();


        if (isPlaying.equalsIgnoreCase("n")) { // if the user does not want to play a game, this if statement is executed
            System.out.println("Okay, GoodBye");
            scanner.close();
            System.exit(1);
        }

        // while loop is used to repeat the games functions
        //current- keeps track of the node we are on
        //going- tells the game to keep running until it reaches an Answer
        current = (LinkedBinaryTreeNode) root.getRight();
        boolean going = true;
        while (going) {
            System.out.println(current.getData());
            temp = (String) current.getData();
            temp1 = Character.toString(temp.charAt(0));
            temp2 = Character.toString(temp.charAt(1));
            temp = temp1 + temp2;
            // tests if current node holds a question or answer
            if (temp.equals("Q:")) {
                //runs if current is a question
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    current = (LinkedBinaryTreeNode) current.getRight();
                } else {
                    current = (LinkedBinaryTreeNode) current.getLeft();
                }
            } else {
                // runs if current is an answer
                //tests if the program guessed correctly
                if (scanner.nextLine().equalsIgnoreCase("y")) { // if computer guesses correctly, display this message
                    System.out.println("Computer wins!");
                } else {// if computer guesses wrong, call wrong answer.
                    lines = running.wrongAnswer(current, scanner, lines);
                }
                going = false;
            }
        }

        /**
         * PrintWriter section of the code that is responsible for printing tree data into tree.data file.
         */

        PrintWriter pwt = null;
        try {

            pwt = new PrintWriter("tree.data");
            for (int i = 0; i < lines.size(); i++) {
                pwt.println(lines.get(i));
//
            }
            pwt.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Deals with when "n" is entered as an answer. Updates the ArrayList and also adds new nodes to the tree.
     * @param original - the node we are starting from (root of the subtree we are making)
     * @param userInput - a scanner that takes input from the user
     * @param temp - the temporary ArrayList that we are updating
     * @return - returns the updated ArrayList that can then be used to deal with the new order of nodes in the tree.
     */
    public ArrayList<String> wrongAnswer(LinkedBinaryTreeNode original, Scanner userInput, ArrayList<String> temp) {

        // hold values necessary for new nodes
        String animal;
        String difference;
        String yn;
        LinkedBinaryTreeNode current = original;

        //find new answer, question and whether original node is the right or left child of the ew question
        System.out.println("What were you thinking of?");
        animal = userInput.nextLine();
        System.out.println("What question separates " + animal + " from our guess?");
        difference = userInput.nextLine();
        System.out.println("Is this correct for " + animal + "?");
        yn = userInput.nextLine();

        boolean left = false;
        //finds which side of its parent the original answer was
        if (original.getParent().getLeft() == original) {
            left = true;
        }

        //creates new question, answer, and sets new placement of original answer.
        if (yn.equalsIgnoreCase("n")) {
            if (left) {
                current.getParent().setLeft(new Question(difference));
            } else {
                current.getParent().setRight(new Question(difference));
            }

            current.setParent(original.getParent().getLeft());

            original.getParent().setLeft(new Answer("Were you thinking of " + animal + "?"));
        }

        if (yn.equalsIgnoreCase("y")) {
            if (left) {
                original.getParent().setLeft(new Question(difference));
            } else {
                original.getParent().setRight(new Question(difference));
            }

            original.setParent(original.getParent().getRight());

            original.getParent().setRight(new Answer("Were you thinking of " + animal + "?"));

        }


        int index = temp.indexOf(original.getData());
        // adds new question and answer to ArrayList for printing.
        if (yn.equalsIgnoreCase("y")){
            temp.add(index,"Q:" + original.getParent().getData());
            temp.add(index+2,"A:"+ original.getParent().getRight().getData());
        } else {
            temp.add(index,"Q:" + original.getParent().getData());
            temp.add(index+1,"A:" + original.getParent().getLeft().getData());
        }

        return temp;
    }

}
