import java.util.InputMismatchException;
import java.util.Scanner;

public class MiddleOfLinkedList {
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
    public static int middleOfLinkedList(LinkedListNode head){
        try{
            if(head == null)
                throw new NullPointerException("Linked List is empty");
            LinkedListNode slow = head;
            LinkedListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }



    public static void main(String[] args) {
        int[] inputArray = {9,8,7,6,5,10,23,33};
        int input;
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(inputArray);
        linkedList.printLinkedList(linkedList.head);
        System.out.println("The middle of the linked list is " + middleOfLinkedList(linkedList.head));
    }
}
