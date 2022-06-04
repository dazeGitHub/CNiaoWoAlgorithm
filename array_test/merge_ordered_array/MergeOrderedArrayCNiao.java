package array_test.merge_ordered_array;

import java.util.Arrays;

public class MergeOrderedArrayCNiao {
    
    //方式一 : 使用库函数排序
    public void merge_1(int[] nums1, int m, int[] nums2, int n){
        for(int i = m, j = 0; i < n + m; ++i, ++j){
            nums1[i] = nums2[j];
        }
        // for(int i = 0; i < n; ++i){
        //     nums1[m + i] = nums2[i];
        // }
        Arrays.sort(nums1);
    }

    //方式二 : 使用辅助空间
    public void merge_2(int[] nums1, int m, int[] nums2, int n){
        int i = 0; //用来遍历 arr
        int j = 0; //用来遍历 nums1
        int k = 0; //用来遍历 nums2
        int[] arr = new int[m + n];
        while(j < m || k < n){
            if(j == m){       //第一个数组遍历完毕
                arr[i++] = nums2[k++]; //那么将 nums2 中剩余的元素都拷贝到 arr 里
            }else if(k == n){ //第二个数组遍历完毕
                arr[i++] = nums1[j++]; //那么将 nums1 中剩余的元素都拷贝到 arr 里
            }else if(nums1[j] <= nums2[k]){ //将 nums1 和 nums2 中较小的元素放到 arr 里
                arr[i++] = nums1[j++];
            }else{
                arr[i++] = nums2[k++];
            }
        }
        //将 arr 中的元素拷贝到 nums1 中
        for(i = 0; i < arr.length; i++){
            nums1[i] = arr[i];
        }
    }

    //方式三 : 倒着比较排序
    public void merge_3(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;     //倒序遍历 nums1
        int j = n - 1 ;    //倒序遍历 nums2
        int k = n + m - 1; //nums1 倒序存放值 的指针

        while(i >= 0 || j >= 0){
            if(i < 0){
                nums1[k--] = nums2[j--];
            }else if(j < 0){
                nums1[k--] = nums1[i--];
            }else if(nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else {
                nums1[k--] = nums1[i--];
            }
        }
    }

    public void test() {
        // int[] arr1_a = new int[]{1,2,3,0,0,0};
        // int[] arr1_b = new int[]{2,5,6};
        // merge_1(arr1_a, 3, arr1_b, 3);
        // System.out.println("result -> " + Arrays.toString(arr1_a));
        //result -> [1, 2, 2, 3, 5, 6]

        // int[] arr2_a = new int[]{1,2,3,0,0,0};
        // int[] arr2_b = new int[]{2,5,6};
        // merge_2(arr2_a, 3, arr2_b, 3);
        // System.out.println("result -> " + Arrays.toString(arr2_a));
        //result -> [1, 2, 2, 3, 5, 6]

        int[] arr3_a = new int[]{1,2,3,0,0,0};
        int[] arr3_b = new int[]{2,5,6};
        merge_3(arr3_a, 3, arr3_b, 3);
        System.out.println("result -> " + Arrays.toString(arr3_a));
        //result -> [1, 2, 2, 3, 5, 6]
    }

    public static void main(String[] args){
        MergeOrderedArrayCNiao obj = new MergeOrderedArrayCNiao();
        obj.test();
    }
}
