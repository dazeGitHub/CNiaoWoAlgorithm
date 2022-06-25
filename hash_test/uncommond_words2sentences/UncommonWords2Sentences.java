package hash_test.uncommond_words2sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UncommonWords2Sentences {

    public String[] uncommonFromSentences(String A, String B){
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");
        List<String> res = new ArrayList<String>(); //res 是最后返回的结果集
        for(String s : splitA){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : splitB){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            if(map.get(entry.getKey()) == 1){
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[]{}); //<T> T[] toArray(T[] a)
    }
    
    public void test() {
        String a = "aa aa bb cc";
        String b = "bb bb bb dd";
        String[] res = uncommonFromSentences(a, b);
        for(String s : res){
            System.out.println(s);
        }
        //cc
        //dd
    }

    public static void main(String[] args){
        UncommonWords2Sentences obj = new UncommonWords2Sentences();
        obj.test();
    }
}
