public class ReverseLinkedList {

    static LinkedList node;

    public static LinkedList createNode(int data){
        return new LinkedList(data);
    }

    public static void deleteNode(LinkedList node,int data){

        if(node == null)
            return;
        LinkedList temp = node;
        while(temp!=null){
            LinkedList pNode = temp.next;
            if(temp.data == data){
                temp.data = pNode.data;
                temp.next = pNode.next;
                pNode.next = null;
                return;
            }
            temp = temp.next;
        }
    }
    //1->2->3->4
    public static LinkedList reverseLinkedList(LinkedList node){
        if(node==null)
            return null;
        LinkedList temp = node;
        LinkedList prevNode = null;
        while(temp!=null){
            LinkedList nNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nNode;
        }
        return  prevNode;
    }

    public static void printLinkedList(LinkedList node){
        if(node == null)
            return;
        LinkedList temp = node;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        LinkedList node = new LinkedList(1);
        node.next = createNode(2);
        node.next.next = createNode(3);
        node.next.next.next = createNode(4);
        node.next.next.next.next = createNode(5);
        System.out.println("Initial");
        printLinkedList(node);
        LinkedList t = node;
        System.out.println("Delete:2");
        deleteNode(node,2);
        printLinkedList(node);
         t = reverseLinkedList(node);
        System.out.println("Reverse");
        printLinkedList(t);

    }
}
