package binary_tree_test;

import java.util.LinkedList;

public class InvertBinaryTree {
    
    /**
     * 使用递归实现翻转二叉树
     */
    public TreeNode invertTree_1(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree_1(root.left);
        invertTree_1(root.right);
        return root;
    }

    /**
     * 使用迭代实现翻转二叉树
     */
    public TreeNode invertTree_2(TreeNode root){
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
        return root;
    }

    public void test_1() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        t4.left = t2;
        t4.right = t7;
        t2.left = t1;
        t2.right = t3;
        t7.left = t6;
        t7.right = t9;
        TreeNode res = invertTree_1(t4);
        System.out.println("func1:");
        Util.printTreeNode(res);
        // func1:
        // [4(  L=7  R=2)]
        // [7(  L=9  R=6), 2(  L=3  R=1)]
        // [9(), 6(), 3(), 1()]
    }

    public void test_2() {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        t4.left = t2;
        t4.right = t7;
        t2.left = t1;
        t2.right = t3;
        t7.left = t6;
        t7.right = t9;
        TreeNode res = invertTree_2(t4);
        System.out.println("func2:");
        Util.printTreeNode(res);
        // func2:
        // [4(  L=7  R=2)]
        // [7(  L=9  R=6), 2(  L=3  R=1)]
        // [9(), 6(), 3(), 1()]
    }

    public static void main(String[] args){
        InvertBinaryTree ibt = new InvertBinaryTree();
        ibt.test_1();
        ibt.test_2();
    }
}
