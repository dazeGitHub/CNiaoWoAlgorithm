package advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LeastKthNumbers {

    //方式一 : 使用大根堆
    public int[] getLeastNumbers_1(int[] arr, int k){
        int[] vec = new int[k];
        if(k == 0){
            return vec;
        }
        //大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y)? 1 : ((x == y) ? 0 : -1); //y - x, 如果 x < y, 那么有 y - x > 0, 所以返回 1 是正确的
            }
        });
        //先加 k 个元素到大根堆中
        for(int i = 0; i < k; ++i){
            queue.offer(arr[i]);
        }
        for(int i = k; i < arr.length; ++i){
            if(queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for(int i = 0; i < k; ++i){
            vec[i] = queue.poll();
        }
        return vec;
    }

    //方式二 : 使用快速排序
    private final Random rand = new Random(); //使用随机数防止选择的是在 数组最左边 或 最右边

    public int[] getLeastNumbers_2(int[] arr, int k){
        if(k <= 0){
            return new int[0];
        }
        if(arr.length <= k){
            return arr;
        }
        select(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }
    
    /**
     * 快速排序的核心逻辑 :
     * int pos = randomPartition(arr, begin, end);
     * select(arr, begin, pos - 1, k);
     * select(arr, pos + 1, end, k);
     */
    private void select(int[] arr, int begin, int end, int k){
        if(begin >= end){
            return;
        }
        int pos = randomPartition(arr, begin, end);
        //递归执行 select, 直到 pos == k, 那么 k 左侧的元素都是 k 个最小的元素
        if(pos > k){
            select(arr, begin, pos - 1, k);
        }else if(pos < k){
            select(arr, pos + 1, end, k);
        }else{
            return;
        }
    }

    //7 2 5 3 6 1 4
    //以 4 做为分割点 : 
    //2 7 5 3 6 1 4
    //2 3 5 7 6 1 4
    //2 3 1 7 6 5 4
    //最后将 4 交换位置到中间
    //2 3 1 4 6 5 7
    private int randomPartition(int[] arr, int begin, int end){
        int randIdx = rand.nextInt(end - begin + 1) + begin;
        swap(arr, randIdx, end);
        int pivot = arr[end]; //交换后以最后一个元素作为分割点
        int j = begin;
        for(int i = begin; i < end; ++i){
            if(arr[i] < pivot){
                swap(arr, i, j);
                ++j;
            }
        }
        
        //最后再将最后一个元素 4 和 第一个大于 4 的元素(索引 j 指向的元素) 交换位置, 使得 4 在中间
        swap(arr, j, end);

        //最后返回分割点的下标 j 
        return j;   
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void test(){
        int[] arr = new int[]{12, 5, 4, 10, 6, 1, 11, 9, 2, 7, 3};
        int k = 3;
        int[] res_1 = getLeastNumbers_1(arr, k);
        System.out.println("result -> " + Arrays.toString(res_1)); //result -> [3, 2, 1]

        int[] res_2 = getLeastNumbers_2(arr, k);
        System.out.println("result -> " + Arrays.toString(res_2)); //result -> [1, 2, 3]
    }

    public static void main(String[] args) {
        LeastKthNumbers leastKthNumbers = new LeastKthNumbers();
        leastKthNumbers.test();
    }
}
