package datastructure.stack;

public class StackLinkList {

    private Node top = null;

    public boolean push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return true;
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int tmp = top.data;
        top = top.next;
        return tmp;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StackLinkList{" +
                "top=" + top +
                '}';
    }

    public static void main(String[] args) {
        StackLinkList stackArray = new StackLinkList();
        stackArray.push(1);
        stackArray.push(2);
        System.out.println(stackArray.toString());
        int pop = stackArray.pop();
        System.out.println(pop);
        System.out.println(stackArray.toString());
    }
}
