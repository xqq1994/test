package datastructure.linklist;

public class CheckCircleLinkList {
    public static class Node{
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    //如果有环快慢指针最终都会在一起
    public boolean checkCircle(Node list){
        if(list == null) return false;
        Node fast = list.next;
        Node slow = list;
        while (fast  != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
