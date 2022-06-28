package hash_test.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    
    /**
     * 使用方式一 HashMap 将罗马数字转换为整数
     */
    public int romanToInt_1(String romanStr){
        if(romanStr == null || romanStr.length() == 0){
            return 0;
        }
        Map<Character, Integer> str2int = new HashMap<Character, Integer>();
        str2int.put('I', 1);
        str2int.put('V', 5);
        str2int.put('X', 10);
        str2int.put('L', 50);
        str2int.put('C', 100);
        str2int.put('D', 500);
        str2int.put('M', 1000);
        int ans = 0; //输出的结果
        for(int i = 0; i < romanStr.length() - 1; ++i){
            if(str2int.get(romanStr.charAt(i)) < str2int.get(romanStr.charAt(i + 1))){
                ans -= str2int.get(romanStr.charAt(i));
            }else{
                ans += str2int.get(romanStr.charAt(i));
            } 
        }
        ans += str2int.get(romanStr.charAt(romanStr.length() - 1));
        return ans;
    }

    /**
     * 使用方式二 自定义哈希 将罗马数字转换为整数
     */
    public int romanToInt_2(String romanStr){
        if(romanStr == null || romanStr.length() == 0){
            return 0;
        }
        int[] str2int = {100, 500, 0, 5, 0, 10, 1, 0, 0, 50, 1000};
        int ans = 0;
        for(int i = 0; i < romanStr.length() - 1; ++i){
            //(romanStr.charAt(i) - 67) & 0xF 得到 str2int 的数组索引
            int a = str2int[(romanStr.charAt(i) - 67) & 0xF];
            int b = str2int[(romanStr.charAt(i + 1) - 67) & 0xF];
            if(a < b){
                ans -= a;
            }else{
                ans += a;
            }
        }
        ans += str2int[(romanStr.charAt(romanStr.length() - 1) - 67) & 0xF];
        return ans;
    }

    public void test() {
        System.out.println("result_1 -> " + romanToInt_1("MCMXCIV"));
        //result_1 -> 1994
        System.out.println("result_2 -> " + romanToInt_2("MCMXCIV"));
        //result_2 -> 1994
    }

    public static void main(String[] args){
        RomanToInteger obj = new RomanToInteger();
        obj.test();
    }
}
