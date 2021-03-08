
class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedList {
    Node head = null;

    public void add(int val) {
        head = new Node(val, head);
    }

    public boolean search(int i) {
        Node curr = head;

        while (curr != null) {
            if (curr.val == i)
                return true;
            curr = curr.next;
        }
        return false;
    }

    public void print() {
        Node curr = head;
        if (curr == null)
            return;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public void delete(int i) {
        Node curr = head;
        Node prev = null;
        if(curr!=null && curr.val == i){
            head = curr.next;
            return;
        }

        while(curr!=null && curr.val != i){
            prev = curr;
            curr = curr.next;

        }

        if(curr == null){
            return;
        }

        prev.next = curr.next;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.print();
        System.out.println(ll.search(1));
        System.out.println(ll.search(2));
        System.out.println(ll.search(3));
        System.out.println(ll.search(4));
        ll.delete(2);
        ll.print();
    }

}