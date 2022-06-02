package array_test.divide_candy;

import java.util.Arrays;

public class DivideCandyCNiao {

    //方式一 : 根据每趟统计
    public int[] distributeCandies_1(int candies, int num_people){
        if(candies <=0 || num_people <= 0){
            return new int[0];
        }
        int[] res = new int[num_people];
        int times = 0; // 第几趟
        while(candies > 0){
            for(int i = 0; i < num_people; ++i){
                int n = times * num_people + i + 1; //当前分给索引为 i 的小朋友的糖果数
                if(candies > n){    //剩余糖果还够分
                    res[i] += n;
                    candies -= n;
                }else{              //剩余糖果不够分
                    res[i] += candies;
                    candies = 0;
                }
            }
            ++ times;
        }
        return res;
    }

    //方式二 : 取模计算
    public int[] distributeCandies_2(int candies, int num_people){
        if(candies <=0 || num_people <= 0){
            return new int[0];
        }
        var i = 0;
        int[] res = new int[num_people];
        while(candies > 0){
            res[i % num_people] += Math.min(i + 1, candies);
            candies -= Math.min(i + 1, candies);
            ++i;
        }
        return res;
    }

    public void test() {
        int[] res_1 = distributeCandies_1(28, 3);
        System.out.println("result_1 -> " + Arrays.toString(res_1));

        int[] res_2 = distributeCandies_2(28, 3);
        System.out.println("result_2 -> " + Arrays.toString(res_2));
    }

    public static void main(String[] args){
        DivideCandyCNiao obj = new DivideCandyCNiao();
        obj.test();
    }
}
