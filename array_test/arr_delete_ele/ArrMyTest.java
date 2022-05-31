package array_test.arr_delete_ele;

import java.util.Arrays;

/**
 * 我的测试代码
 */
public class ArrMyTest {

    public int removeElement1(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 0; j < nums.length; ++j){
            if(nums[j] != val){
                nums[i] = nums[j];
                ++i;
            }
        }
        return i;
    }

    public int removeElement2(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                --n;
            }else{
                ++i;
            }
        }
        return i;
    }

    public void test() {
        //1. 单侧双指针
        // int[] arr1 = new int[]{3,1,2,3,4}; 
        // int newArrLen1 = removeElement1(arr1, 3);
        // System.out.println(
        //     "处理后的数组结果 -> " + Arrays.toString(arr1) 
        //     + " 新长度为 -> " + newArrLen1
        // );
        //处理后的数组结果 -> [1, 2, 4, 3, 4] 新长度为 -> 3

        //2. arr2 = 0,1,2,2,3,0,4,2   val = 2  结果 : newArrLen2 = 5
        //3. arr2 = 1,2,3,4,5,6       val = 3  结果 : newArrLen2 = 5
        //4. arr2 = 1,3,5,2,3,7       val = 3  结果 : newArrLen2 = 4
        int[] arr2 = new int[]{1,3,5,2,3,7}; 
        int newArrLen2 = removeElement2(arr2, 3);
        System.out.println(
            "处理后的数组结果 -> " + Arrays.toString(arr2) 
            + " 新长度为 -> " + newArrLen2
        );
        //处理后的数组结果 -> [1, 7, 5, 2, 3, 7] 新长度为 -> 4
    }

    public static void main(String[] args){
        ArrMyTest obj = new ArrMyTest();
        obj.test();
    }
}