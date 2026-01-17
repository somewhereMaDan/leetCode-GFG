
import java.util.LinkedList;
import java.util.Queue;

public class BST_Traversal {
  class ListNode {
    int val;
    ListNode left;
    ListNode right;

    ListNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  ListNode InsertNode(ListNode root, int val) {
    if (root == null) {
      return new ListNode(val);
    } else if (val < root.val) {
      root.left = InsertNode(root.left, val);
    } else {
      root.right = InsertNode(root.right, val);
    }
    return root;
  }

  void LevelOrder(ListNode root) {
    if (root == null) {
      System.out.println("Tree is empty");
      return;
    }
    Queue<ListNode> que = new LinkedList<>();
    que.add(root);

    while (!que.isEmpty()) {
      System.out.print(que.element().val + " ");
      if (que.peek().left != null) {
        que.add(que.peek().left);
      }
      if (que.peek().right != null) {
        que.add(que.peek().right);
      }
      que.poll();
    }
  }

  void PreOrder(ListNode root) {
    // DLR
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    PreOrder(root.left);
    PreOrder(root.right);
  }

  void PostOrder(ListNode root) {
    // LRD
    if (root == null) {
      return;
    }
    PostOrder(root.left);
    PostOrder(root.right);
    System.out.print(root.val + " ");
  }

  void InOrder(ListNode root) {
    if (root == null) {
      return;
    }
    InOrder(root.left);
    System.out.println(root.val + " ");
    InOrder(root.right);
  }

  public static void main(String[] args) {
    BST_Traversal obj = new BST_Traversal();
    ListNode root = null;
    root = obj.InsertNode(root, 25);
    root = obj.InsertNode(root, 20);
    root = obj.InsertNode(root, 22);
    root = obj.InsertNode(root, 17);
    root = obj.InsertNode(root, 30);
    root = obj.InsertNode(root, 37);
    root = obj.InsertNode(root, 28);

    System.out.print("Level Order traversal: ");
    obj.LevelOrder(root);
    System.out.println();

    System.out.print("Pre Order traversal: ");
    obj.PreOrder(root);
    System.out.println();

    System.out.print("Post Order traversal: ");
    obj.PostOrder(root);
    System.out.println();

    System.out.print("In-Order traversal: ");

  }
}
