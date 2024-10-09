package code.LinkedList;

class ListNode{

    int val; // 节点的值

    ListNode next; // 下一个节点

    public ListNode(){ // 构造函数-无参

    }

    public ListNode(int val){ // 构造函数-有一个参数
        this.val = val;
    }

    public ListNode(int val, ListNode next){ // 构造函数-两个参数
        this.val = val;
        this.next = next;
    }

}


// 单链表定义
class SinglyLinkedList {
    ListNode head;

    // 向链表的尾部添加一个节点
    public void append(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
    }

    // 打印链表中的所有节点值
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// 双链表定义
class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    // 节点的构造函数(无参)
    public DoublyListNode() {}

    // 节点的构造函数(有一个参数)
    public DoublyListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有三个参数)
    public DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    DoublyListNode head;
    DoublyListNode tail;

    // 向链表的尾部添加一个节点
    public void append(int val) {
        if (head == null) {
            head = new DoublyListNode(val);
            tail = head;  // 初始化时，头和尾指向同一个节点
            return;
        }
        DoublyListNode newNode = new DoublyListNode(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // 打印链表中的所有节点值
    public void printList() {
        DoublyListNode current = head;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// 循环链表定义
class CircularLinkedList {
    ListNode head;
    ListNode tail;

    // 向循环链表的尾部添加一个节点
    public void append(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;  // 形成循环，虚拟头节点的效果
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;  // 形成循环
    }

    // 打印链表中的所有节点值
    public void printList(int count) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode current = head;
        for (int i = 0; i < count; i++) {  // 为了避免无限循环，使用一个计数器
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("...");  // 表示继续循环
    }
}

// 测试主函数
public class LinkedList {
    public static void main(String[] args) {
        // 测试单链表
        System.out.println("Singly Linked List:");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.printList();

        // 测试双链表
        System.out.println("\nDoubly Linked List:");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);
        doublyLinkedList.append(6);
        doublyLinkedList.printList();

        // 测试循环链表
        System.out.println("\nCircular Linked List:");
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.append(7);
        circularLinkedList.append(8);
        circularLinkedList.append(9);
        circularLinkedList.printList(10);  // 打印循环链表的前 10 个节点
    }
}