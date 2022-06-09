package array_test.screw_loop;

import java.util.Arrays;

/**
 * 螺旋遍历
 */
public class ScrewLoopMy {

    public int[][] generateScrew(int n){

        if(n == 1){
            return new int[][]{{1}};
        }

        int[][] arr = new int[n][n];
        int curLoopFirstEle = 1;    //当前圈的第一个值
        int screwEleValue = curLoopFirstEle;
        int leftIndex = 0;
        int topIndex = 0;
        int rightIndex = n - 1;
        int bottomIndex = n - 1;

        int rightTopValue = curLoopFirstEle + (rightIndex - leftIndex);
        int rightBottomValue = curLoopFirstEle + (bottomIndex - topIndex + rightIndex - leftIndex);
        int leftBottomValue = curLoopFirstEle + (bottomIndex - topIndex + (rightIndex - leftIndex) * 2);
        int leftTopValue = curLoopFirstEle + ( (bottomIndex - topIndex + rightIndex - leftIndex) * 2 - 1); //当前圈最后一个元素, 不等于当前圈第一个元素

        while(screwEleValue <= n * n){

            System.out.println("rightTopValue = " + rightTopValue 
            + " rightBottomValue = " + rightBottomValue
            + " leftBottomValue = " + leftBottomValue 
            + " leftTopValue = " + leftTopValue);
            if(
                screwEleValue == rightTopValue
            ){          //1,2
                for(int j = rightIndex - 1; j >= leftIndex; --j){ 
                    arr[topIndex][j] = screwEleValue - (rightIndex - j);
                }
            }else if(  //3, 4
                screwEleValue == rightBottomValue
            ){
                for(int j = bottomIndex - 1; j >= topIndex; --j){
                    arr[j][rightIndex] = screwEleValue - (bottomIndex - j);
                }
            }else if(   //5,6
                screwEleValue == leftBottomValue
            ){
                for(int j = leftIndex + 1; j <= rightIndex; ++j){
                    arr[bottomIndex][j] = screwEleValue - (j - leftIndex);
                }
            }else if(
                screwEleValue == leftTopValue
            ){     //7, 8
                for(int j = topIndex + 1; j <= bottomIndex; ++j){
                    arr[j][leftIndex] = leftTopValue - (j - topIndex - 1);
                }
            }

            if(screwEleValue == n * n){
                arr[bottomIndex][leftIndex] = screwEleValue;
            }

            ++screwEleValue;
            
            if(
                screwEleValue > curLoopFirstEle + (4 * n - 4) - 1
            ){      //里边的圈
                curLoopFirstEle = screwEleValue;
                ++ leftIndex;
                ++ topIndex;
                -- rightIndex;
                -- bottomIndex;
                
                rightTopValue = curLoopFirstEle + (rightIndex - leftIndex);
                rightBottomValue = curLoopFirstEle + (bottomIndex - topIndex + rightIndex - leftIndex);
                leftBottomValue = curLoopFirstEle + (bottomIndex - topIndex + (rightIndex - leftIndex) * 2);
                leftTopValue = curLoopFirstEle + ( (bottomIndex - topIndex + rightIndex - leftIndex) * 2 - 1);
            }
        }
        return arr;
    }
    
    public void test() {
        int n = 3; //3, 4
        int[][] resultArr = generateScrew(n);
        for(int[] arr : resultArr){
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
        ScrewLoopMy obj = new ScrewLoopMy();
        obj.test();
    }
}
