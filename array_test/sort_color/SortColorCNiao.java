package array_test.sort_color;

import java.util.Arrays;

public class SortColorCNiao {
    
    public void sortColors_1(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                ++ zero;
            }else if(nums[i] == 1){
                ++ one;
            }else{
                ++ two;
            }
        }
        //重写数组写法一 :
        // for(int i = 0; i < nums.length; i++){
        //     if(i < zero){
        //         nums[i] = 0;
        //     }else if(i < zero + one){
        //         nums[i] = 1;
        //     }else if(i < zero + one + two){
        //         nums[i] = 2;
        //     }
        // }
        //重写数组写法二 :
        int j = 0;
        while(j < zero){
            nums[j] = 0;
            ++j;
        }
        while(j < zero + one){
            nums[j] = 1;
            ++j;
        }
        while(j < zero + one + two){
            nums[j] = 2;
            ++j;
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sortColors_2(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int i = 0;
        for(int j = 0; j < nums.length; ++j){
            if(nums[j] == 0){
                swap(nums, i, j);
                ++ i;
            }
        }
        for(int j = i; j < nums.length; ++j){
            if(nums[j] == 1){
                swap(nums, i, j);
                ++ i;
            }
        }
    }

    public void sortColors_3(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }

        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        while(cur <= p2){
            if(nums[cur] == 0){
                swap(nums, cur, p0);
                ++cur;
                ++p0;
            }else if(nums[cur] == 2){
                swap(nums, cur, p2);
                --p2;
            }else{  //nums[cur] == 1
                ++cur;
            }
        }
    }

    public void test() {
        // int[] arr_1 = new int[]{2,0,2,1,1,0}; //0,2,2,1,0,2,1 //2,0,2,1,1,0
        // sortColors_1(arr_1);
        // System.out.println("result arr_1 = " + Arrays.toString(arr_1));
        //result arr_1 = [0, 0, 1, 1, 2, 2, 2]
        //result arr_1 = [0, 0, 1, 1, 2, 2]

        // int[] arr_2 = new int[]{2,0,2,1,1,0}; //0,2,2,1,0,2,1 //2,0,2,1,1,0
        // sortColors_2(arr_2);
        // System.out.println("result arr_2 = " + Arrays.toString(arr_2));
        //result arr_2 = [0, 0, 1, 1, 2, 2]

        int[] arr_3 = new int[]{2,0,2,1,1,0}; //0,2,2,1,0,2,1 //2,0,2,1,1,0
        sortColors_3(arr_3);
        System.out.println("result arr_3 = " + Arrays.toString(arr_3));
        //result arr_3 = [0, 0, 1, 1, 2, 2]
    }

    public static void main(String[] args){
        SortColorCNiao obj = new SortColorCNiao();
        obj.test();
    }
}
