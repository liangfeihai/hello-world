package listnode;

public class ListNodeTest {
    public int listLength(ListNode headNode){
        int length=0;
        ListNode currentNode=headNode;
        while (currentNode!=null){
            length++;
            currentNode=currentNode.getNext();
        }
        return length;
    }

    public static void  main(String[] args){
        ListNode headNode=new ListNode(1);
        headNode.setNext(new ListNode(20));
        ListNodeTest listNodeTest=new ListNodeTest();
        int length=listNodeTest.listLength(headNode);
        System.out.println("length:"+length);
    }

}
