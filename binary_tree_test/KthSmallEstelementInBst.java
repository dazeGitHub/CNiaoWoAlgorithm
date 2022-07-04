package binary_tree_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Search Tree : 缩写为 Bst, 二叉搜索树
 */
public class KthSmallEstelementInBst {

    public int kthSmallest_1(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        List<Integer> list = new ArrayList<Integer>();
        //使用栈实现中序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size() > 0 || root != null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                root = tmp.right;
            }
        }
        return list.get(k - 1);
    }

    private int ans = 0; //第 ans 个最小的元素
    private int count = 0;
    
    public int kthSmallest_2(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        this.count = k;
        dfs(root, k);
        return this.ans;
    }

    private void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.left, k);
        //this.count 可能为负的, 所以将 this.count == 0 时
        //root.val 的值保存到 this.ans 中
        --this.count; 
        //System.out.println("this.count = " + this.count);
        if(this.count == 0){
            this.ans = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public void test() {

        //基于 示例二 构造二叉搜索树
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t1 = new TreeNode(1);
        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;

        //Util.printTreeNode(t5);
        // [5(  L=3  R=6)]
        // [3(  L=2  R=4), 6()]
        // [2(  L=1), 4()]
        // [1()]
        
        System.out.println("result_1 -> " + kthSmallest_1(t5, 3));
        // result_1 -> 3

        System.out.println("result_2 -> " + kthSmallest_2(t5, 3));
        // result_2 -> 3
    }

    public static void main(String[] args){
        KthSmallEstelementInBst obj = new KthSmallEstelementInBst();
        obj.test();
    }
}
