package binary_tree_test;

public class DeleteNodeInBst {

    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                root = null; //当 root 返回后之前的节点就可以删除该节点
            }else if(root.right != null){ //优先找后继节点
                root.val = findPostVal(root); //用后继节点的值覆盖 root.val 值
                root.right = deleteNode(root.right, root.val); //将 root.right 中重复的值删掉
            }else{ //没有后继节点
                root.val = findPreVal(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    //寻找前驱节点
    private int findPreVal(TreeNode node){
        node = node.left;
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }

    //寻找后继节点
    private int findPostVal(TreeNode node){
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
    
    public void test() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t7;
        TreeNode res = deleteNode(t5, 3);
        Util.printTreeNode(res);
        // [5(  L=4  R=6)]
        // [4(  L=2), 6(  R=7)]
        // [2(), 7()]
    }

    public static void main(String[] args){
        DeleteNodeInBst obj = new DeleteNodeInBst();
        obj.test();
    }
}
