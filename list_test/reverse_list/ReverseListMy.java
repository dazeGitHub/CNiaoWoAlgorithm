package list_test.reverse_list;

public class ReverseListMy {
    
    public ListNode reverseList(ListNode head){
        ListNode oldP = head;
        ListNode newP = head;
        ListNode nextOldP = head.next;
        while(nextOldP != null){
            oldP = nextOldP;
            nextOldP = oldP.next;
            oldP.next = newP;
            newP = oldP;
        }
        head.next = null;
        return newP;
    }

    public void test_1() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a4;
        a4.next = a5;
        a5.next = a3;

        ListNode res = reverseList(a1);
        Utils.printListNode(res);
    }

    public static void main(String[] args){
        ReverseListMy obj = new ReverseListMy();
        obj.test_1();
        //3       5       4       2       1
    }
}
