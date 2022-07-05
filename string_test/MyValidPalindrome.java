package string_test;

public class MyValidPalindrome {

    public boolean isPalindrome(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(!Character.isLetterOrDigit(str.charAt(i))){
                ++i;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(j))){
                --j;
                continue;
            }
            
            if(
                Character.toLowerCase(str.charAt(i)) 
                != Character.toLowerCase(str.charAt(j))
            ){
                return false;
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
        MyValidPalindrome obj = new MyValidPalindrome();
        obj.test();
    }
}
