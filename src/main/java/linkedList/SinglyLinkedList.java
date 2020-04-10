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
        SinglyLinkedList SinglyLinkedList = new SinglyLinkedList(10);
        SinglyLinkedList.printNodes();
        System.out.println("Add to start");
        SinglyLinkedList.addToStart(node11);
        SinglyLinkedList.printNodes();
        System.out.println("Add to end");
        SinglyLinkedList.addToEnd(node22);
        SinglyLinkedList.addToEnd(45);
        SinglyLinkedList.printNodes();
        System.out.println("Add to start");
        SinglyLinkedList.addToStart(11);
        System.out.println("find First Occurance");
        SinglyLinkedList.findFirstOccurance(11);
        SinglyLinkedList.findLastOccurance(11);
        SinglyLinkedList.findFirstOccurance(33);
        SinglyLinkedList.findLastOccurance(33);
        System.out.println("Add to start");
        SinglyLinkedList.addToStart(33);
        SinglyLinkedList.printNodes();
        System.out.println("delete Node At Beginning");
        SinglyLinkedList.deleteNodeAtBeginning();
        SinglyLinkedList.printNodes();
        System.out.println("delete Node At End");
        SinglyLinkedList.deleteNodeAtEnd();
        SinglyLinkedList.printNodes();
        System.out.println("delete Before Node");
        SinglyLinkedList.deleteBeforeNode(node22);
        SinglyLinkedList.printNodes();
        System.out.println("delete After Node");
        SinglyLinkedList.deleteAfterNode(node11);
        SinglyLinkedList.printNodes();
        System.out.println("add To Start");
        SinglyLinkedList.addToStart(112);
        SinglyLinkedList.addToStart(32);
        SinglyLinkedList.addToStart(43);
        SinglyLinkedList.addToStart(63);
        SinglyLinkedList.printNodes();
        System.out.println("remove Nth Node");
        SinglyLinkedList.removeNthNode(2);
        SinglyLinkedList.printNodes();
        System.out.println("reverse List");
        SinglyLinkedList.reverseList();
        SinglyLinkedList.printNodes();

        System.out.println("Middle Node");
        Node middleNode = SinglyLinkedList.findMiddleNode();
        printNodes(middleNode);
        SinglyLinkedList.removeNthNode(2);
        SinglyLinkedList.printNodes();
        System.out.println("Middle Node");
        Node middleNode2 = SinglyLinkedList.findMiddleNode();
        printNodes(middleNode2);

        SinglyLinkedList oneLinkedList = new SinglyLinkedList(10);
        SinglyLinkedList twoLinkedList = new SinglyLinkedList(9);
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
            prev.next = prev.next.next;
        }
    }

    private static Node mergeTwoLinkedLists(Node node1, Node node2) {
        Node result = new Node(0);
        Node dummy = result;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = node1 != null ? node1 : node2;
        return result.next;
    }

    private void reverseList() {
        if (root == null) {
            return;
        }
        Node temp = root;
        Node prev = null;
        while(temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        root = prev;
    }

    private void deleteBeforeNode(Node node) {
        Node temp = root;
        Node prev = null;
        Node prevprev = null;
        while (temp != null && node != temp) {
            prevprev = prev;
            prev = temp;
            temp = temp.next;
            System.out.println(prev.val);
        }
        if (prevprev != null) {
            prevprev.next = prevprev.next.next;
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
        printNodes(root);
    }

    private static void printNodes(Node node) {
        Node temp = node;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }
}
