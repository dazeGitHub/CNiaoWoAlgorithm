package array_test.water_max_container;

public class WaterMyTest {

    public int maxArea(int[] height){
        if(height == null){
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int tempMaxArea = 0;
        while(i < j){
            int minHeight = Math.min(height[i], height[j]);
            tempMaxArea = Math.max(tempMaxArea, minHeight * (j - i));
            if(height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
        }
        return tempMaxArea;
    }

    public void test() {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(arr);
        System.out.println("result -> " + maxArea);
    }

    public static void main(String[] args){
        WaterMyTest obj = new WaterMyTest();
        obj.test();
    }
}
