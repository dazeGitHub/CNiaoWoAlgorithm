package binary_tree_test;

import java.util.Arrays;

public class ConstructFromPreInorder {
    
    /**
     * 使用递归实现 前序 + 中序 构造二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; ++i){
            //在 inorder 数组中找到了根节点后, 就拆分 inorder 数组
            if(preorder[0] == inorder[i]){ 
                //将前序数组一分为二
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                //将中序数组一分为二
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;
    }

    public void test() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = buildTree(preorder, inorder);
        Util.printTreeNode(res);
        // [3(  L=9  R=20)]
        // [9(), 20(  L=15  R=7)]
        // [15(), 7()]
    }

    public static void main(String[] args){
        ConstructFromPreInorder obj = new ConstructFromPreInorder();
        obj.test();
    }
}
