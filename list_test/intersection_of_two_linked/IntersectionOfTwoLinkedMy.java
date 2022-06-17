package list_test.intersection_of_two_linked;

public class IntersectionOfTwoLinkedMy {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            if(a == null){
                a = headB;
            }
            if(b == null){
                b = headA;
            }
            a = a.next;
            b = b.next;
        }
        
        return a;
    }

    public void test() {
        ListNode a4 = new ListNode(4);
        ListNode a1 = new ListNode(1);

        ListNode b5 = new ListNode(5);
        ListNode b0 = new ListNode(0);
        ListNode b1 = new ListNode(1);

        ListNode c8 = new ListNode(8);
        ListNode c4 = new ListNode(4);
        ListNode c5 = new ListNode(5);

        a4.next = a1;
        a1.next = c8;

        b5.next = b0;
        b0.next = b1;
        b1.next = c8;

        c8.next = c4;
        c4.next = c5;

        ListNode listNode = getIntersectionNode(a4, b5);
        Utils.printListNode(listNode);
    }

    public static void main(String[] args){
        IntersectionOfTwoLinkedMy obj = new IntersectionOfTwoLinkedMy();
        obj.test(); //8       4       5
    }
}
