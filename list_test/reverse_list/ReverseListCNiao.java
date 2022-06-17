package list_test.reverse_list;

import java.util.ArrayList;
//import java.util.Collections;

public class ReverseListCNiao {
    
    /**
     * 方式一 : 利用辅助空间翻转链表
     */
    public ListNode reverseList_1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //1. 将链表的内容拷贝到动态数组中
        //创建动态数组
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode p = head;
        //这里不能使用 while(p.next != null) 来判断, 因为如果 p.next == null
        //会导致 arr.add(p.val) 无法执行, 即 p.val 没有被添加到 arr 里
        while(p != null){
            arr.add(p.val);
            p = p.next;
        }

        //2. 使用系统 API 将动态数组中的内容反转
        //Collections.reverse(arr);
        
        //3. 将动态数组中的内容拷贝回链表中
        p = head;
        for(int i = 0; i < arr.size(); ++i){
            p.val = arr.get(i);
            p = p.next;
        }

        return head;
    }

    /**
     * 方式二 : 利用迭代翻转链表
     */
    public ListNode reverseList_2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null; //前面的结点
        ListNode cur = head; //当前的结点
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre; //这是关键的步骤
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 方式三 : 使用递归实现翻转链表
     */
    public ListNode reverseList_3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = reverseList_3(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public void test_func1() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode res_1 = reverseList_1(a1);
        Utils.printListNode(res_1);
    }

    public void test_func2() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode res_2 = reverseList_2(a1);
        Utils.printListNode(res_2);
    }

    public void test_func3() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode res_3 = reverseList_3(a1);
        Utils.printListNode(res_3);
    }

    public static void main(String[] args){
        ReverseListCNiao obj = new ReverseListCNiao();
        //obj.test_func1();   //5 4 3 2 1
        //obj.test_func2();   //5 4 3 2 1
        obj.test_func3();     //5 4 3 2 1
    }
}
