package string_test;

public class LongestPalindromicSubstr {
    
    public String longestPalindrome(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        //标记 str 中最长回文子串的 起始 和 结束 位置
        int start = 0;
        int end = 0;
        for(int i = 0; i < str.length(); ++i){
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private int expandAroundCenter(String str, int left, int right){
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            --left;
            ++right;
        }
        //本来是 (right - (left - 1)) = right - left + 1, 但是最后执行了 --left 和 ++right
        //所以还需要再减去 2, 即 right - left + 1 - 2 = right - left - 1
        return (right - left - 1);
    }

    public void test(){
        System.out.println(longestPalindrome("cbbbbbd"));
        String str = "babad";
        String res = longestPalindrome(str);
        System.out.println(res);
        //bbbbb
        //aba
    }

    public static void main(String[] args){
        LongestPalindromicSubstr obj = new LongestPalindromicSubstr();
        obj.test();
    }
}
