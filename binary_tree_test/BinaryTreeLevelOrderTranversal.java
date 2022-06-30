package binary_tree_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTranversal {
    
    /**
     * 迭代实现 二叉树 的层次遍历
     */
    public List<List<Integer>> levelOrder_1(TreeNode root){
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size(); //当前这层的队列长度
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            //处理当前队列中的所有元素
            for(int i = 0; i < size; ++i){
                TreeNode treeNode = queue.remove();
                tmpList.add(treeNode.val);
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            res.add(tmpList);
        }
        return res;
    }

    /**
     * 递归实现 二叉树 的层次遍历
     */
    public List<List<Integer>> levelOrder_2(TreeNode root){
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1, root, res);
        return res;
    }

    /**
     * 使用 index 标示了递归的层数, 初始时 res.size() == 0
     */
    public void dfs(int index, TreeNode root, List<List<Integer>> res){
        if(res.size() < index){
            res.add(new ArrayList<Integer>());
        }
        res.get(index - 1).add(root.val);
        if(root.left != null){
            dfs(index + 1, root.left, res);
        }
        if(root.right != null){
            dfs(index + 1, root.right, res);
        }
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

        List<List<Integer>> res_1 = levelOrder_1(t1);
        System.out.println("func1:");
        for(List<Integer> li : res_1){
            System.out.println(li);
        }
        // func1:
        // [1]
        // [2, 3]
        // [4, 5]

        List<List<Integer>> res_2 = levelOrder_2(t1);
        System.out.println("func2:");
        for(List<Integer> li : res_2){
            System.out.println(li);
        }
        // func2:
        // [1]
        // [2, 3]
        // [4, 5]
    }

    public static void main(String[] args){
        BinaryTreeLevelOrderTranversal obj = new BinaryTreeLevelOrderTranversal();
        obj.test();
    }
}
