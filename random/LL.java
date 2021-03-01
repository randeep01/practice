class Node{
    int data;
    Node ptr;
    public Node(int data, Node ptr){
        this.data = data;
        this.ptr = ptr;
    }
}
public class LL {
    Node head;
    public void add(int data){
        head = new Node(data,head);
    }
    public void delete(Node ptr){
        if(ptr ==null) return;
        if(ptr.ptr == null) return;
        ptr.data = ptr.ptr.data;
        ptr.ptr = ptr.ptr.ptr;

    }
    public void delete(int val){
        Node curr = head;
        Node prev = null;
        if (curr!=null && curr.data == val){
            head = curr.ptr;
            return;
        }
        while(curr!=null&&curr.data!=val){
            prev = curr;
            curr = curr.ptr;
        }
        if(curr==null){
            return;
        }
        prev.ptr = curr.ptr;
    }
    public Node middle(){
        if(head == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.ptr!=null){
            slow = slow.ptr;
            fast = fast.ptr.ptr;
        }

        return slow;
    }
    public void reverse()
    {
        Node curr = head;
        Node prev = null;
        Node next = head;
        while(next!=null){
            next = next.ptr;
            curr.ptr = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

}
