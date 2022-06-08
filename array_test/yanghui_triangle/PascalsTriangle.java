package array_test.yanghui_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 和 帕斯卡三角 是一个东西
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows){
        if(numRows <= 0){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; ++i){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){ //j = 0 则相当于三角形左边的边, j == i 即三角形右边的边
                    tmp.add(1);
                }else{
                    //list.get(i - 1) 是上一层
                    //tmp.add(斜上方 + 上方)
                    tmp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(tmp);
        }
        return list;
    }

    public void test() {
        List<List<Integer>> res = generate(5);
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]
    }
    
    public static void main(String[] args){
        PascalsTriangle obj = new PascalsTriangle();
        obj.test();
    }
}
