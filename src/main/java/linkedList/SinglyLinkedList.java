package linkedList;

public class SinglyLinkedList {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    Node root = null;

    public SinglyLinkedList(int val) {
        root = new Node(val);
    }

    public static void main(String args[]) {
        Node node11 = new Node(11);
        Node node22 = new Node(22);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(10);
        singlyLinkedList.printNodes();
        singlyLinkedList.addToStart(node11);
        singlyLinkedList.printNodes();
        singlyLinkedList.addToEnd(node22);
        singlyLinkedList.addToEnd(45);
        singlyLinkedList.printNodes();
        singlyLinkedList.addToStart(11);
        singlyLinkedList.findFirstOccurance(11);
        singlyLinkedList.findLastOccurance(11);
        singlyLinkedList.findFirstOccurance(33);
        singlyLinkedList.findLastOccurance(33);
        singlyLinkedList.addToStart(33);
        singlyLinkedList.printNodes();
        singlyLinkedList.deleteNodeAtBeginning();
        singlyLinkedList.printNodes();
        singlyLinkedList.deleteNodeAtEnd();
        singlyLinkedList.printNodes();
        singlyLinkedList.deleteBeforeNode(node11);
        singlyLinkedList.deleteAfterNode(node22);
    }

    private void deleteBeforeNode(Node node) {
        Node temp = root;
        Node prev = null;
        Node prevprev = null;
        while (temp != null && node != temp) {

            temp = temp.next;
        }
        if (prevprev != null) {

        }

    }

    private void deleteAfterNode(Node node11) {

    }

    private void deleteNodeAtBeginning() {
        root = root.next;
    }

    private void deleteNodeAtEnd() {
        if (root == null) {
            return;
        }
        if (root.next == null) {
            root = root.next;
            return;
        }
        Node temp = root;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null){
            temp.next = temp.next.next;
        }
    }

    private void findFirstOccurance(int i) {
        Node temp = root;
        int count = 0;
        while (temp != null && temp.val != i) {
            count ++;
            temp = temp.next;
        }
        if (temp != null && temp.val == i) {
            System.out.println("Found " + i + " at location: "+ count);
            return;
        }
        System.out.println("Not Found " + i + " in linked list ");
    }

    private void findLastOccurance(int i) {
        Node temp = root;
        int count = 0;
        int foundLocation = -1;
        while (temp != null) {
            if (temp.val == i) {
                foundLocation = count;
            }
            count ++;
            temp = temp.next;
        }
        if (foundLocation != -1) {
            System.out.println("Found " + i + " at location: "+ foundLocation);
            return;
        }
        System.out.println("Not Found " + i + " in linked list ");
    }

    private void addToStart(int n) {
        addToStart(new Node(n));
    }

    private void addToStart(Node newNode) {
        newNode.next = root;
        root = newNode;
    }

    private void addToEnd(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    private void addToEnd(int n) {
        addToEnd(new Node(n));
    }

    private void printNodes() {
        Node temp = root;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
