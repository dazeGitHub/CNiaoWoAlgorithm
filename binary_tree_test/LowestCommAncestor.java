package binary_tree_test;

public class LowestCommAncestor {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //root == null 表示一直递归到叶子节点的左右节点, 
        //如果左右节点为 null, 那么 return null
        //root == p 表示找到了 p 节点
        //root == q 表示找到了 q 节点
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){ //左边和右边都找到了
            return root;
        }
        return (left != null)? left : right;
    }

    public void test_1() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t1.left = t0;
        t1.right = t8;
        t2.left = t7;
        t2.right = t4;
        TreeNode res = lowestCommonAncestor(t3, t7, t8);
        System.out.println("result -> " + res.val);
        //result -> 3
    }

    public static void main(String[] args){
        LowestCommAncestor ibt = new LowestCommAncestor();
        ibt.test_1();
    }
}
