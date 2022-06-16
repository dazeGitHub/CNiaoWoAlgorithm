package list_test.rotate_list;

public class RotateListCNiao {
    
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || k <= 0){
            return head;
        }
        //定义一个哑结点
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode cur = p;
        ListNode slow = p;
        ListNode fast = p;
        int n = 0; //总结点个数, 这是为了之后计算 k % n
        while(cur.next != null){
            cur = cur.next;
            ++n;
        }
        if(n == 0 || k % n == 0){
            return head;
        }
        n = k % n;
        while(fast.next != null && n > 0){ //让 fast 指针向前移动 n 位
            fast = fast.next;
            --n;
        }
        while(fast.next != null){ //让快慢指针一起移动
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = p.next; //让 fast 指针的 next 指向 哑结点 的 next
        p.next = slow.next; //让 哑节点 的 next 指向 slow 指针的 next 
        slow.next = null;   //让 尾结点 的 next 置空
        return p.next;
    }

    public void test_func1_1() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode res = rotateRight(a1, 2);
        Utils.printListNode(res);
    }

    public void test_func1_2() {
        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        a0.next = a1;
        a1.next = a2;

        int k = 4;
        ListNode res = rotateRight(a0, k);
        Utils.printListNode(res);
    }

    public static void main(String[] args){
        RotateListCNiao obj = new RotateListCNiao();
        obj.test_func1_1();
        //4       5       1       2       3
        obj.test_func1_2();
        //2       0       1
    }
}
