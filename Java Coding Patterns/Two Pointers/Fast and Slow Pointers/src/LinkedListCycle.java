public class LinkedListCycle {
    public static class LinkedListNode{
        private final int data;
        private LinkedListNode next;
        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class LinkedList{
        private LinkedListNode head;
        LinkedList(){
            this.head = null;
        }
        public void insertAtHead(LinkedListNode node){
            if(this.head == null)
                this.head = node;
            else{
                node.next = this.head;
                this.head = node;
            }
        }
        public void createLinkedList(int[] list) {
            for (int i = list.length - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(list[i]);
                insertAtHead(newNode);
            }
        }
        public void printLinkedList(LinkedListNode head){
            try{
                if(head == null)
                    throw new NullPointerException("Cannot print an empty LinkedList");

                LinkedListNode temp = head;
                while(temp != null){
                    System.out.print(temp.data);
                    temp = temp.next;
                    if(temp != null)
                        System.out.print(" -> ");
                }
                System.out.print(" -> null \n");
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        public void createCycle(LinkedListNode head, int cycleCreatePoint){
            LinkedListNode last = head;
            LinkedListNode cyclePoint = head;
            while(last.next != null)
                last = last.next;
            while(true) {
                assert cyclePoint != null;
                if (cyclePoint.data == cycleCreatePoint) break;
                cyclePoint = cyclePoint.next;
            }
            last = cyclePoint;
        }
    }
    public static boolean cycleDetection(LinkedListNode head){
        if(head == null)
            throw new NullPointerException("Linked List is empty");
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] inputArray = {2,3,4,6,7,8};
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(inputArray);
        //Node at which loop is to be created
        int cycleCreatePoint = 3;
        linkedList.createCycle(linkedList.head, cycleCreatePoint);
        try{
            boolean containsCycle = cycleDetection(linkedList.head);
            if(containsCycle)
                System.out.println("The given linked list contains a cycle");
            else
                System.out.println("The given linked list does not contain a cycle");
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
