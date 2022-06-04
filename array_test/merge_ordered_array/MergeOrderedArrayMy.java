package array_test.merge_ordered_array;

import java.util.Arrays;

public class MergeOrderedArrayMy {
    
    //方式一 : 使用库函数排序
    public void merge_1(int[] nums1, int m, int[] nums2, int n){
        for(int i = 0; i < n; ++i){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //方式二 : 使用辅助空间
    public void merge_2(int[] nums1, int m, int[] nums2, int n){
        int i = 0; //用来遍历 nums1 
        int j = 0; //用来遍历 nums2
        int[] nums3 = new int[m + n];
        for(int k = 0; k < nums3.length; ++k){
            if((nums1[i] < nums2[j]) && (nums1[i] != 0)){
                nums3[k] = nums1[i];
                ++i;
            }else{
                nums3[k] = nums2[j];
                ++j;
            }
        }
        for(int k = 0; k < nums1.length; ++ k){
            nums1[k] = nums3[k];
        }
    }

    //方式三 : 倒着比较排序
    public void merge_3(int[] nums1, int m, int[] nums2, int n){
        int i = n + m - 1; //nums1 倒序存放值 的指针
        int j = m - 1;     //倒序遍历 nums1
        int k = n - 1 ;    //倒序遍历 nums2
        while((j >= 0 || k >= 0) && i >= 0){
            if(j < 0){
                nums1[i--] = nums2[k--];
            }else if(k < 0){
                nums1[i--] = nums1[j--];
            }else if(nums1[j] > nums2[k]){
                nums1[i--] = nums1[j--];
            }else {
                nums1[i--] = nums2[k--];
            }
        }
    }

    public void test() {
        int[] arr1_a = new int[]{1,2,3,0,0,0};
        int[] arr1_b = new int[]{2,5,6};
        merge_1(arr1_a, 3, arr1_b, 3);
        System.out.println("merge_1 result -> " + Arrays.toString(arr1_a));
        //merge_1 result -> [1, 2, 2, 3, 5, 6]

        int[] arr2_a = new int[]{1,2,3,0,0,0};
        int[] arr2_b = new int[]{2,5,6};
        merge_2(arr2_a, 3, arr2_b, 3);
        System.out.println("merge_2 result -> " + Arrays.toString(arr2_a));
        //merge_2 result -> [1, 2, 2, 3, 5, 6]

        int[] arr3_a = new int[]{1,2,3,0,0,0};
        int[] arr3_b = new int[]{2,5,6};
        merge_3(arr3_a, 3, arr3_b, 3);
        System.out.println("merge_3 result -> " + Arrays.toString(arr3_a));
        //merge_3 result -> [1, 2, 2, 3, 5, 6]
    }

    public static void main(String[] args){
        MergeOrderedArrayMy obj = new MergeOrderedArrayMy();
        obj.test();
    }
}
