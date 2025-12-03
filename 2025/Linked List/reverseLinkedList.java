class ListNode {
  int val;
  ListNode next;
}

public class reverseLinkedList {
  public static ListNode reverseLinkedList(ListNode head) {
    ListNode curr = head;
    ListNode next = null;
    ListNode prev = null;

    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head = prev;
    return head;
  }

  public static ListNode InsertNode(ListNode head, int val) {
    ListNode newNode = new ListNode();
    newNode.next = head;
    newNode.val = val;
    return newNode;
  }

  public static void traverse(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    ListNode head = null;
    head = InsertNode(head, 2);
    head = InsertNode(head, 3);
    head = InsertNode(head, 4);

    traverse(head);
    System.out.println("After Reversing the Linked List");
    head = reverseLinkedList(head);
    traverse(head);
  }
}
