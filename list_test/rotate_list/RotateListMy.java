package list_test.rotate_list;

public class RotateListMy {
    
    public ListNode rotateRight(ListNode head, int k){
        
        int totalCount = 0;
        ListNode emptyP = new ListNode(-1);
        emptyP.next = head;
        ListNode p = emptyP;

        while(p.next != null){
            ++totalCount;
            p = p.next;
        }
        p.next = emptyP.next; //形成一个环

        int n = ((k / totalCount) + 1) * totalCount;
        //m : 指针在正面移动的次数
        //k 是指针倒着移动的次数, 等同于正着移动 totalCount - k 次,
        //为了防止 totalCount - k 结果为负数, 那么加一个 n 补偿
        int m = n + (totalCount - k);    
        m %= totalCount;
        
        p = emptyP;
        while(m != 0){
            p = p.next;
            --m;
        }
        ListNode tempNext = p.next;
        p.next = null;
        return tempNext;
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

        int k = 2;
        ListNode res = rotateRight(a1, k);
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
        RotateListMy obj = new RotateListMy();
        obj.test_func1_1();
        //4       5       1       2       3
        obj.test_func1_2();
        //2       0       1
    }
}
