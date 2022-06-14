package list_test.merge_ordered_list;

/**
 * 合并有序链表
 */
public class MergeOrderedList {

    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2){
        
        //定义一个哑节点(空节点)
        ListNode p = new ListNode(-1);
        
        //head 一直是头结点指针, 指向链表第一个节点的地址, 
        //所以遍历时保持不动, 动的是 p 指针
        ListNode head = p;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //如果 l1 == null, 那么 l2 肯定不为 null, 那么将 l2 加入到 p 链表中
        p.next = (l1 == null ? l2 : l1); 
        return head.next;
    }

    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return (l1 == null)? l2 : l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        }
    }

    public void test_1() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        a1.next = a2;
        a2.next = a4;
        b1.next = b3;
        b3.next = b4;

        ListNode res_1 = mergeTwoLists_1(a1, b1);
        Utils.printListNode(res_1);
        //1       1       2       3       4       4
    }

    public void test_2() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        a1.next = a2;
        a2.next = a4;
        b1.next = b3;
        b3.next = b4;

        ListNode res_2 = mergeTwoLists_2(a1, b1);
        Utils.printListNode(res_2);
    }

    public static void main(String[] args){
        MergeOrderedList obj = new MergeOrderedList();
        obj.test_1();
        obj.test_2();
        // 1       1       2       3       4       4
        // 1       1       2       3       4       4
    }
}
