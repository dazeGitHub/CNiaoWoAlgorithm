package array_test.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCNiao {

    public List<List<Integer>> threeSum(int[] nums){
        if(nums == null){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int k = 0; k < n - 2; k++){ //n - 2 是留给 i 的, n - 1 是留给 j 的
            //这里是优化判断 : 如果 k 指向的元素大于 0, 那么 k 后边的元素也都是大于 0 的
            if(nums[k] > 0){ 
                break;
            }
            if(k > 0 && nums[k - 1] == nums[k]){ //去重
                continue;
            }
            int i = k + 1;
            int j = n - 1;
            while(i < j){
                int tmp = nums[i] + nums[j] + nums[k];
                if(tmp > 0){
                    --j;
                    while(i < j && nums[j + 1] == nums[j]){ //防止 --j 的时候有重复元素
                        --j;
                    }
                }else if(tmp < 0){
                    ++i;
                    while(i < j && nums[i - 1] == nums[i]){ //防止 ++i 的时候有重复元素
                        ++i;
                    }
                }else{ //tmp == 0
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    ++i;
                    --j;
                    while(i < j && nums[i - 1] == nums[i]){
                        ++i;
                    }
                    while(i < j && nums[j + 1] == nums[j]){
                        --j;
                    }
                }
            }
        }
        
        return res;
    }
    
    public void test() {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(arr);
        for(List<Integer> list : res){
            System.out.println(list);
        }
        // [-1, -1, 2]
        // [-1, 0, 1]
    }

    public static void main(String[] args){
        ThreeSumCNiao obj = new ThreeSumCNiao();
        obj.test();
    }
}
