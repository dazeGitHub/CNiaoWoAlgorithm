package array_test.move_zero;

import java.util.Arrays;

/**
 * 这个有错误, 顺序不对
 */
public class MoveZeroMy {

    public int[] moveZero(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        int lastZeroEleIndex = arr.length - 1;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == 0){
                while(arr[lastZeroEleIndex] == 0 && lastZeroEleIndex > i){
                    --lastZeroEleIndex;
                }
                if(lastZeroEleIndex <= i){
                    break;
                }
                int temp = arr[lastZeroEleIndex];
                arr[lastZeroEleIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public void test() {
        int[] arr = new int[]{1,0,2,5,0,9,0};
        int[] resultArr = moveZero(arr);
        System.out.println("resultArr = " + Arrays.toString(resultArr));
    }

    public static void main(String[] args){
        MoveZeroMy obj = new MoveZeroMy();
        obj.test();
    }
}
