package hash_test.word_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String str){
        if(pattern == null || str == null){
            return (pattern == str)? true : false; //如果都是 null, 那么返回 true
        }
        int n = pattern.length();
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < n; ++i){
            char key = pattern.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(arr[i])){
                    return false;
                }
            }else{
                //map.values() 得到的是一个 Collection 集合, 查找的时间复杂度是 O(N), 
                //相当于也是一个循环, 整体的时间复杂度就是 O(N^2)
                //所以前面加一个 hashSet 优化时间, hashSet 是一个哈希表, 整体的时间复杂度就是 O(N) 了
                //map.values().contains(arr[i]) 
                
                //在 set 中遍历就是 O(1) 的操作了
                if(set.contains(arr[i])){
                    return false;
                }
                map.put(key, arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }
    
    public void test() {
        boolean res = wordPattern("abba", "dog cat cat dog");
        System.out.println("result -> " + res); //result -> true
    }

    public static void main(String[] args){
        WordPattern obj = new WordPattern();
        obj.test();
    }
}
