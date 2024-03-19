import java.util.Scanner;

public class ReverseLinkedList {
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

        public LinkedListNode reverseLinkedList(LinkedListNode head) throws NullPointerException{
            if(head == null)
                throw new NullPointerException("Linked List to reverse cannot be empty");

            LinkedListNode previous = null;
            LinkedListNode current = head;
            LinkedListNode ahead = null;

            while(current != null){
                ahead = current.next;
                current.next = previous;
                previous = current;
                current = ahead;
            }
            head = previous;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {5,4,3,2,1};
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(inputArray);
        linkedList.printLinkedList(linkedList.head);
        try{
            System.out.println("The reversal of the given linked list is ");
            linkedList.head = linkedList.reverseLinkedList(linkedList.head);
            linkedList.printLinkedList(linkedList.head);
        }catch (NullPointerException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
