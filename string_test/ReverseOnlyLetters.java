package string_test;

public class ReverseOnlyLetters {
    
    public String reverseOnlyLetters(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder tmp = new StringBuilder();
        int j = str.length() - 1;
        for(int i = 0; i < str.length(); ++i){
            if(Character.isLetter(str.charAt(i))){
                while(!Character.isLetter(str.charAt(j))){
                    --j;
                }
                tmp.append(str.charAt(j));
                --j;
            }else{
                tmp.append(str.charAt(i));
            }
        }
        return tmp.toString();
    }

    public void test() {
        System.out.println("result:" + reverseOnlyLetters("test-cainiao=wo-Q!"));
        //result:Qowo-ainiact=se-t!
    }

    public static void main(String[] args){
        ReverseOnlyLetters obj = new ReverseOnlyLetters();
        obj.test();
    }
}
