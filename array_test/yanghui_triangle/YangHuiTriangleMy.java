package array_test.yanghui_triangle;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangleMy {

    public List<List<Integer>> genYangHuiTriangle(int n){

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> preLineList = new ArrayList<>();

        preLineList.add(1);
        ArrayList firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);

        for(int i = 1; i < n; ++i){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(1);
            for(int j = 1; j < preLineList.size(); ++j){
                tmpList.add(preLineList.get(j - 1) + preLineList.get(j));
            }
            tmpList.add(1);
            preLineList = tmpList;
            resultList.add(tmpList);
        }
        return resultList;
    }

    public void test() {
        int n = 5;
        List<List<Integer>> result = genYangHuiTriangle(n);
        for(List<Integer> eleList : result){
            System.out.println(eleList);
        }
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]
    }
    
    public static void main(String[] args){
        YangHuiTriangleMy obj = new YangHuiTriangleMy();
        obj.test();
    }
}
