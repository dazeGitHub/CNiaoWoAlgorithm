package list_test.delete_back_n_node;

public class RemoveNthFromEnd {
    
    public ListNode removeNthFromEnd_1(ListNode head, int n){
        if(head == null || n < 0){
            return head;
        }

        ListNode p = new ListNode(-1); //创建一个哑节点
        p.next = head;  //让哑节点变为头节点
        ListNode cur = p;
        int k = 0;      //总链表的长度
        while(cur.next != null){ //加了哑节点后这样判断是准确的
            cur = cur.next;
            ++k;
        }
        if(k < n){
            return head;
        }
        
        int num = k - n;
        cur = p;

        //因为加了哑节点, 所以最终得到的 cur 节点就是倒数第 n 个节点前面的节点
        //那么执行 cur.next = cur.next.next 正好可以删除倒数第 n 个节点
        while(num > 0){ 
            cur = cur.next;
            --num;
        }
        cur.next = cur.next.next;
        return p.next;
    }

    public ListNode removeNthFromEnd_2(ListNode head, int n){
        if(head == null || n < 0){
            return head;
        }
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode a = p;
        ListNode b = p;

        while(n > 0 && b != null){
            --n;
            b = b.next;
        }
        if(b == null){
            return head; //如果 n 大于 链表节点数, 那么 b == null, 直接返回 head
        }
        while(b.next != null){
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;
        return p.next;
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

        ListNode res = removeNthFromEnd_1(a1, 2);
        Utils.printListNode(res); //1 2 3 5
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

        ListNode res = removeNthFromEnd_2(a1, 2);
        Utils.printListNode(res);
    }

    public static void main(String[] args){
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        obj.test_func1(); //1 2 3 5
        obj.test_func2(); //1 2 3 5
    }
}
