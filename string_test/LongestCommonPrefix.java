package string_test;

public class LongestCommonPrefix {
    
    public String longestCommonPrefix_1(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i= 1; i < strs.length; ++i){
            prefix = caclCommonPrefix(prefix, strs[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix_2(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0]; //初始时取第一个字符串
        for(int i = 0; i < prefix.length(); ++i){ //第 i 列
            char c = prefix.charAt(i);
            for(int j = 1; j < strs.length; ++j){ //第 j 个字符串
                //如果第 j 个字符串的长度比 i 小
                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    //计算两个字符串的公共前缀
    private String caclCommonPrefix(String s1, String s2){
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while(index < len && s1.charAt(index) == s2.charAt(index)){
            ++index;
        }
        return s1.substring(0, index);
    }

    public void test() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println("result -> " + longestCommonPrefix_1(strs)); //result -> fl
        System.out.println("result -> " + longestCommonPrefix_2(strs)); //result -> f1
    }

    public static void main(String[] args){
        LongestCommonPrefix obj = new LongestCommonPrefix();
        obj.test();
    }
}
