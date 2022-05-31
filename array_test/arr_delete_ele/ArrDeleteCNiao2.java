package array_test.arr_delete_ele;

import java.util.Arrays;

/**
 * 双侧双指针的实现代码
 */
public class ArrDeleteCNiao2 {

    public int removeElement(int[] nums, int val){
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
        //1. arr = 3,1,2,3,4         val = 3  结果 : newArrLen = 3
        //2. arr = 0,1,2,2,3,0,4,2   val = 2  结果 : newArrLen = 5
        //3. arr = 1,2,3,4,5,6       val = 3  结果 : newArrLen = 5
        //4. arr = 1,3,5,2,3,7       val = 3  结果 : newArrLen = 4
        int[] arr = new int[]{1,3,5,2,3,7}; 
        int newArrLen = removeElement(arr, 3);
        System.out.println(
            "处理后的数组结果 -> " + Arrays.toString(arr) 
            + " 新长度为 -> " + newArrLen
        );
        //1. 处理后的数组结果 -> [4, 1, 2, 3, 4] 新长度为 -> 3
        //3. 处理后的数组结果 -> [1, 2, 6, 4, 5, 6] 新长度为 -> 5
        //4. 处理后的数组结果 -> [1, 7, 5, 2, 3, 7] 新长度为 -> 4
    }

    public static void main(String[] args){
        ArrDeleteCNiao2 obj = new ArrDeleteCNiao2();
        obj.test();
    }
}