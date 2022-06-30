package binary_tree_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTranversal {

    /**
     * 使用 递归 实现 中序遍历
     */
    public void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    public List<Integer> inorderTraversal_1(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }

    /**
     * 使用 栈 实现 中序遍历
     */
    public List<Integer> inorderTraversal_2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size() > 0 || root != null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        List<Integer> res_1 = inorderTraversal_1(t1);
        System.out.println("result_1 -> " + res_1);
        //result_1 -> [4, 2, 5, 1, 3]

        List<Integer> res_2 = inorderTraversal_2(t1);
        System.out.println("result_2 -> " + res_2);
        //result_2 -> [4, 2, 5, 1, 3]
    }

    public static void main(String[] args){
        BinaryTreeInorderTranversal obj = new BinaryTreeInorderTranversal();
        obj.test();
    }
}