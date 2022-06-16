package list_test.add_two_numbers;

public class AddTwoNumbersMy {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1 != null && p2 != null){
            int res = p1.val + p2.val + carry;
            int singleRes = 0;
            if(res >= 10){
                singleRes = res - 10;
                carry = 1;
            }else{
                singleRes = res;
                carry = 0;
            }
            p1.val = singleRes;
            p1 = p1.next;
            p2 = p2.next;
        }
        return l1;
    }

    public void test() {
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        ListNode b5 = new ListNode(5);
        ListNode b6 = new ListNode(6);
        ListNode b4 = new ListNode(4);

        a2.next = a4;
        a4.next = a3;
        b5.next = b6;
        b6.next = b4;

        ListNode res = addTwoNumbers(a2, b5);
        Utils.printListNode(res);
    }

    public static void main(String[] args){
        AddTwoNumbersMy obj = new AddTwoNumbersMy();
        obj.test(); 
    }
}
