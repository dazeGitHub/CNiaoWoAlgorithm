package hash_test.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    
    public ListNodeRandom copyRandomList_1(ListNodeRandom head){
        if(head == null){
            return null;
        }
        ListNodeRandom p = head;

        //1. 第一步 : 在每个节点后创建一个新节点 : 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while(p != null){
            ListNodeRandom newNode = new ListNodeRandom(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;

        //2. 第二步 : 设置新节点的随机指针
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;

        //3. 第三步 : 断开 原链表 和 新链表
        //先创建一个哑节点
        ListNodeRandom dummy = new ListNodeRandom(-1);
        ListNodeRandom cur = dummy;
        //1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while(p != null){
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNodeRandom copyRandomList_2(ListNodeRandom head){
        if(head == null){
            return null;
        }
        Map<ListNodeRandom, ListNodeRandom> map = new HashMap<ListNodeRandom,ListNodeRandom>();
        ListNodeRandom p = head;
        while(p != null){
            ListNodeRandom newNode = new ListNodeRandom(p.val);
            map.put(p, newNode);
            p = p.next;
        }

        p = head;
        while(p != null){
            ListNodeRandom valueNode = map.get(p);
            if(p.next != null){
                valueNode.next = map.get(p.next);
            }
            if(p.random != null){
                valueNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }

    public void test() {
        ListNodeRandom a7 = new ListNodeRandom(7);
        ListNodeRandom a13 = new ListNodeRandom(13);
        ListNodeRandom a11 = new ListNodeRandom(11);
        ListNodeRandom a10 = new ListNodeRandom(10);
        ListNodeRandom a1 = new ListNodeRandom(1);
        a7.next = a13;
        a13.next = a11;
        a11.next = a10;
        a10.next = a1;
        a13.random = a7;
        a11.random = a1;
        a10.random = a11;
        a1.random = a7;

        ListNodeRandom res_1 = copyRandomList_1(a7);
        System.out.println("func_1:");
        Util.printListNodeRandom(res_1);
        // func_1:
        // 7       13(R=7) 11(R=1) 10(R=11)        1(R=7)

        ListNodeRandom res_2 = copyRandomList_2(a7);
        System.out.println("func_2:");
        Util.printListNodeRandom(res_2);
        // func_2:
        // 7       13(R=7) 11(R=1) 10(R=11)        1(R=7)
    }

    public static void main(String[] args){
        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        obj.test();
    }
}
