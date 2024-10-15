package code.BinaryTree;

public class BinaryTreeNode {
    
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(){}; // 无参
    BinaryTreeNode(int val){this.val = val;} // 单参
    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

     // 打印二叉树结构的方法
     public void printTree(String prefix, boolean isLeft) {
        if (right != null) {
            right.printTree(prefix + (isLeft ? "│   " : "    "), false);
        }
        
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + val);
        
        if (left != null) {
            left.printTree(prefix + (isLeft ? "    " : "│   "), true);
        }
    }


}

