package linkedList;

public class DoublyLinkedList {
    static class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    Node root = null;

    private DoublyLinkedList(int val) {
        root = new Node(val);
    }

    public static void main(String args[]) {
        Node node11 = new Node(11);
        Node node22 = new Node(22);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);
        doublyLinkedList.printNodes();
        System.out.println("Add to start");
        doublyLinkedList.addToStart(node11);
        doublyLinkedList.printNodes();
        System.out.println("Add to end");
        doublyLinkedList.addToEnd(node22);
        doublyLinkedList.addToEnd(45);
        doublyLinkedList.printNodes();
        System.out.println("Add to start");
        doublyLinkedList.addToStart(11);
        System.out.println("find First Occurance");
        doublyLinkedList.findFirstOccurance(11);
        doublyLinkedList.findLastOccurance(11);
        doublyLinkedList.findFirstOccurance(33);
        doublyLinkedList.findLastOccurance(33);
        System.out.println("Add to start");
        doublyLinkedList.addToStart(33);
        doublyLinkedList.printNodes();
        System.out.println("delete Node At Beginning");
        doublyLinkedList.deleteNodeAtBeginning();
        doublyLinkedList.printNodes();
        System.out.println("delete Node At End");
        doublyLinkedList.deleteNodeAtEnd();
        doublyLinkedList.printNodes();
        System.out.println("delete Before Node");
        doublyLinkedList.deleteBeforeNode(node22);
        doublyLinkedList.printNodes();
        System.out.println("delete After Node");
        doublyLinkedList.deleteAfterNode(node11);
        doublyLinkedList.printNodes();
        System.out.println("add To Start");
        doublyLinkedList.addToStart(112);
        doublyLinkedList.addToStart(32);
        doublyLinkedList.addToStart(43);
        doublyLinkedList.addToStart(63);
        doublyLinkedList.printNodes();
        System.out.println("remove Nth Node");
        doublyLinkedList.removeNthNode(2);
        doublyLinkedList.printNodes();
        System.out.println("reverse List");
        doublyLinkedList.reverseList();
        doublyLinkedList.printNodes();

        System.out.println("Middle Node");
        Node middleNode = doublyLinkedList.findMiddleNode();
        printNodes(middleNode);
        doublyLinkedList.removeNthNode(2);
        doublyLinkedList.printNodes();
        System.out.println("Middle Node");
        Node middleNode2 = doublyLinkedList.findMiddleNode();
        printNodes(middleNode2);

        DoublyLinkedList oneLinkedList = new DoublyLinkedList(10);
        DoublyLinkedList twoLinkedList = new DoublyLinkedList(9);
        oneLinkedList.addToEnd(13);
        oneLinkedList.addToEnd(16);
        oneLinkedList.addToEnd(90);
        oneLinkedList.printNodes();

        twoLinkedList.addToEnd(12);
        twoLinkedList.addToEnd(12);
        twoLinkedList.addToEnd(32);
        twoLinkedList.printNodes();
        System.out.println("merge Two Linked Lists");
        Node node = mergeTwoLinkedLists(oneLinkedList.root, twoLinkedList.root);
        printNodes(node);
    }

    private Node findMiddleNode() {
        if (root == null) {
            return root;
        }
        Node slow = root;
        Node fast = root;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void removeNthNode(int n) {
        Node temp = root;
        int count = 0;
        Node prev = null;
        while (temp != null && count != (n-1)) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        if (count == (n-1) && prev != null && prev.next != null) {
            Node nextOfNext = prev.next.next;
            nextOfNext.prev = prev;
            prev.next = nextOfNext;
        }
    }

    private static Node mergeTwoLinkedLists(Node node1, Node node2) {
        Node result = new Node(0);
        Node dummy = result;
        Node prev = null;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy.prev = prev;
            prev = dummy;
            dummy = dummy.next;
        }
        dummy.next = node1 != null ? node1 : node2;
        return result.next;
    }

    //
    //  3 <----> 4 <----> 5
    //
    private void reverseList() {
        if (root == null) {
            return;
        }
        Node temp = root;
        Node prev = null;
        while(temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            temp.prev = nextNode;
            prev = temp;
            temp = nextNode;
        }
        root = prev;
    }

    private void deleteBeforeNode(Node node) {
        if (node != null) {
            Node prev = node.prev;
            deleteNode(prev);
        }
    }

    private void deleteNode(Node node) {
        if (node != null) {
            Node prev = node.prev;
            Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
        }
    }

    private void deleteAfterNode(Node node) {
        Node temp = root;
        while (temp != null && node != temp) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    private void deleteNodeAtBeginning() {
        if (root != null) {
            Node next = root.next;
            if (next != null) {
                next.prev = null;
            }
            root = root.next;
        }
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
        if (root == null) {
            root = newNode;
            return;
        }
        newNode.next = root;
        newNode.prev = root.prev;
        root.prev = newNode;
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
            newNode.prev = temp;
            temp.next = newNode;
        }
    }

    private void addToEnd(int n) {
        addToEnd(new Node(n));
    }

    private void printNodes() {
        printNodes(root);
    }

    private static void printNodes(Node node) {
        Node temp = node;
        Node prev = null;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val + ",");
            prev = temp;
            temp = temp.next;
        }
        System.out.println("]");
        System.out.print("[");
        while (prev != null) {
            System.out.print(prev.val + ",");
            prev = prev.prev;
        }
        System.out.println("]");
    }
}
