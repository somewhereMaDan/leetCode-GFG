public class LCA_of_BST {
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

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Three Cases
    // When both p,q is smaller than root value
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    // both p,q is greater than root value
    else if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    // one smaller and one greater, or one equal. (Then the curr root is LCA)
    return root;
  }
}
