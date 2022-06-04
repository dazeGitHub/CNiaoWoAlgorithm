package array_test.find_disappeared_numbers;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbersCNiao {
    
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null){
            return res;
        }
        for(int i = 0; i < nums.length; ++i){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){ 
                res.add(i + 1);
            }
        }
        return res;
    }

    public void test() {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(arr);
        System.out.println("result -> " + res);
        //result = [5, 6]
    }

    public static void main(String[] args){
        FindDisappearedNumbersCNiao obj = new FindDisappearedNumbersCNiao();
        obj.test();
    }
}
