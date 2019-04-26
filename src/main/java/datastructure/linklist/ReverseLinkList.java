package datastructure.linklist;

public class ReverseLinkList {
    // 单链表反转
    /*public static Node reverse(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }*/
    public static class Node{
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
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

    public static Node reverse(Node list){
        Node headNode = null;
        Node pre = null;
        Node current = list;
        while (current != null){
            Node next = current.next;
            if(next == null){
                headNode = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return headNode;
    }
    public static void main(String[] args) {
        Node node = new Node(1,new Node(2,null));

        Node reverse = reverse(node);
        System.out.println(reverse);


    }
}
