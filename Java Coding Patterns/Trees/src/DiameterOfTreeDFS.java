public class DiameterOfTreeDFS {
    static class Pair{
        int diameter;
        int height;
        Pair(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    private static Pair diameterHelper(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);
        else{
            Pair left = diameterHelper(root.left);
            Pair right = diameterHelper(root.right);

            int height = Math.max(left.height, right.height) + 1;

            int diameter = Math.max(left.diameter, Math.max(right.diameter, left.height + right.height));

            return new Pair(diameter, height);
        }
    }


    public static int diameterDFS(TreeNode root){
        if (root == null)
            return 0;

        Pair pair = diameterHelper(root);

        return pair.diameter;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(4);
        binaryTree.add(1);
        binaryTree.add(5);
        binaryTree.add(8);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Diameter of the tree is " + diameterDFS(binaryTree.root));
    }
}
