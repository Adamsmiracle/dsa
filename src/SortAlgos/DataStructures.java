package SortAlgos;

public class DataStructures {
    public class Main {

        // Node class
        static class Node {
            int data;
            Node prev;
            Node next;

            Node(int data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        // Doubly Linked List class
        static class DoublyLinkedList {
            private Node head;

            // Insert at beginning
            public void insertAtBeginning(int data) {
                Node newNode = new Node(data);

                if (head != null) {
                    newNode.next = head;
                    head.prev = newNode;
                }

                head = newNode;
            }

            // Insert at end
            public void insertAtEnd(int data) {
                Node newNode = new Node(data);

                if (head == null) {
                    head = newNode;
                    return;
                }

                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
                newNode.prev = current;
            }

            // Delete a node by value
            public void delete(int data) {
                if (head == null) return;

                // If head needs to be deleted
                if (head.data == data) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    return;
                }

                Node current = head;
                while (current != null && current.data != data) {
                    current = current.next;
                }

                if (current == null) return;

                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                if (current.prev != null) {
                    current.prev.next = current.next;
                }
            }

            // Display forward
            public void displayForward() {
                Node current = head;
                while (current != null) {
                    System.out.print(current.data + " <-> ");
                    current = current.next;
                }
                System.out.println("null");
            }

            // Display backward
            public void displayBackward() {
                if (head == null) return;

                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }

                while (current != null) {
                    System.out.print(current.data + " <-> ");
                    current = current.prev;
                }
                System.out.println("null");
            }
        }

        // Main method (testing)
        public static void main(String[] args) {
            DoublyLinkedList list = new DoublyLinkedList();

            list.insertAtBeginning(10);
            list.insertAtBeginning(5);
            list.insertAtEnd(20);
            list.insertAtEnd(30);

            list.displayForward();   // 5 <-> 10 <-> 20 <-> 30 <-> null
            list.displayBackward();  // 30 <-> 20 <-> 10 <-> 5 <-> null

            list.delete(10);
            list.displayForward();   // 5 <-> 20 <-> 30 <-> null
        }
    }


}
