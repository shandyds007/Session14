public class Inserting {
    static class Node{
        int data;
        Node next, prev;

        Node(int newData){
            this.data = newData;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node insertAtBeginning(Node head, int newData){
        // Create new Node
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        return newNode;
    }

    public static Node insertAtEnd(Node head, int newData){
        Node newNode = new Node(newData);
        if (head == null) {
            return newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
            return head;
        }
    }

    public static Node insertAtPosition(Node head, int newData, int position){
        Node newNode = new Node(newData);
        if (position == 0) {
            return insertAtBeginning(head, newData);
        } else {
            Node current = head;
            for (int i = 0; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return insertAtEnd(head, newData);
            } else {
                newNode.next = current.next;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                newNode.prev = current;
                return head;
            }
        }
    }

    public static void main(){
        // double linkedlist with 5 nodes
        Node head = new Node(1);
        head = Inserting.insertAtEnd(head, 2);
        head = Inserting.insertAtEnd(head, 3);
        head = Inserting.insertAtEnd(head, 4);
        head = Inserting.insertAtEnd(head, 5);

        Node current = head;
        System.out.print("Current Double Linked List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();

        // add node at the beginning
        head = Inserting.insertAtBeginning(head, 0);
        current = head;
        System.out.print("After inserting 0 at the beginning: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();

        // add node at the end
        head = Inserting.insertAtEnd(head, 6);
        current = head;
        System.out.print("After inserting 6 at the end: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();

        // add node at a specific position
        head = Inserting.insertAtPosition(head, 10, 3);
        current = head;
        System.out.print("After inserting 10 at position 3: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}


