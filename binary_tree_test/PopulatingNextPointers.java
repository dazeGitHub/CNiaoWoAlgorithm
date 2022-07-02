package binary_tree_test;

import java.util.LinkedList;

public class PopulatingNextPointers {

    /**
     * 使用迭代填充右侧节点指针
     */
    public TreeNodeRight connect_1(TreeNodeRight root){
        if(root == null){
            return root;
        }
        LinkedList<TreeNodeRight> queue = new LinkedList<TreeNodeRight>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            //只是拿到第 0 个节点, 但是不弹出来
            TreeNodeRight tmp = queue.get(0);
            for(int i = 1; i < size; ++i){
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            for(int i = 0; i < size; ++i){
                tmp = queue.remove();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }

    /**
     * 使用递归填充右侧节点指针
     */
    public TreeNodeRight connect_2(TreeNodeRight root){
        if(root == null){
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNodeRight root){
        if(root == null){
            return;
        }
        //因为是完美的二叉树
        //所以 left 和 right 要么都是空的, 要么都不是空的
        TreeNodeRight left = root.left;
        TreeNodeRight right = root.right;
        //while 循环将整个峡谷节点都串联起来
        while(left != null){ //right 肯定也不是空的
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
    
    public void test_1() {
        TreeNodeRight t1 = new TreeNodeRight(1);
        TreeNodeRight t2 = new TreeNodeRight(2);
        TreeNodeRight t3 = new TreeNodeRight(3);
        TreeNodeRight t4 = new TreeNodeRight(4);
        TreeNodeRight t5 = new TreeNodeRight(5);
        TreeNodeRight t6 = new TreeNodeRight(6);
        TreeNodeRight t7 = new TreeNodeRight(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNodeRight res = connect_1(t1);
        System.out.println("func_1:");
        Util.printTreeNodeRight(res);
        // func_1:
        // [1(  L=2  R=3)]
        // [2(  L=4  R=5  N=3), 3(  L=6  R=7)]
        // [4(  N=5), 5(  N=6), 6(  N=7), 7()]
    }

    public void test_2() {
        TreeNodeRight t1 = new TreeNodeRight(1);
        TreeNodeRight t2 = new TreeNodeRight(2);
        TreeNodeRight t3 = new TreeNodeRight(3);
        TreeNodeRight t4 = new TreeNodeRight(4);
        TreeNodeRight t5 = new TreeNodeRight(5);
        TreeNodeRight t6 = new TreeNodeRight(6);
        TreeNodeRight t7 = new TreeNodeRight(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNodeRight res = connect_2(t1);
        System.out.println("func_2:");
        Util.printTreeNodeRight(res);
        // func_2:
        // [1(  L=2  R=3)]
        // [2(  L=4  R=5  N=3), 3(  L=6  R=7)]
        // [4(  N=5), 5(  N=6), 6(  N=7), 7()]
    }

    public static void main(String[] args){
        PopulatingNextPointers ibt = new PopulatingNextPointers();
        //ibt.test_1();
        ibt.test_2();
    }
}
