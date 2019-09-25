import java.util.ArrayList;
import java.util.Stack;

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

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {
    E value;
    public LinkedBinaryTreeNode<E> leftChild;
    public LinkedBinaryTreeNode<E> rightChild;
    public LinkedBinaryTreeNode<E> parent;
    int depth = 0;

    public LinkedBinaryTreeNode(E question) {
        value = question;
        depth = this.getDepth();
    }


    /**
     * Returns the data stored in this node.
     */
    @Override
    public E getData() {
        return value;
    }

    /**
     * Modifies the data stored in this node.
     */
    @Override
    public void setData(E value) {
        this.value = value;
    }

    /**
     * Returns the ancestor of this node that has no parent,
     * or returns this node if it is the root.
     */
    @Override
    public BinaryTreeNode<E> getRoot() {
        BinaryTreeNode<E> temp = parent;
        while (temp.getParent() != null) {
            temp = temp.getParent();
        }
        return temp;
    }

    /**
     * Setter method for parent
     * @param parent: parent node
     */
    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = (LinkedBinaryTreeNode)parent;
    }

    /**
     * Returns the parent of this node, or null if this node is a root.
     */
    @Override
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    /**
     * Returns the left child of this node, or null if it does
     * not have one.
     */
    @Override
    public BinaryTreeNode<E> getLeft() {
        return leftChild;
    }

    /**
     * Removes child from its current parent and inserts it as the
     * left child of this node.  If this node already has a left
     * child it is removed.
     */
    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        leftChild = (LinkedBinaryTreeNode)child;
        ((LinkedBinaryTreeNode<E>) child).setParent(this);
        ((LinkedBinaryTreeNode<E>) child).depth = depth + 1;
    }

    /**
     * Returns the right child of this node, or null if it does
     * not have one.
     */
    @Override
    public BinaryTreeNode<E> getRight() {
        return rightChild;
    }

    /**
     * Removes child from its current parent and inserts it as the
     * right child of this node.  If this node already has a right
     * child it is removed.
     */
    @Override
    public void setRight(BinaryTreeNode<E> child) {
        rightChild = (LinkedBinaryTreeNode)child;
        ((LinkedBinaryTreeNode<E>) child).setParent(this);
        ((LinkedBinaryTreeNode<E>) child).depth = depth + 1;
    }

    /**
     * Returns true if the node has any children.
     * Otherwise, returns false.
     */
    @Override
    public boolean isParent() {

        if (getLeft() == null && getRight() == null) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if the node is childless.
     * Otherwise, returns false.
     */
    @Override
    public boolean isLeaf() {
//        return !isParent();

        if (getLeft() == null && getRight() == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the node has a left child
     */
    @Override
    public boolean hasLeftChild() {
//        return leftChild != null;

        if (getLeft() != null) {
            return true;
        } return false;
    }

    /**
     * Returns true if the node has a right child
     */
    @Override
    public boolean hasRightChild() {
//        return rightChild != null;

        if (getRight() != null) {
            return true;
        } return false;
    }

    /**
     * Returns the number of edges in the path from the root to this node.
     */
    @Override
    public int getDepth() {
        int depth = 0;
        BinaryTreeNode<E> currentNode = this;
        while (currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
            depth++;
        }

        return depth;
    }

    /**
     * Returns the number of edges in the path from the root
     * to the node with the maximum depth.
     */
    @Override
    public int getHeight() {
        final int[] height = {0};
        BinaryTreeNode<E> root = getRoot();
        root.traversePreorder(node -> {
            int depth = node.getDepth();
            if(height[0] < depth) {
                height[0] = depth;
            }
        });
        return height[0];
    }

    /**
     * Returns the number of nodes in the subtree rooted at this node.
     */
    @Override
    public int size() {
        final int[] size1 = {0};
        traversePreorder(node -> {
            size1[0]++;
        });
        return size1[0];
    }

    /**
     * Removes this node, and all its descendants, from whatever
     * tree it is in.  Does nothing if this node is a root.
     */
    @Override
    public void removeFromParent() {
        if (getParent() != null) {
            if (getParent().getLeft() == this) {
                getParent().setLeft(null);
            } else {
                getParent().setRight(null);
            }
            setParent (null);
        }
    }

    /**
     * Returns the path from this node to the specified descendant.
     * If no path exists, returns an empty list.
     */
    @Override
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {
        ArrayList<BinaryTreeNode<E>> pathFrom = descendant.pathFrom(this);
        Stack<BinaryTreeNode<E>> stack = new Stack<>();
        for (BinaryTreeNode<E> node : pathFrom){
            stack.push(node);
        }
        ArrayList<BinaryTreeNode<E>> pathTo = new ArrayList<>();
        while (!stack.isEmpty()){
            pathTo.add(stack.pop());

        }
        return pathTo;

    }

    /**
     * Returns the path to this node from the specified ancestor.
     * If no path exists, returns an empty list.
     */
    @Override
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        BinaryTreeNode<E> currentNode = this;
        ArrayList<BinaryTreeNode<E>> pathFrom = new ArrayList<>();

        while (currentNode!= null && currentNode!= ancestor) {
            pathFrom.add(currentNode);
            currentNode = currentNode.getParent();
        }

        if (currentNode == null){
            return new ArrayList<>();
        }

        pathFrom.add(currentNode);
        return pathFrom;
    }

    /**
     * Visits the nodes in this tree in preorder.
     */
    @Override
    public void traversePreorder(Visitor visitor) {

        visitor.visit(this);
        if(hasLeftChild()) getLeft().traversePreorder(visitor);
        if(hasRightChild()) getRight().traversePreorder(visitor);
    }

    /**
     * Visits the nodes in this tree in postorder.
     */
    @Override
    public void traversePostorder(Visitor visitor) {

        if(hasLeftChild()) getLeft().traversePreorder(visitor);
        if(hasRightChild()) getRight().traversePreorder(visitor);
        visitor.visit(this);
    }

    /**
     * Visits the nodes in this tree in inorder.
     */
    @Override
    public void traverseInorder(Visitor visitor) {
        if(hasLeftChild()) getLeft().traversePreorder(visitor);
        visitor.visit(this);
        if(hasRightChild()) getRight().traversePreorder(visitor);
    }
}
