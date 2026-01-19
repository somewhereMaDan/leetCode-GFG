public class Subtree_of_another_tree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  boolean SameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
      return false;
    }
    return SameTree(p.left, q.left) && SameTree(p.right, q.right);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }
    if (SameTree(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
}
