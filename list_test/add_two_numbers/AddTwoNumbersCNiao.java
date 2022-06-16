package list_test.add_two_numbers;

public class AddTwoNumbersCNiao {
    
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2){

        ListNode p = null;  //结果链表的指针
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;

        while(a != null || b != null){   //遍历 a 和 b 直到都遍历完
            //如果两个链表不一样长, 那么 a 或 b 可能会出现 null 的情况
            int val = (a == null? 0 : a.val) + (b == null? 0 : b.val) + carry;
            carry = (val >= 10 ? 1 : 0);
            val = val % 10;
            p = (a == null? b : a);
            p.val = val;
            a = (a == null? null : a.next);
            b = (b == null? null : b.next);
            p.next = (a == null? b : a); //将两个不一样长的节点串联起来
        }

        //处理进位
        if(carry > 0){ //此时 a 和 b 都不为 null, 但是 p.next 必定为 null
            p.next = new ListNode(1);
        }

        //这里直接传 l1 的原因是, 前面首次执行 p = (a == null? b : a); 时
        //假定形参 l1 不为 null, 那么 a 肯定不为 null
        //那么新链表的首个指针就是 l1, 所以直接返回 l1 即可
        return l1;
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2){
        //因为每个函数都需要进位, 所以新加一个函数, 让 add() 函数处理真正的逻辑
        //add() 函数的第三个参数就是当前位数
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode a, ListNode b, int carry){
        if(a == null && b == null){ //递归的终止条件
            return (carry > 0)? new ListNode(1) : null;
        }

        //如果 a 或 b 为 null, 那么创建一个 val == 0 的 ListNode, 从而不影响后边的相加运算
        a = (a == null? new ListNode(0) : a);
        b = (b == null? new ListNode(0) : b);

        int val = a.val + b.val + carry;
        carry = (val >= 10 ? 1 : 0);
        val %= 10;
        a.val = val;
        a.next = add(a.next, b.next, carry);
        return a;
    } 

    public void test_func1_1() {
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

        ListNode res = addTwoNumbers_1(a2, b5);
        Utils.printListNode(res);
    }

    public void test_func1_2() {
        ListNode a2 = new ListNode(2);
        ListNode a4 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        ListNode b5 = new ListNode(5);
        ListNode b6 = new ListNode(6);
        ListNode b4 = new ListNode(4);
        ListNode b8 = new ListNode(8);

        a2.next = a4;
        a4.next = a3;

        b5.next = b6;
        b6.next = b4;
        b4.next = b8;

        ListNode res = addTwoNumbers_1(a2, b5); //addTwoNumbers_1(null, b5);
        Utils.printListNode(res);
    }

    public void test_func2() {
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

        ListNode res = addTwoNumbers_2(a2, b5);
        Utils.printListNode(res);
    }

    public static void main(String[] args){
        AddTwoNumbersCNiao obj = new AddTwoNumbersCNiao();
        //obj.test_func1_1();     //7       0       8
        //obj.test_func1_2();     //7       0       8       8
        obj.test_func2();         //7       0       8
    }
}
