class ListNode {
  int val;
  ListNode next;
}

public class reverseLinkedList_2 {
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode prev_Lnode = null;
    ListNode temp = head;

    // int currPos = 1;

    // while (temp != null) {
    //   if (currPos == left - 1) {
    //     prev_Lnode = temp;
    //     System.out.println("prev_Lnode.val: " + prev_Lnode.val);
    //   }

    //   if (currPos == right) {
    //     next_Rnode = temp.next;
    //     if (next_Rnode != null) {
    //       System.out.println("next_Rnode: " + next_Rnode.val);
    //     } else {
    //       System.out.println("End of the list");
    //     }
    //   }
    //   temp = temp.next;
    //   currPos++;
    // }
    for(int i = 0; i < left - 1; i++){
      prev_Lnode = temp;
      temp = temp.next;
    }

    ListNode prev = null;
    ListNode startNode = (left == 1) ? head : prev_Lnode.next;
    ListNode curr = startNode;

    int count = right - left + 1;

    while (count > 0) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count--;
    }
    startNode.next = curr;
    if (prev_Lnode != null) {
      prev_Lnode.next = prev;
    }else{
      head = prev;
    }
    return head;
  }

  public static ListNode Insert(ListNode head, int data) {
    ListNode newNode = new ListNode();
    newNode.val = data;
    if (head == null) {
      newNode.next = null;
    }
    newNode.next = head;
    head = newNode;

    return newNode;
  }

  public static void traverse(ListNode head) {
    ListNode curr = head;

    while (curr != null) {
      if (curr.next == null) {
        System.out.print(curr.val);
      } else {
        System.out.print(curr.val + "->");
      }
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = null;
    head = Insert(head, 7);
    head = Insert(head, 8);
    head = Insert(head, 9);
    head = Insert(head, 10);
    head = Insert(head, 12);

    // 12-> 10 -> 9 -> 8 -> 7

    head = reverseBetween(head, 2, 4);

    traverse(head);
  }
}
