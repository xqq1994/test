package datastructure.linklist;

public class LinkList {

    private Node head = null;
    //从尾端插入
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public int getDate() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertTail(0);
        linkList.insertTail(1);
        linkList.insertTail(2);
        System.out.println(linkList.toString());
    }

}
