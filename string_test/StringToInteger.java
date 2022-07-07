package string_test;

public class StringToInteger {

    //最大 32 位整数 1/10
    private static final int ONE_TENTH_MAX_VALUE = Integer.MAX_VALUE / 10;
    
    //最小 32 位整数 1/10
    private static final int ONE_TENTH_MIN_VALUE = Integer.MIN_VALUE / 10;

    public int myAtoi(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false; //是否负号
        //过滤开头空格
        while(i < n && str.charAt(i) == ' '){
            ++i;
        }
        //字符串中全是空格
        if(i == n){
            return 0;
        }
        //处理符号
        if(str.charAt(i) == '-'){
            is_negative = true;
        }
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            ++i;
        }
        //处理数字部分
        while(i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            int tmp = str.charAt(i) - '0'; // '0' 的 ascii 码是 48, 这里可以改为减去 48
            if(!is_negative && (res > ONE_TENTH_MAX_VALUE) || (res == ONE_TENTH_MAX_VALUE && tmp >= 7)){
                return Integer.MAX_VALUE;
            }
            if(is_negative && (-res < ONE_TENTH_MIN_VALUE) || (-res == ONE_TENTH_MIN_VALUE && tmp >= 8)){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp; //这里 + tmp 可能会溢出, 所以需要提前判断
            ++i;
        }
        if(is_negative){
            return -res;
        }
        return res;
    }

    public void test(){
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("  4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        // 42
        // -42
        // 4193
        // 0
        // -2147483648
    }

    public static void main(String[] args){
        StringToInteger obj = new StringToInteger();
        obj.test();
    }
}
