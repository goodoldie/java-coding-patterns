public class ReverseKGroup {
    public static class LinkedListNode {
        private final int data;
        private LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        private LinkedListNode head;

        LinkedList() {
            this.head = null;
        }

        public void insertAtHead(LinkedListNode node) {
            if (this.head == null)
                this.head = node;
            else {
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

        public void printLinkedList(LinkedListNode head) {
            try {
                if (head == null)
                    throw new NullPointerException("Cannot print an empty LinkedList");

                LinkedListNode temp = head;
                while (temp != null) {
                    System.out.print(temp.data);
                    temp = temp.next;
                    if (temp != null)
                        System.out.print(" -> ");
                }
                System.out.print(" -> null \n");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        public LinkedListNode[] reverseLinkedList(LinkedListNode node, int k){
            LinkedListNode previous = null;
            LinkedListNode current = node;
            LinkedListNode next = null;

            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return new LinkedListNode[]{previous, current};
        }

        public LinkedListNode reverseKGroupNodes(LinkedListNode head, int k) throws NullPointerException{
            if(head == null)
                throw new NullPointerException("Linked List cannot be empty");

            LinkedListNode dummyNode = new LinkedListNode(0);
            dummyNode.next = head;
            LinkedListNode pointer = dummyNode;

            while(pointer != null){
                LinkedListNode tracker = pointer;
                for (int i = 0; i < k; i++) {
                    // if at anypoint in a group, the tracker becomes null, we exit
                    if (tracker == null) {
                        break;
                    }
                    tracker = tracker.next;
                }
                //if after traversing a group the tracker is pointing to null, it means we have reached the end of list
                if(tracker == null)
                    break;

                LinkedListNode[] updatedNodes = reverseLinkedList(pointer.next, k);
                LinkedListNode previous = updatedNodes[0];
                LinkedListNode current = updatedNodes[1];
                LinkedListNode lastNodeOfReversedGroup = pointer.next;
                lastNodeOfReversedGroup.next = current;
                pointer.next = previous;
                pointer = lastNodeOfReversedGroup;
            }
            return dummyNode;
        }
    }




    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4,5,6,7};
        int k = 3;
        try{
            LinkedList linkedList = new LinkedList();
            linkedList.createLinkedList(inputArray);
            linkedList.printLinkedList(linkedList.head);
            System.out.println("Linked list after reversing in groups of " +  k + " is");
            linkedList.head = linkedList.reverseKGroupNodes(linkedList.head, k);
            linkedList.printLinkedList(linkedList.head.next);
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
