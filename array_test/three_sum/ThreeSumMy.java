package array_test.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumMy {

    private void addEleListToList(
        ArrayList<List<Integer>> paramList,
        int kValue, int iValue, int jValue
    ){
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(kValue);
        tmpList.add(iValue);
        tmpList.add(jValue);
        paramList.add(tmpList);
    }

    //这个写法有问题
    public List<List<Integer>> threeSum(int[] nums){
        if(nums == null){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int k = 0; k < n; ++k){
            if(k != 0 && nums[k - 1] == nums[k]){
                continue;
            }

            int i = k + 1;
            int j = n - 1;

            if(k + 1 >= j){
                break;
            }

            var addResult = nums[k] + nums[i] + nums[j];
            if(addResult == 0){
                addEleListToList(res, nums[k], nums[i], nums[j]);
                for(++i, --j; i < j; ++i, --j){
                    if(addResult == 0){
                        addEleListToList(res, nums[k], nums[i], nums[j]);
                    }
                }
            }else if(addResult < 0){
                for(; i < j; ++i){
                    if(nums[i - 1] == nums[i]){ //跳过重复元素
                        continue;
                    }
                    if(i == k + 1){
                        ++i;
                    }
                    addResult = nums[k] + nums[i] + nums[j];
                    if(addResult == 0){
                        addEleListToList(res, nums[k], nums[i], nums[j]);
                    }
                }
            }else{ //addResult > 0
                --j;
            }
        }
        return res;
    }
    
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = threeSum(nums);
        for(List<Integer> list : resultList){
            System.out.println("resultList eleList = " + list);
        }
        // resultList eleList = [-1, -1, 2]
        // resultList eleList = [-1, 0, 1]
    }

    public static void main(String[] args){
        ThreeSumMy obj = new ThreeSumMy();
        obj.test();
    }
}
