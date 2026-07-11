public class CircularDoubly {
    static class Node {
        int data;
        Node next, prev;

        Node(int newData) {
            this.data = newData;
            this.next = null;
            this.prev = null;
        }
    }

    static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int totalNodes = 0;
        Node countTemp = head;
        do {
            totalNodes++;
            countTemp = countTemp.next;
        } while (countTemp != head);

        Node temp = head;
        int count = 0;

        int limit = totalNodes + 2;

        while (count < limit) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
            count++;
        }

        System.out.println(".... <->");
    }

    static Node insertAtBeginning(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;

        return newNode; // New node becomes the new head
    }

    static Node insertAtEnd(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;

        return head; // Head remains the same
    }

    static Node deleteAtBeginning(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) { // Only one node
            return null;
        }
        Node last = head.prev;

        head = head.next;
        last.next = head;
        head.prev = last;

        return head; // New head
    }

    static Node deleteAtEnd(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) { // Only one node
            return null;
        }
        Node last = head.prev;
        Node secondLast = last.prev;

        secondLast.next = head;
        head.prev = secondLast;

        return head; // Head remains the same
    }

    void main(){
        // circular linkedlist with 7 nodes
        Node head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        System.out.print("Current Circular Doubly LinkedList: ");
        printList(head);

        // insert at front
        head = insertAtBeginning(head, 0);
        System.out.print("After adding at front: ");
        printList(head);

        // insert at end
        head = insertAtEnd(head, 8);
        System.out.print("After adding at end: ");
        printList(head);

        // delete at front
        head = deleteAtBeginning(head);
        System.out.print("After deleting at front: ");
        printList(head);

        // delete at end
        head = deleteAtEnd(head);
        System.out.print("After deleting at end: ");
        printList(head);
    }
}
