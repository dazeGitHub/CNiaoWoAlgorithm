package string_test;

public class ReverseWordsInString {
    
    public String reverseWords(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        StringBuilder sb = trimSpace(str); //过滤空格
        reverse(sb, 0, sb.length() - 1); //翻转整个字符串
        reverseEachWords(sb); //翻转字符串中的每个单词
        return sb.toString();
    }

    private StringBuilder trimSpace(String str){
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = str.length() - 1;
        //去掉开头的空格
        while(left <= right && str.charAt(left) == ' '){
            ++left;
        }
        //去掉结尾的空格
        while(left <= right && str.charAt(right) == ' '){
            --right;
        }
        //去掉每个单词中间多余的空格
        while(left <= right){
            char c = str.charAt(left);
            if(c != ' '){
                sb.append(c);
            }else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    /**
     * 翻转整个字符串
     */
    private void reverse(StringBuilder sb, int left, int right){
        while(left <= right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            ++left;
            --right;
        }
    }

    /**
     * 翻转每个单词
     */
    private void reverseEachWords(StringBuilder sb){
        int n = sb.length();
        int left = 0;  //单词的左边界
        int right = 0; //单词的右边界
        while(left < n){
            while(right < n && sb.charAt(right) != ' '){
                ++right;
            }
            reverse(sb, left, right - 1);
            left = right + 1;
            ++right;
        }
    }

    public void test() {
        String str = "   the   sky   is     blue    ";
        System.out.println("result->" + reverseWords(str));
        //result->blue is sky the
    }

    public static void main(String[] args){
        ReverseWordsInString obj = new ReverseWordsInString();
        obj.test();
    }
}
