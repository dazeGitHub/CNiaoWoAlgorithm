package array_test.find_first_and_last;

public class FindFirstAndLast {
    
    public int[] searchRange(int[] nums, int target){
        if(nums == null){
            return new int[]{-1, -1};
        }
        int firstIndex = find(true, nums, target);
        int lastIndex = find(false, nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    //处理边界条件, 查找第一个和最后一个代码有重复的, 所以新写一个函数
    private int find(boolean isFirst, int[] nums, int target){
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
                //return mid;
                if(isFirst){
                    if(mid > 0 && nums[mid] == nums[mid - 1]){
                        end = mid - 1;
                    }else{
                        return mid;
                    }
                }else{
                    if(mid < nums.length - 1 && nums[mid] == nums[mid + 1]){
                        begin = mid + 1;
                    }else{
                        return mid;
                    }
                }
            }
        }
        return -1;
    }

    public void test() {
        int[] arr = new int[]{5,7,7,8,8,10};
        int[] arr2 = new int[]{1,2,3,3,3,3,3,3,3,3,3,3,3};
        int[] res_1 = searchRange(arr, 8);
        int[] res_2 = searchRange(arr2, 3);
        System.out.println("first -> " + res_1[0] + " \t last-> " + res_1[1]);
        System.out.println("first -> " + res_2[0] + " \t last-> " + res_2[1]);
        // first -> 3       last-> 4
        // first -> 2       last-> 12
    }

    public static void main(String[] args){
        FindFirstAndLast obj = new FindFirstAndLast();
        obj.test();
    }
}
