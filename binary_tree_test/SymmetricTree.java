package binary_tree_test;

import java.util.LinkedList;

public class SymmetricTree {

    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left, right.right) && 
                    dfs(left.right, right.left);
    }

    /*
     * 使用递归判断二叉树是否对称
     */
    public boolean isSymmetric_1(TreeNode root){
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }
    
    /**
     * 使用迭代判断二叉树是否对称
     */
    public boolean isSymmetric_2(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size() > 0){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            //这里和递归中的判断相同
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public void test_1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2_a = new TreeNode(2);
        TreeNode t2_b = new TreeNode(2);
        TreeNode t3_a = new TreeNode(3);
        TreeNode t3_b = new TreeNode(3);
        TreeNode t4_a = new TreeNode(4);
        TreeNode t4_b = new TreeNode(4);
        TreeNode t8_a = new TreeNode(8);
        TreeNode t8_b = new TreeNode(8);
        TreeNode t7_a = new TreeNode(7);
        TreeNode t7_b = new TreeNode(7);
        TreeNode t6_a = new TreeNode(6);
        TreeNode t6_b = new TreeNode(6);
        TreeNode t5_a = new TreeNode(5);
        TreeNode t5_b = new TreeNode(5);
        t1.left = t2_a;
        t1.right = t2_b;

        t2_a.left = t3_a;
        t2_a.right = t4_a;
        t3_a.left = t8_a;
        t3_a.right = t7_a;
        t4_a.left = t6_a;
        t4_a.right = t5_a;
        
        t2_b.left = t4_b;
        t2_b.right = t3_b;
        t3_b.left = t7_b;
        t3_b.right = t8_b;
        t4_b.left = t5_b;
        t4_b.right = t6_b;

        //Util.printTreeNode(t1);
        System.out.println("result_1 -> " + isSymmetric_1(t1));
        //result_1 -> true

        System.out.println("result_2 -> " + isSymmetric_2(t1));
        //result_2 -> true
    }

    public static void main(String[] args){
        SymmetricTree ibt = new SymmetricTree();
        ibt.test_1();
    }
}
