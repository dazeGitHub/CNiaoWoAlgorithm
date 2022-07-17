package advanced;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhone {

    //使用哈希表比较重, 所以这里使用 String 数组即可            
    private static final String[] letterMap = 
                  //2      3      4      5      6      7       8       9
        {"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits){
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        dfs(res, digits, new StringBuilder(), 0);
        return res;
    }

    // "234"    abc     def     ghi
    // "ae"
    //
    // res 是各种可能性的集合, str 是传入的数字字符串, 
    // tmp 是每次拼接的结果, index 表示当前处理的是哪个数字, 控制了循环的层数(递归的次数)
    // 例如如果传入的是 234, 那么默认 index 就是 0, 即第一个数字 2 的索引
    private void dfs(List<String> res, String digits, StringBuilder tmp, int index){
        if(index == digits.length()){ //处理完了, 保存到 res 中
            res.add(tmp.toString());
            return;
        }
        //初始时 digits 是 "23", index 是 0, 得到的 mapString 是 abc
        String mapString = letterMap[digits.charAt(index) - '0'];
        //依次遍历 abc 各个元素, 先 append 到 tmp 中, 再进行 dfs, 再从 tmp 中删除该元素
        for(int i = 0; i < mapString.length(); ++i){ //abc
            tmp.append(mapString.charAt(i));
            dfs(res, digits, tmp, index + 1);
            tmp.deleteCharAt(tmp.length() - 1);

            //如果是使用 String, 那么可以这样写, 但比较耗费性能, 并且没体现 append 和 delete 过程
            //dfs(res, str, tmp + mapString.charAt(i), index + 1)
        }
    }
    
    public void test(){
        String str = "23";
        List<String> res = letterCombinations(str);
        System.out.println(res); //[ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhone phone = new LetterCombinationsOfPhone();
        phone.test();
    }
}
