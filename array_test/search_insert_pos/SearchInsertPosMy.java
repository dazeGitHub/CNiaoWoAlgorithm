package array_test.search_insert_pos;

public class SearchInsertPosMy {

    /**
     * 原始的二分查找
     */
    public int twoSplitSearch(int[] nums, int target){
        int begin = 0;
        int end = nums.length - 1;
        int midIndex = (begin + end) / 2;
        // while(nums[midIndex] )

        return 0;
    }

    public void test() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 2;
        int targetIndex = twoSplitSearch(arr, target);
        System.out.println("searchIndex = " + targetIndex);
    }
    
    public static void main(String[] args){
        SearchInsertPosMy obj = new SearchInsertPosMy();
        obj.test();
    }
}
