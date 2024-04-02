import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    TreeNode root;
    private TreeNode addRecursive(TreeNode current, int data) {
        if (current == null) {
            return new TreeNode(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int data) {
        root = addRecursive(root, data);
    }

    public void inOrderTraversal( TreeNode node){
        if ( node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(" " + node.data);
        inOrderTraversal(node.right);
    }

    public void preOrderTraversal( TreeNode node){
        if ( node == null)
            return;

        System.out.print(" " + node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

}
