package code.LinkedList;


/*
 * LeetCode 707 设计链表
 * 
在链表类中实现这些功能：
1、get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
2、addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
3、addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
4、addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
5、deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

示例：
MyLinkedList linkedList = new MyLinkedList();

linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkledList.addAtIndex(1,2);  // 链表变为 1 -> 2 -> 3
linkedList.get(1);   // 返回2
linkedList.deleteAtIndex(1); // 现在链表是 1 -> 3
linkedList.get(1);   // 返回3
*/

// Stage-01 : 先定义一个单链表节点
class LinkedListNode{
    int val; 
    LinkedListNode next;

    LinkedListNode(){}; // 构造函数无参
    LinkedListNode(int val){this.val = val;}; // 构造函数-单个参数
    LinkedListNode(int val, LinkedListNode next){this.val=val;this.next = next;}; // 构造函数-全参
}


// Stage-02 : 使用虚拟头节点来实现那5个接口
public class LinkedListDesign {

    // Common
    int size; // size存储链表元素的个数
    LinkedListNode head; // 虚拟头节点

    // Init 初始化
    LinkedListDesign(){
        size = 0;
        head = new LinkedListNode(0); // 虚拟头节点是为了不单独处理头节点了，代码更清晰，逻辑更少，值无所谓head.next才是真正链表的头
    }

    
    // Api-01: get 
    public int get(int index){

        // 如果index非法就返回-1
        if (index < 0 || index >= size){
            return -1;
        }

        // 因为设计了虚拟头节点，所有查找index+1个节点
        LinkedListNode currentNode = head;
        for (int i = 0; i<= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;

    }

    // Api-02: addAtHead
    public void addAtHead(int val){
        // 简单，就是把虚拟头节点的指向变为这个新的node的指向，然后把虚拟头节点再指向新节点
        LinkedListNode newNode = new LinkedListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }


    // Api-03: addAtTail
    public void addAtTail(int val){
        // 也简单，就是把新节点链到最后一个位置
        LinkedListNode newNode = new LinkedListNode(val);
        LinkedListNode cul = head;

        while (cul.next != null){
            cul = cul.next;
        };

        cul.next = newNode; // 这就是找到最后一个原节点了，然后链到新节点
        size++;
    }

    // Api-04: addAtIndex
    public void addAtIndex(int index, int val) {
        // 大体分为2类，其一如果index > size那就直接return & 如果index < 0 那就让index=0也就是新节点是新头; 其二这就是插入其实就是找到newNode的前驱跟后继节点，让前驱的next = newNode 让newNode的next等于后继
        if (index > size) {
            return;
        }
        
        if (index < size){
            index = 0; 
        }
        
        size++;

        // 找到要插入节点的前驱
        LinkedListNode pred = head;
        for (int i=0; i<index; i++){
            pred = pred.next;
        }

        LinkedListNode toAdd = new LinkedListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    // Api-05: deleteAtIndex
    public void deleteAtIndex(int index){
        // 简单就是让爷爷直接next等于孙子
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        //因为有虚拟头节点，所以不用对Index=0的情况进行特殊处理
        LinkedListNode pred = head;
        for (int i=0; i < index; i++){
            pred = pred.next;
        }
        pred.next = pred.next.next;

    }

}


// todo: 双链表的还没做
