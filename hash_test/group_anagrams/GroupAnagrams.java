package hash_test.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        for(String str : strs){
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String tmp = new String(ca);
            if(!map.containsKey(tmp)){
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(tmp, list);
            }else{
                map.get(tmp).add(str);
            }
        }
        for(String str : map.keySet()){
            res.add(map.get(str));
        }
        return res;
    }
    
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for(List<String> li : lists){
            System.out.println(li);
        }
        // [eat, tea, ate]
        // [bat]
        // [tan, nat]
    }

    public static void main(String[] args){
        GroupAnagrams obj = new GroupAnagrams();
        obj.test();
    }
}
