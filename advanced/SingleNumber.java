package advanced;

public class SingleNumber {

    public int singleNumber(int[] nums){
        int n = 0;
        for(int i : nums){
            n ^= i;
        }
        return n;
    }
    
    public void test(){
        int [] arr = new int[]{4, 1, 2, 1, 2};
        int res = singleNumber(arr);
        System.out.println("result -> " + res);
        //result -> 4
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.test();
    }
}
