package array_test.screw_loop;

import java.util.Arrays;

/**
 * 螺旋遍历
 */
public class ScrewLoopCNiao {

    public int[][] generateMatrix(int n){
        int[][] arr = new int[n][n];
        int r1 = 0;
        int r2 = n - 1;
        int c1 = 0;
        int c2 = n - 1;
        int i = 1;
        while(r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; ++c){
                arr[r1][c] = i;
                ++i;
            }
            for(int r = r1 + 1; r < r2; ++r){
                arr[r][c2] = i;
                ++i;
            }
            for(int c = c2; c > c1; --c){
                arr[r2][c] = i;
                ++i;
            }
            for(int r = r2; r > r1; --r){
                arr[r][c1] = i;
                ++i;
            }
            ++r1;
            ++c1;
            --r2;
            --c2;
        }
        return arr;
    }
    
    public void test() {
        int n = 3; //3, 4
        int[][] res = generateMatrix(n);
        for(int[] arr : res){
            System.out.println(Arrays.toString(arr));
        }
        // n = 3
        // [1, 2, 3]
        // [8, 9, 4]
        // [7, 6, 5]

        // n = 4
        // [1, 2, 3, 4]
        // [12, 13, 14, 5]
        // [11, 16, 15, 6]
        // [10, 9, 8, 7]
    }

    public static void main(String[] args){
        ScrewLoopCNiao obj = new ScrewLoopCNiao();
        obj.test();
    }
}
