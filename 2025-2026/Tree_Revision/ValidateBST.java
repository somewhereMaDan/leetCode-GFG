public class ValidateBST {
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

  boolean check(TreeNode root, long left, long right) {
    if (root == null) {
      return true;
    }
    if (root.val <= left || root.val >= right) {
      return false;
    }
    return check(root.left, left, root.val) && check(root.right, root.val, right);
  }

  public boolean isValidBST(TreeNode root) {
    return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}
