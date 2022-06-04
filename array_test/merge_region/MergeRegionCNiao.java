package array_test.merge_region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeRegionCNiao {

    public int[][] merge(int[][] intervals){
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        //排序方式一 : 使用 Comparator 接口
        // Arrays.sort(intervals, new Comparator<int[]>() {

        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[0] - o2[0];
        //     }
        // });
        //排序方式二 : 使用 lambda 表达式排序
        Arrays.sort(intervals, (x,y) -> x[0] - y[0]);
        List<int[]> arrList = new ArrayList<int[]>();
        arrList.add(intervals[0]);
        for(int i = 1; i < intervals.length; ++i){
            if(arrList.get(arrList.size() - 1)[1] < intervals[i][0]){
                arrList.add(intervals[i]);
            }else{
                arrList.get(arrList.size() - 1)[1] = 
                    Math.max(arrList.get(arrList.size() - 1)[1], intervals[i][1]);
            }
        }
        return arrList.toArray(new int[arrList.size()][2]);
    }

    public void test() {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(arr);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
        // [1, 6]
        // [8, 10]
        // [15, 18]
    }

    public static void main(String[] args){
        MergeRegionCNiao obj = new MergeRegionCNiao();
        obj.test();
    }
}
