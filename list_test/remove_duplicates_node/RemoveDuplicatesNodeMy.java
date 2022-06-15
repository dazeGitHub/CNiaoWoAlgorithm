package list_test.remove_duplicates_node;

public class RemoveDuplicatesNodeMy {

    public ListNode deleteDuplicates(ListNode head){
        ListNode p = head;
        while(p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
    
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a1_2 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a3_2 = new ListNode(3);

        a1.next = a1_2;
        a1_2.next = a2;
        a2.next = a3;
        a3.next = a3_2;

        ListNode res = deleteDuplicates(a1);
        Utils.printListNode(res); //1       2       3
    }

    public static void main(String[] args){
        RemoveDuplicatesNodeMy obj = new RemoveDuplicatesNodeMy();
        obj.test(); 
    }
}
