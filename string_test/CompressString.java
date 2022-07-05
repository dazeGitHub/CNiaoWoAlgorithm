package string_test;

public class CompressString {
    
    public String compressString(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        int n = str.length();
        int left = 0;
        int right = 0;
        String res = "";
        while(left < n){
            while(right < n && str.charAt(left) == str.charAt(right)){
                ++right;
            }
            res = res + str.charAt(left) + (right - left);
            left = right;
        }
        if(res.length() >= str.length()){
            return str;
        }
        return res; 
    }

    public void test() {
        String str = "aabcccccaa";
        System.out.println("result ->" + compressString(str));
        //result ->a2b1c5a2
    }

    public static void main(String[] args){
        CompressString obj = new CompressString();
        obj.test();
    }
}
