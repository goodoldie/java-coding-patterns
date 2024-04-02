public class MaximumPathSum {

    static int result = Integer.MIN_VALUE;
    public static int calculateMaximumPathSum(TreeNode node){
        if ( node == null)
            return 0;

        int leftSum = calculateMaximumPathSum(node.left);
        int rightSum = calculateMaximumPathSum(node.right);

        //If the node itself wants to contribute to the sum or not
        int temp = Math.max(Math.max(leftSum, rightSum) + node.data, node.data);
        //Pass the result to above node
        int answer = Math.max(temp, leftSum + rightSum + node.data);

        result = Math.max(result, answer);

        return temp;
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(4);
        binaryTree.add(1);
        binaryTree.add(5);
        binaryTree.add(-8);
        binaryTree.add(-7);
        binaryTree.add(-9);
        System.out.println("Maximum Path Sum is " + calculateMaximumPathSum(binaryTree.root));
    }
}
