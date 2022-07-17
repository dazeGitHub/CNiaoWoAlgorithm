package advanced;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        if(root == null){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder(), root);
        return res;
    }

    /**
     * @param res  : 用来保存路径
     * @param tmp  : 用来保存上一个结果集路径
     * @param root : 本次递归的根节点
     */
    private void dfs(List<String> res, StringBuilder tmp, TreeNode root){
        if(root == null){ //如果不是叶子节点, 是空节点, 那么返回
            return;
        }

        //如果是叶子节点, 那么保存路径到 res 中, 然后返回
        if(root != null && (root.left == null && root.right == null)){ 
            res.add(tmp.toString() + root.val);
            return;
        }

        //   1
        //  / \
        // 2   3
        //
        if(root.left != null){   //1
            String content = root.val + "->";
            tmp.append(content); //1 -> 
            dfs(res, tmp, root.left); //1 -> 2
            tmp.delete(tmp.length() - content.length(), tmp.length()); // 1

            //如果 tmp 是 String 那么可以这样写, 但是就看不出 append(选择) 和 delete(撤销) 效果了
            //dfs(res, tmp + "->", root)
        }

        if(root.right != null){
            String content = root.val + "->";
            tmp.append(content);
            dfs(res, tmp, root.right);
            tmp.delete(tmp.length() - content.length(), tmp.length());
        }
    }
    
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        List<String> res = binaryTreePaths(t1);
        System.out.println("result -> " + res.toString());
        //result -> [1->2->5, 1->3]
    }

    public static void main(String[] args) {
        BinaryTreePaths treePaths = new BinaryTreePaths();
        treePaths.test();
    }
}
