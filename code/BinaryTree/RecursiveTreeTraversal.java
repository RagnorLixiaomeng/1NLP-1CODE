package code.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 前中后序遍历，本质既然是递归，那就按照递归3要素实战下
 * 
 * 1、确定递归函数的参数和返回值: 因为要打印出前序遍历节点的数值，所以参数里需要传入List<Integer>来放置节点的数值，除了这一点就不需要处理什么数据了，也不需要什么返回值，所以返回类型就是void
 * public void preorder(BinaryTreeNode root, List<Integer> result){}
 * 
 * 2、确定终止条件：在递归的过程中，如何算递归结束了呢？ ==》当前遍历的节点空了本层递归就结束了
 * if (root == null){return;}
 * 
 * 3、确定单层递归的逻辑：前序遍历是中左右的顺序，所以在单层递归的逻辑 ==》先取中节点的数值
 * result.add(root.val);
 * preorder(root.left, result);
 * preorder(root.right, result);
 * 
 * 就ok了,那中、后序就好写了
 * 
*/


public class RecursiveTreeTraversal {

    public static void preorder(BinaryTreeNode root, List<Integer> result){
        if (root == null){
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void inorder(BinaryTreeNode root, List<Integer> result){
        if (root == null){
            return;
        }

        
        preorder(root.left, result);
        result.add(root.val); // 这里
        preorder(root.right, result);
    }

    public static void postorder(BinaryTreeNode root, List<Integer> result){
        if (root == null){
            return;
        }

        
        preorder(root.left, result);
        preorder(root.right, result);
        result.add(root.val); // 这里
    }


    

    public static void main(String[] args) {
        System.out.println("构建树");

        // 构建该个树
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        
        BinaryTreeNode node4 = new BinaryTreeNode(4, node1, node2);
        BinaryTreeNode node6 = new BinaryTreeNode(6, node7, node8);
        
        BinaryTreeNode root = new BinaryTreeNode(5, node4, node6);

        System.out.println("构建完成");

        // 前序递归
        root.printTree(null, false);
        List<Integer> pre_res = new ArrayList<>();
        preorder(root, pre_res);
        System.out.println(pre_res);

        // 中序递归
        List<Integer> in_res = new ArrayList<>();


        // 后序递归
        List<Integer> post_res = new ArrayList<>();
        
    }
}
