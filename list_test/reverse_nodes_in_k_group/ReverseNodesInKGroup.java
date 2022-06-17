package list_test.reverse_nodes_in_k_group;

public class ReverseNodesInKGroup {

    private ListNode reverse(ListNode head){
        ListNode cur = head; //当前的结点
        ListNode pre = null; //前面的结点
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k <= 0){
            return head;
        }
        ListNode dummy = new ListNode(-1); //增加一个哑结点
        dummy.next = head;
        ListNode p = dummy; //这个 p 结点是用来遍历用的

        int n = k;
        while(p.next != null){
            ListNode tmp = p;
            while(tmp != null && tmp.next != null && n > 0){
                tmp = tmp.next;
                --n;
            }
            if(n == 0){   //翻转链表
                ListNode nextNode = tmp.next;
                ListNode tail = p.next;
                tmp.next = null;
                p.next = reverse(tail);
                tail.next = nextNode;
                //准备下一次遍历的条件
                p = tail; //将 p 设置为翻转后的链表的尾结点
                n = k;
            }else{        //直接返回
               break;
            }
        }
        return dummy.next; //返回 哑结点.next
    }

    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        ListNode res = reverseKGroup(a1, 3);
        Utils.printListNode(res); 
        //3       2       1       6       5       4       7
    }

    public static void main(String[] args){
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        obj.test();
    }
}
