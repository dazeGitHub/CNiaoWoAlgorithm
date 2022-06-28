package hash_test.longest_str_without_repo;

import java.util.HashMap;
import java.util.Map;

public class LongestStrWithoutRepo {

    public int lengthOfLongestSubstring(String str){
        if(str == null || "".equals(str)){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        int res = 0;
        for(int right = 0; right < str.length(); ++right){
            if(map.containsKey(str.charAt(right))){
                left = Math.max(left, map.get(str.charAt(right)) + 1);
            }
            map.put(str.charAt(right), right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    
    public void test() {
        System.out.println("result -> " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("result -> " + lengthOfLongestSubstring("pwwkew"));
    }

    public static void main(String[] args){
        LongestStrWithoutRepo obj = new LongestStrWithoutRepo();
        obj.test();
    }
}
