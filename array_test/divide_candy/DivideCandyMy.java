package array_test.divide_candy;

import java.util.Arrays;

public class DivideCandyMy {

    public int[] divideCandy(int[] arr, int maxCandiesCount){
        if(arr == null || arr.length == 0){
            return arr;
        }

        int totalCandies = 0;
        int loopCount = 0; //循环数量
        while(totalCandies < maxCandiesCount){
            for(int i = 0; i < arr.length; ++i){
                var tempCandy = loopCount * (arr.length) + i + 1;
                if(totalCandies + tempCandy > maxCandiesCount){
                    tempCandy = maxCandiesCount - totalCandies;
                }
                arr[i] += tempCandy;
                totalCandies += tempCandy;
            }
            ++ loopCount;
        }
        return arr;
    }

    public void test() {
        int num_people = 5;
        int[] arr = new int[num_people];
        int candies = 50;
        int[] candyArr = divideCandy(arr, candies);
        System.out.println("result candyArr -> " + Arrays.toString(candyArr));

        int tempTotalCandyCount = 0;
        for(int i = 0; i < candyArr.length; i++){
            tempTotalCandyCount += candyArr[i];
        }
        System.out.println("result tempTotalCandyCount -> " + tempTotalCandyCount);
    }

    public static void main(String[] args){
        DivideCandyMy obj = new DivideCandyMy();
        obj.test();
    }
}
