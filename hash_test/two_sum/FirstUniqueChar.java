package hash_test.two_sum;

public class FirstUniqueChar {

    public int firstUniqChar(String str){
        if(str == null || str.length() == 0){
            return -1;
        }
        //因为就 26 个字母, 所以这里可以不用创建哈希表
        //每个字符对应下标, map 的每个元素值就是字符出现的频率
        int[] map = new int[26];
        char[] charArr = str.toCharArray();
        for(char c : charArr){
            map[c - 'a'] ++;
        }
        for(int i = 0; i < charArr.length; ++i){
            if(map[charArr[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    
    public void test() {
        String s = "hellocainiaowo";
        int res = firstUniqChar(s);
        System.out.println("result -> " + res);
        //result -> 0
    }

    public static void main(String[] args){
        FirstUniqueChar obj = new FirstUniqueChar();
        obj.test();
    }
}
