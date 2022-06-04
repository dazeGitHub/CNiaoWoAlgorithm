package array_test.merge_region;

import java.util.Arrays;

public class MergeRegionMy {

    public int[][] merge_region(int[][] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        Arrays.sort(arr, (x,y) -> x[0] - y[0]);
        int[][] resultArr = new int[arr.length][2];
        int resultArrLastIndex = 0;
        resultArr[resultArrLastIndex] = arr[0]; //先给 resultArr 赋值 arr 第 0 个元素
        for(int i = 1; i < arr.length; ++i){
            var resultArrLastEle = resultArr[resultArrLastIndex];
            if(resultArrLastEle[1] > arr[i][0]){ //区间相交
                resultArrLastEle[1] = Math.max(resultArrLastEle[1], arr[i][1]);
            }else{
                resultArr[++resultArrLastIndex] = arr[i];
            }
        }
        return resultArr;
    }

    public void test() {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] resultArr = merge_region(arr);
        for(int i = 0; i < resultArr.length; ++i){
            System.out.println("resultArr = " + Arrays.toString(resultArr[i]));
        }
        // resultArr = [1, 6]
        // resultArr = [8, 10]
        // resultArr = [15, 18]
        // resultArr = [0, 0]
    }

    public static void main(String[] args){
        MergeRegionMy obj = new MergeRegionMy();
        obj.test();
    }
}
