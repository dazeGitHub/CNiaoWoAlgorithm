package array_test.arr_delete_ele;

import java.util.Arrays;

/**
 * 单侧双指针的实现代码
 */
public class ArrDeleteCNiao1 {

    public int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        //++j 性能比 j++ 好一点
        for(int j = 0; j < nums.length; ++j){
            if(nums[j] != val){
                nums[i] = nums[j];
                ++i;
            }
        }
        return i;
    }

    public void test() {
        //1. arr = 3,1,2,3,4         val = 3  结果 : newArrLen = 3
        //2. arr = 0,1,2,2,3,0,4,2   val = 2  结果 : newArrLen = 5
        //3. arr = 1,2,3,4,5,6       val = 3  结果 : newArrLen = 5
        int[] arr = new int[]{1,2,3,4,5,6}; 
        int newArrLen = removeElement(arr, 3);
        System.out.println(
            "处理后的数组结果 -> " + Arrays.toString(arr) 
            + " 新长度为 -> " + newArrLen
        );
        //1. 处理后的数组结果 -> [1, 2, 4, 3, 4] 新长度为 -> 3
        //3. 处理后的数组结果 -> [1, 2, 4, 5, 6, 6] 新长度为 -> 5
    }

    public static void main(String[] args){
        ArrDeleteCNiao1 obj = new ArrDeleteCNiao1();
        obj.test();
    }
}