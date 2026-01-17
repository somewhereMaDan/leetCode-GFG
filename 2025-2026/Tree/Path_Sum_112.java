public class Path_Sum_112 {
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

  boolean hasPathSum(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    target = target - root.val;

    if (root.left == null && root.right == null) {
      return target == 0;
    }

    return hasPathSum(root.left, target) || hasPathSum(root.right, target);
  }
}
