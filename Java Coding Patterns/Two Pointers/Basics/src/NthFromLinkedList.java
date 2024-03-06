import java.util.InputMismatchException;
import java.util.Scanner;

public class NthFromLinkedList {
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
    }
    public static LinkedListNode removeNthfromLinkedList(LinkedListNode head, int n){
        try{
            if(n < 0)
                throw new IllegalArgumentException("Invalid position. Please enter a positive position");

            LinkedListNode slow = head;
            LinkedListNode fast = head;

            //move the fast pointer n steps forward
            for(int i = 0; i < n; i++){
                if(fast == null)
                    throw new IllegalArgumentException("Invalid position. The linked list is not long enough");
                else
                    fast = fast.next;
            }
            //Remove the head
            if(fast == null) {
                assert head != null;
                return head.next;
            }

            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return  head;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {9,8,7,6,5,2};
        int input;
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(inputArray);
        linkedList.printLinkedList(linkedList.head);
        System.out.println("Enter the position of the node from the end of the linked list which is to be removed");
        try{
            input = scanner.nextInt();
            linkedList.head = removeNthfromLinkedList(linkedList.head, input);
            linkedList.printLinkedList(linkedList.head);
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
