package advanced;

public class JumpGame {

    public boolean canJump(int[] nums){
        if(nums == null || nums.length == 0){
            return true;
        }
        int n = nums.length;
        int ans = 0; //每次可达的最大下标的索引
        for(int i = 0; i < n; ++i){
            if(ans >= i){
                ans = Math.max(ans, i + nums[i]);
                // 判断放到这里也可以
                // if(ans >= n - 1){
                //     return true;
                // }
            }
        }
        if(ans >= n - 1){
            return true;
        }
        return false;
    }
    
    public void test(){
        int[] arr = new int[] {2, 3, 1, 1, 4};
        boolean res = canJump(arr);
        System.out.println("result-> " + res); //result-> true
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        game.test();
    }
}
