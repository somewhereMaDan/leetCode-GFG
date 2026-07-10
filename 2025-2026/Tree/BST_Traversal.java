
import java.util.ArrayList;
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

  void InOrder(ListNode root, ArrayList<Integer> arr) {
    // LDR
    if (root == null) {
      return;
    }
    InOrder(root.left, arr);
    System.out.print(root.val + " ");
    arr.add(root.val);
    InOrder(root.right, arr);
  }

  int kthSmallest(ListNode root, int k, ArrayList<Integer> arr) {
    InOrder(root, arr);
    System.out.println("k: "+ k);
    return arr.get(k+1);
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    BST_Traversal obj = new BST_Traversal();
    ListNode root = null;
    // root = obj.InsertNode(root, 25);
    // root = obj.InsertNode(root, 20);
    // root = obj.InsertNode(root, 22);
    // root = obj.InsertNode(root, 17);
    // root = obj.InsertNode(root, 30);
    // root = obj.InsertNode(root, 37);
    // root = obj.InsertNode(root, 28);
    root = obj.InsertNode(root, 3);
    root = obj.InsertNode(root, 1);
    root = obj.InsertNode(root, 4);
    root = obj.InsertNode(root, 2);


    System.out.print("Level Order traversal: ");
    obj.LevelOrder(root);
    System.out.println();

    System.out.print("Pre Order traversal: ");
    obj.PreOrder(root);
    System.out.println();

    System.out.print("Post Order traversal: ");
    obj.PostOrder(root);
    System.out.println();

    System.out.println("answer: " + obj.kthSmallest(root, 1, arr));

    // System.out.print("In-Order traversal: ");
    // obj.InOrder(root);
  }
}
