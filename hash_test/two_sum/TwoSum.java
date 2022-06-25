package hash_test.two_sum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    
    //方式一 : 使用暴力解法
    public int[] twoSum_1(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i != j && nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum_2(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        //key 是数组值, value 是数组下标
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            int n = target - nums[i];
            if(hashMap.containsKey(n)){
                return new int[]{i, hashMap.get(n)};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public void test() {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] res_1 = twoSum_1(arr, 9);
        System.out.println("result1 -> " + res_1[0] + "\t" + res_1[1]);
        //result1 -> 0     1

        int[] res_2 = twoSum_2(arr, 9);
        System.out.println("result2 -> " + res_2[0] + "\t" + res_2[1]);
        //result2 -> 0     1
    }

    public static void main(String[] args){
        TwoSum obj = new TwoSum();
        obj.test();
    }
}
