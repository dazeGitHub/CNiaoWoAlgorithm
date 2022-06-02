package array_test.move_zero;

import java.util.Arrays;

public class MoveZeroCNiao {

    //两次遍历
    public void moveZeroes_1(int[] nums){
        if(nums == null){
            return;
        }
        //j 是后指针, i 是前指针。
        //无论是否 else 指针 i 肯定是要 ++ 的, 所以用 for 循环。
        int j = 0; 
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                nums[j] = nums[i];
                ++j;
            }
        }
        for(int i = j; i < nums.length; ++i){
            nums[i] = 0;
        }
    }

    //一次遍历
    public void moveZeroes_2(int[] nums){
        if(nums == null){
            return;
        }
        int j = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++j;
            }
        }
    }

    public void test() {
        // int[] arr_1 = new int[]{0,1,0,3,12}; //1,0,2,5,0,9,0
        // moveZeroes_1(arr_1);
        // System.out.println("result arr_1 = " + Arrays.toString(arr_1));
        //result arr_1 = [1, 3, 12, 0, 0]
        //result arr_1 = [1, 2, 5, 9, 0, 0, 0]

        int[] arr_2 = new int[]{0,1,0,3,12}; //1,0,2,5,0,9,0
        moveZeroes_2(arr_2);
        System.out.println("result arr_2 = " + Arrays.toString(arr_2));
        //result arr_2 = [1, 3, 12, 0, 0]
        //result arr_2 = [1, 2, 5, 9, 0, 0, 0]
    }

    public static void main(String[] args){
        MoveZeroCNiao obj = new MoveZeroCNiao();
        obj.test();
    }
}
