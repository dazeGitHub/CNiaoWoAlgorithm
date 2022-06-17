package list_test.intersection_of_two_linked;

public class Utils {

    public static void printListNode(ListNode head){
        if(head == null){
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val).append("\t");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
