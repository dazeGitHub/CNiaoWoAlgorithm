package string_test;

public class ValidPalindrome {

    public boolean isPalindrome(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(str.charAt(i))){
                ++i;
            }
            while(i < j && !Character.isLetterOrDigit(str.charAt(j))){
                --j;
            }
            if(i < j){
                if(
                    Character.toLowerCase(str.charAt(i)) 
                    != Character.toLowerCase(str.charAt(j))
                ){
                    return false;
                }
            }
            ++i;
            --j;
        }
        return true;
    }
    
    public void test() {
        System.out.println("result -> " + isPalindrome("A man, a plan, a canal: Panama"));
        //result -> true
    }

    public static void main(String[] args){
        ValidPalindrome obj = new ValidPalindrome();
        obj.test();
    }
}
