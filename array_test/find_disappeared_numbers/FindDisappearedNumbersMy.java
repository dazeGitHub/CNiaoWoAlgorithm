package array_test.find_disappeared_numbers;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbersMy {
    
    //将 0 - nums长度 的内容都放到 List 中, 移除 List 里 nums 中有的元素
    public List<Integer> findDisappearedNumbers(int[] nums){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return arrayList;
        }
        for(int i = 0; i < nums.length; ++i){
            arrayList.add(i + 1);
        }
        var removeIndex = -1;
        for(int num : nums){
            removeIndex = arrayList.indexOf(num);
            if(removeIndex != -1){
                arrayList.remove(removeIndex);
            }
        }
        return arrayList;
    }

    public void test() {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(arr);
        System.out.println("result = " + result.toString());
        //result = [5, 6]
    }

    public static void main(String[] args){
        FindDisappearedNumbersMy obj = new FindDisappearedNumbersMy();
        obj.test();
    }
}
