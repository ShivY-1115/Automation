package Interview;

public class Linked_List {


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Linkedlist_problems{
    public ListNode reverse_list(ListNode head)
    {
        ListNode prev = null;
        while(head!=null){
            ListNode nextnode = head.next;
             head.next = prev;
             prev = head;


        }
        return prev;
    }
}
