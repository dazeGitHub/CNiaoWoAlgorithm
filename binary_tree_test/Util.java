package binary_tree_test;

import java.util.LinkedList;

public class Util {
    
    /**
     * 迭代实现 二叉树 的层次遍历 (节点不带右侧节点指针)
     */
    public static void printTreeNode(TreeNode root){
        if(root == null){
            return;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size(); //当前这层的队列长度
            //处理当前队列中的所有元素
            System.out.print("[");
            for(int i = 0; i < size; ++i){
                TreeNode treeNode = queue.remove();
                System.out.print(treeNode.val + "(");
                if(treeNode.left != null){
                    System.out.print("  L=" + treeNode.left.val);
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    System.out.print("  R=" + treeNode.right.val);
                    queue.add(treeNode.right);
                }
                System.out.print(")");
                if(i != size - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    /**
     * 迭代实现 二叉树 的层次遍历 (节点带右侧节点指针)
     */
    public static void printTreeNodeRight(TreeNodeRight root){
        if(root == null){
            return;
        }
        
        LinkedList<TreeNodeRight> queue = new LinkedList<TreeNodeRight>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size(); //当前这层的队列长度
            //处理当前队列中的所有元素
            System.out.print("[");
            for(int i = 0; i < size; ++i){
                TreeNodeRight treeNode = queue.remove();
                System.out.print(treeNode.val + "(");
                if(treeNode.left != null){
                    System.out.print("  L=" + treeNode.left.val);
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    System.out.print("  R=" + treeNode.right.val);
                    queue.add(treeNode.right);
                }
                if(treeNode.next != null){
                    System.out.print("  N=" + treeNode.next.val);
                }
                System.out.print(")");
                if(i != size - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
