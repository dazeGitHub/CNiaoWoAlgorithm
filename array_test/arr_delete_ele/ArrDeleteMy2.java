package array_test.arr_delete_ele;

/**
 * 我的双侧双指针的实现代码
 */
public class ArrDeleteMy2 {
    public static void main(String[] args){
        System.out.println("helloworld");

        //1. arr = 3,2,2,3   toRemoveVal = 3  结果 : removedEleLength = 2
        //2. arr = 0,1,2,2,3,0,4,2  toRemoveVal = 2 结果 : removedEleLength = 3
        //3. arr = 1,2,3,4,5,6  toRemoveVal = 3  结果 : removedEleLength = 5
        int [] arr = {1,2,3,4,5,6}; 
        int toRemoveVal = 3;            
        int removedEleLength = removeElement(arr, toRemoveVal);
        System.out.println("removedEleLength = " + removedEleLength);
        System.out.println("arr Ele = ");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int temp = 0;
        int removedEleLength = 0;
        int lastExEleIndex = nums.length - 1; //和后边的一个元素交换位置,这是后边的该元素的 index
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == val){
                if(i == lastExEleIndex){
                    removedEleLength = i;
                    break;
                }
                for(int j = lastExEleIndex; j >= 0; j--){
                    if(nums[j] != val){
                        temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        lastExEleIndex = j;
                        break;
                    }
                }
            }
        }
        return removedEleLength;
    }
}
