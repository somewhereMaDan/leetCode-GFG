public class Count_Complete_tree_nodes_222 {
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

  int right(TreeNode root) {
    int h = 0;
    while (root != null) {
      h++;
      root = root.right;
    }
    return h;
  }

  int left(TreeNode root) {
    int h = 0;
    while (root != null) {
      h++;
      root = root.left;
    }
    return h;
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = left(root);
    int right = right(root);

    if (left == right) {
      return (int) Math.pow(2, left) - 1;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
