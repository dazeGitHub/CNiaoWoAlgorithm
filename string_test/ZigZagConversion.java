package string_test;

/**
 * Z 字型变换
 */
public class ZigZagConversion {
    
    public String convert(String str, int numRows){
        if(str == null || str.length() == 0 || numRows <= 1){
            return str;
        }
        int n = str.length();
        int rows = Math.min(n, numRows); //如果字符串太短, 那么使用 n 而不是 numRows
        //初始化
        StringBuilder[] arr = new StringBuilder[rows];
        for(int i = 0; i < arr.length; ++i){
            arr[i] = new StringBuilder();
        }
        //遍历
        int j = 0;
        boolean isDown = false;
        StringBuilder res = arr[0];
        for(int i = 0; i < n; ++i){
            arr[j].append(str.charAt(i));
            if(j == 0 || j == numRows - 1){
                isDown = !isDown;
            }
            if(isDown){
                ++j;
            }else{
                --j;
            }
        }
        //将 arr 中的字母按行拼接
        for(int i = 1; i < arr.length; ++i){
            res.append(arr[i]);
        }
        return res.toString();
    }

    public void test() {
        String str = "1234567890abcdefg";
        String res = convert(str, 5);
        System.out.println("result:" + res);
        //
    }

    public static void main(String[] args){
        ZigZagConversion obj = new ZigZagConversion();
        obj.test();
    }
}
