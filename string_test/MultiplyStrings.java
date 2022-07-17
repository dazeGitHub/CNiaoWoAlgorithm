package string_test;

public class MultiplyStrings {

    public String multiply(String num1, String num2){
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String res = "";
        int k = 0;
        //因为是从第一位开始处理的, 所以将 num1 执行 reverse() 取反 
        //这样每次 newS1.charAt(i) 得到的都是最低位的数字
        String newS1 = new StringBuilder(num1).reverse().toString();
        for(int i = 0; i < newS1.length(); ++i){
            String num = "" + newS1.charAt(i);
            //numlti(num2, num) 就是将 num2 和 num 进行相乘
            //乘完后使用 fill() 来补 0, 变量 k 表示补多少个 0
            res = add(res, fill(multi(num2, num), k));
            ++k;
        }
        return res;
    }

    /**
     * 将字符串 s1 和 只包含单个字母的字符串 s2 相乘
     */
    private String multi(String s1, String s2){
        int j = s2.charAt(0) - 48;
        String newS2 = new StringBuilder(s1).reverse().toString();
        int carry = 0;   //表示进位
        String res = "";
        for(int i = 0; i < newS2.length(); ++i){
            int tmp = newS2.charAt(i) - 48;
            tmp = tmp * j + carry;
            carry = tmp / 10; //tmp 超出 10 的部分是 carry, 个位的部分是 tmp % 10
            res = "" + (tmp % 10) + res;
        }
        if(carry > 0){ //最后还有进位
            res = "" + carry + res;
        }
        return res;
    }

    /**
     * 为字符串 n 后面补 i 个 0
     * @param n
     * @param k
     * @return
     */
    private String fill(String n, int i){
        if("0".equals(n)){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append(n);
        for(int k = 0; k < i; ++k){
            res.append("0");
        }
        return res.toString();
    }
    
    private String add(String s1, String s2){
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        String res = "";
        while(i >= 0 || j >= 0){ //两个字符串可能不一样长, 所以 i 或 j 一个为 -1 时, 另一个可能 >= 0
            int val_i = (i >= 0) ? s1.charAt(i) - 48 : 0;
            int val_j = (j >= 0) ? s2.charAt(j) - 48 : 0;
            int tmp = val_i + val_j + carry;
            carry = tmp / 10;
            res = "" + (tmp % 10) + res;
            --i;
            --j;
        }
        if(carry > 0){
            res = "1" + res;
        }
        return res;
    }

    public void test() {
        System.out.println("result -> " + multiply("123", "456"));
        //result -> 56088
    }

    public static void main(String[] args){
        MultiplyStrings obj = new MultiplyStrings();
        obj.test();
    }
}
