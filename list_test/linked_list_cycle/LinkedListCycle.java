package list_test.linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    
    /**
     * 使用 set 判断链表是否有环
     */
    public boolean hasCycle_1(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 使用快慢指针判断链表是否有环
     */
    public boolean hasCycle_2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode i = head;       //fastPointer
        ListNode j = head.next;  //slowPointer
        while(j != null && j.next != null){
            if(i == j){
                return true;
            }
            i = i.next;
            j = j.next.next;
        }
        return false;
    }

    public void test() {
        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(2);
        ListNode a0 = new ListNode(0);
        ListNode a4 = new ListNode(-4);

        a3.next = a2;
        a2.next = a0;
        a0.next = a4;
        a4.next = a2;

        boolean res_1 = hasCycle_1(a3);
        System.out.println("result_1 -> " + res_1);

        boolean res_2 = hasCycle_2(a3);
        System.out.println("result_2 -> " + res_2);
    }

    public static void main(String[] args){
        LinkedListCycle obj = new LinkedListCycle();
        obj.test(); 
        //result_1 -> true  
        //result_2 -> true
    }
}
