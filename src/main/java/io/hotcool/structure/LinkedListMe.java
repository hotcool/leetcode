package io.hotcool.structure;

public class LinkedListMe{

    class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int size;

    public LinkedListMe() {
        this.head = new Node(-999);
        this.size = 0;
    }

    public boolean add(int nextValue){
        Node nextNode = new Node(nextValue);
        Node currentNode = head;
        while (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(nextNode);
        ++size;
        return true;
    }

    public boolean add(int nextValue, int location){
        if(location > size || location < 0){
            throw new IndexOutOfBoundsException(location + " is not in the range.");
        }

        Node currentNode = head;
        for(int index = 0; index < location; ++index){
            currentNode = currentNode.getNext();
        }
        Node nextNode = currentNode.getNext();
        currentNode.setNext(new Node(nextValue, nextNode));

        ++size;
        return true;
    }

    public Node getNode(int location){
        if(location > size || location < 0){
            throw new IndexOutOfBoundsException(location + " is not in the range.");
        }

        Node currentNode = head;
        for(int index = 0; index < location; ++index){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public boolean deleteNode(int value){
        Node currentNode = head;
        while (null != currentNode.getNext()){
            if(currentNode.getNext().getValue() == value){
                Node nextNode = currentNode.getNext().getNext();
                currentNode.setNext(nextNode);
                --size;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public boolean deleteNodeByLocation(int location){
        Node currentNode = head;
        if(location > size || location < 0){
            throw new IndexOutOfBoundsException(location + " is not in the range.");
        }

        for(int index = 0; index < location-1; ++index){
            currentNode = currentNode.getNext();
        }

        Node nextNode = currentNode.getNext().getNext();
        currentNode.setNext(nextNode);
        --size;
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        Node currentNode = head;
        while(currentNode.getNext()!=null){
            System.out.print(currentNode.getValue()+" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.println(currentNode.getValue() + ", size = " + size);
    }

    public static void main(String[] args) {

        LinkedListMe me = new LinkedListMe();
        me.add(1);
        me.print();
        me.add(2);
        me.print();
        me.add(3);
        me.print();
        me.deleteNode(2);
        me.print();
        me.deleteNodeByLocation(2);
        me.print();
        me.deleteNodeByLocation(1);
        me.print();
        me.add(1);
        me.print();
        me.add(2);
        me.print();
        me.add(5, 0);
        me.print();
        me.add(8, 2);
        me.print();
        System.out.println(me.getNode(0));
        me.deleteNode(1);
        me.print();
        me.deleteNode(2);
        me.print();
        System.out.println(me.isEmpty());
        me.deleteNodeByLocation(0);
        me.print();
        me.deleteNodeByLocation(0);
        me.print();
        System.out.println(me.isEmpty());
    }
}
