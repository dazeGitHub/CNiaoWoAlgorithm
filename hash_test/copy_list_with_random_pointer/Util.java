package hash_test.copy_list_with_random_pointer;

public class Util {
    
    public static void printListNodeRandom(ListNodeRandom head){
        while(head != null){
            if(head.random == null){
                System.out.print(head.val + "\t");
            }else{
                System.out.print(head.val + "(R=" + head.random.val + ")" + "\t");
            }
            head = head.next;
        }
        System.out.println("\n");
    }
}
