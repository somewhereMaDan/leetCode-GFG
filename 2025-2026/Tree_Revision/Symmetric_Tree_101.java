public class Symmetric_Tree_101 {
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

  boolean check_Symmetric(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
      return false;
    }
    return check_Symmetric(p.left, q.right) && check_Symmetric(p.right, q.left);
  }

  public boolean isSymmetric(TreeNode root) {
    return check_Symmetric(root.left, root.right);
  }
}
