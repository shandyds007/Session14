public class Deletion {
    static class Node {
        int data;
        Node next, prev;

        Node(int newData) {
            this.data = newData;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node deleteAtBeginning(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = head.next;
        if (newHead != null) {
            newHead.prev = null;
        }
        return newHead;
    }

    public static Node deleteAtEnd(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.prev.next = null;
        return head;
    }

    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            return deleteAtBeginning(head);
        }
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            return head; // Position is out of bounds
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        return head;
    }

    public static void main() {
        // double linkedlist with 5 nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

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

        // delete at beginning
        head = deleteAtBeginning(head);
        current = head;
        System.out.print("After Deletion at Beginning: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();

        // delete at position 3
        head = deleteAtPosition(head, 3);
        current = head;
        System.out.print("After Deletion at Position 3: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();

        // delete at end
        head = deleteAtEnd(head);
        current = head;
        System.out.print("After Deletion at End: ");
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
