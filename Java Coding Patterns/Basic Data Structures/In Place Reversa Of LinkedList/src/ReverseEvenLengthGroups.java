public class ReverseEvenLengthGroups {
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

        public LinkedListNode reverseEvenLengthGroup(LinkedListNode head) throws NullPointerException{
            if (head == null)
                throw new NullPointerException("Linked List cannot be empty");

            LinkedListNode previous = head;
            LinkedListNode nodePosition, current, reverse, currNext, prevNext = null;

            //Since initial group length will be 1 which is to be skipped
            int groupLength = 2;
            int nodeCount = 0;

            while (previous.next != null){

                nodePosition = previous;
                nodeCount = 0;

                for(int i = 0; i < groupLength; i++){
                    if(nodePosition.next == null)
                        break;
                    nodeCount += 1;
                    nodePosition = nodePosition.next;
                }

                if(nodeCount % 2 != 0)
                    previous = nodePosition;

                else{
                    reverse = nodePosition.next;
                    current = previous.next;

                    for(int i = 0; i < nodeCount; i++){
                        currNext = current.next;
                        current.next = reverse;
                        reverse = current;
                        current = currNext;
                    }

                    prevNext = previous.next;
                    previous.next = nodePosition;
                    previous = prevNext;
                }
                groupLength += 1;
            }
            return head;
        }
    }
    public static void main(String[] args) {
        int[] inputArray = {10,11,12,13,14};
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(inputArray);
        linkedList.printLinkedList(linkedList.head);
        try{
            System.out.println("The Linked List after reversing even length groups is ");
            linkedList.head = linkedList.reverseEvenLengthGroup(linkedList.head);
            linkedList.printLinkedList(linkedList.head);
        }catch (NullPointerException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
