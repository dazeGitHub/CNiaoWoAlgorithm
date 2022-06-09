package array_test.reverse_two_dimen_array;

import java.util.Arrays;

/**
 * 顺时针旋转矩阵数组
 */
public class RotateTwoDimenArrayCNiao {

    public void rotate(int[][] matrix){
        if(matrix == null){
            return;
        }

        //因为矩阵是 n x n 的, 所以长宽都是一样的
        int n = matrix.length;
        
        //1. 上下交换
        //因为只是上下翻转, 所以 i 只需要到 n / 2 即可
        //并不是真正的交换元素, 只需要交换改变数组的引用即可
        for(int i = 0; i < n / 2; ++i){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = tmp;
        }

        //2. 对角线交换
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){ //j 从右上角由上到下遍历, 呈现倒梯形状
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    public void test() {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(arr);
        for(int[] childArr : arr){
            System.out.println(Arrays.toString(childArr));
        }
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
    }

    public static void main(String[] args){
        RotateTwoDimenArrayCNiao obj = new RotateTwoDimenArrayCNiao();
        obj.test();
    }
}
