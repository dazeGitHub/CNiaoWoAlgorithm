package advanced;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;
        
        Node(int key, int value, Node pre, Node next){
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private final Node head = new Node(-1, -1, null, null);
    private final Node tail = new Node(-1, -1, null, null);
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node tmp = map.get(key);
            remove(tmp);
            insert(tmp);
            return tmp.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){ //如果包含, 那么就是更新操作, 先删除再插入 Node
            Node tmp = map.get(key);
            map.remove(key);
            remove(tmp);
        }else{
            if(map.size() == this.capacity){
                Node tmp = getLast();
                map.remove(tmp.key);
                remove(tmp);
            }
        }
        Node node = new Node(key, value, null, null);
        map.put(key, node);
        insert(node);
    }

    /**
     * 双链表的插入
     * head <-> 1 <-> 2 <-> 3 <-> tail
     */
    private void insert(Node node){
        node.next = this.head.next;
        this.head.next.pre = node;
        node.pre = this.head;
        this.head.next = node;
    }

    /**
     * 双链表的移除
     */
    private void remove(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
    }

    /**
     * 获取 LRUCache 中最后一个节点
     */
    private LRUCache.Node getLast(){
        //后面的判断是我自己加的
        if(this.head == this.tail || this.head.next == this.tail){
            return null;
        }
        return this.tail.pre;
    }

    public static void test(){

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        
        //这次 cache.get(1) 后会将 1 放到前面, 2 会到最后, 从前到后 : 1 -> 2
        System.out.println("get 1 -> " + cache.get(1));
        // get 1 -> 1

        //因为 cache 的总容量是 2, 所以 put 3 时会把最后的 2 删掉, 从前到后 : 3 -> 1
        cache.put(3, 3);

        System.out.println("get 2 -> " + cache.get(2));
        // get 2 -> -1

        //因为 cache 的总容量是 2, 所以 put 4 时会把最后的 1 删掉, 从前到后 : 4 -> 3
        cache.put(4, 4);
        System.out.println("get 1 -> " + cache.get(1));
        // get 1 -> -1

        //这次 cache.get(3) 后会将 3 放到前面, 4 会到最后, 从前到后 : 3 -> 4
        System.out.println("get 3 -> " + cache.get(3));
        // get 3 -> 3

        //这次 cache.get(4) 后会将 4 放到前面, 3 会到最后, 从前到后 : 4 -> 3
        System.out.println("get 4 -> " + cache.get(4));
        // get 4 -> 4
    }

    public static void main(String[] args) {
        test();
    }
}
