package array_test.brackets_matching;

import java.util.HashMap;
import java.util.Stack;

public class BracketsMatching {

    public boolean isValid(String str){
        if(str == null || "".equals(str)){
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < str.length(); ++i){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character stackEle = stack.pop();
                if(map.get(c) != stackEle){
                    return false;
                }
            }
        }
        //如果栈里还有元素, 说明没有匹配完, 返回 false, 否则返回 true,
        //例如只有左括号没有右括号, 那么 stack 中就会有很多左括号, 
        //所以结尾要判断 stack 是否为空
        return stack.isEmpty() ? true : false; 
    }

    public void test() {
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("([)]"));   //false
        System.out.println(isValid("{[]}"));   //true
    }

    public static void main(String[] args){
        BracketsMatching obj = new BracketsMatching();
        obj.test();
    }
}