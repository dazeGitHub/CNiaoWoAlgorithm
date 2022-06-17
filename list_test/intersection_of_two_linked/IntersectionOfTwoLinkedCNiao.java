package list_test.intersection_of_two_linked;

public class IntersectionOfTwoLinkedCNiao {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a != null)? a.next : headB;
            b = (b != null)? b.next : headA;
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

        ListNode res = getIntersectionNode(a4, b5);
        System.out.println("result -> " + res.val); //result -> 8
    }

    public static void main(String[] args){
        IntersectionOfTwoLinkedCNiao obj = new IntersectionOfTwoLinkedCNiao();
        obj.test(); //8       4       5
    }
}
