package array_test.search_insert_pos;

public class SearchInsertPosCNiao {

    /**
     * 原始的二分查找
     */
    public int twoSplitSearch(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int begin = 0;
        int end = nums.length - 1;
        while(begin <= end){
            int mid = begin + (end - begin) / 2;
            //int mid = (begin + end) / 2; // 这种写法如果 begin 和 end 很大那么可能溢出
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                begin = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    /**
     * 搜索插入位置
     */
    public int searchInsert(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int begin = 0;
        int end = nums.length - 1;
        while(begin <= end){
            int mid = begin + (end - begin) / 2;
            //int mid = (begin + end) / 2; // 这种写法如果 begin 和 end 很大那么可能溢出
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                begin = mid + 1;
            }else{
                return mid;
            }
        }
        return begin;
    }

    public void test() {
        // int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        // int target = 2;

        // int targetIndex = twoSplitSearch(arr, target);
        // System.out.println("searchIndex = " + targetIndex);
        //searchIndex = 1

        int[] arr_1 = new int[]{1,3,5,6};
        int[] arr_2 = new int[]{1,3,5,6};
        int res_1 = searchInsert(arr_1, 5);
        int res_2 = searchInsert(arr_2, 2);
        System.out.println("result_1 -> " + res_1);
        System.out.println("result_2 -> " + res_2);
        // result_1 -> 2
        // result_2 -> 1
    }
    
    public static void main(String[] args){
        SearchInsertPosCNiao obj = new SearchInsertPosCNiao();
        obj.test();
    }
}
