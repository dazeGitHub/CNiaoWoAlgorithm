package advanced;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists_1(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        //优先队列 PriorityQueue 默认是小根堆, 如果要实现大根堆, 那么可以使用 comparator 比较器来实现大根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;     //每次返回最小的
            }
        });
        //创建一个 dummy 哑节点, 做为最后的结果返回
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;       //这个 cur 是用做串联用的
        for(int i = 0; i < lists.length; ++i){
            ListNode head = lists[i];
            if(head != null){
                queue.add(head);    //将每个链表的头节点放到优先队列中
            }
        }
        //不断的从堆中取出元素, 放到 cur 节点后边
        while(queue.size() > 0){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            //如果取出的节点的下一个节点不为空, 那么将该下一个节点放到堆中, 保持堆中始终有 K 个元素
            if(node.next != null){
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode mergeKLists_2(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    //拆分链表数组
    private ListNode helper(ListNode[] lists, int begin, int end){
        if(begin == end){
            return lists[begin]; //只有一个链表时直接返回
        }
        //取 list0 - list5 的中间节点 list2
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(lists, begin, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    //合并两个链表 (直接调用使用递归的方式合并两个有序链表的代码即可)
    private ListNode merge(ListNode a, ListNode b){
        if(a == null || b == null){
            return (a == null)? b : a;
        }
        if(a.val < b.val){
            a.next = merge(a.next, b);
            return a;
        }else{
            b.next = merge(a, b.next);
            return b;
        }
    }

    public void test_func1(){
        ListNode a1 = new ListNode(1);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        ListNode c2 = new ListNode(2);
        ListNode c6 = new ListNode(6);
        a1.next = a4;
        a4.next = a5;
        b1.next = b3;
        b3.next = b4;
        c2.next = c6;
        ListNode[] arr = new ListNode[3];
        arr[0] = a1;
        arr[1] = b1;
        arr[2] = c2;
        ListNode res = mergeKLists_1(arr);
        Util.printListNode(res); //1       1       2       3       4       4       5       6
    }

    public void test_func2(){
        ListNode a1 = new ListNode(1);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        ListNode c2 = new ListNode(2);
        ListNode c6 = new ListNode(6);
        a1.next = a4;
        a4.next = a5;
        b1.next = b3;
        b3.next = b4;
        c2.next = c6;
        ListNode[] arr = new ListNode[3];
        arr[0] = a1;
        arr[1] = b1;
        arr[2] = c2;
        ListNode res = mergeKLists_2(arr);
        Util.printListNode(res); //1       1       2       3       4       4       5       6
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        mergeKSortedList.test_func1();
        mergeKSortedList.test_func2();
    }
}
