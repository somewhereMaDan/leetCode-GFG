import java.util.*;

public class BST_ZigZag {
  static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
      this.left = null;
      this.right = null;
      this.val = val;
    }
  }

  public List<List<Integer>> zigZag(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    boolean rightToLeft = true;
    Queue<TreeNode> que = new ArrayDeque<>();
    que.add(root);

    while (!que.isEmpty()) {
      LinkedList<Integer> level = new LinkedList<>();
      int size = que.size();
      System.out.print(que.peek().val + " ");

      for (int i = 0; i < size; i++) {
        TreeNode node = que.poll();
        if (rightToLeft == true) {
          level.addLast(node.val);
        } else {
          level.addFirst(node.val);
        }
        if (node.left != null)
          que.add(node.left);
        if (node.right != null)
          que.add(node.right);
      }
      result.add(level);
      rightToLeft = !rightToLeft;
    }
    return result;
  }

  public static void main(String[] args) {
    BST_ZigZag obj = new BST_ZigZag();

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    // root.left.left = new TreeNode();
    // root.left.right = new TreeNode(11);
    root.right = new TreeNode(20);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(15);

    System.out.println(obj.zigZag(root));
  }
}
