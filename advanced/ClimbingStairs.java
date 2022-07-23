package advanced;

public class ClimbingStairs {

    //方式一 : 使用递归实现
    public int climbingStairs_1(int n){
        if(n <= 1){
            return 1;
        }
        //当 n = 2 时, 正好有 climbingStairs_1(0) + climbingStairs_1(1), 从而 if(n <= 1) 做为了递归出口
        return climbingStairs_1(n - 2) + climbingStairs_1(n - 1);
    }

    //方式二 : 使用动态规划实现
    public int climbingStairs_2(int n){
        if(n <= 1){
            return 1;
        }
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i <= n; ++i){
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }

    public void test(){
        int res_1 = climbingStairs_1(7);
        System.out.println("result_1 -> " + res_1); //result_1 -> 21

        int res_2 = climbingStairs_2(7);
        System.out.println("result_2 -> " + res_2); //result_2 -> 21
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.test();
    }
}