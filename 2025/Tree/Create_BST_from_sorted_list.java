public class Create_BST_from_sorted_list {
  class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
      this.left = null;
      this.right = null;
      this.val = val;
    }
  }

  class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
      this.next = null;
      this.val = val;
    }
  }

  TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }

    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (prev != null) {
      prev.next = null;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);

    return root;
  }
}