public class Symmetric_Tree {
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

  public void PreOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    PreOrder(root.left);
    PreOrder(root.right);
  }

  boolean checkTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) {
      return false;
    }
    return checkTree(p.left, q.right) && checkTree(p.right, q.left);
  }

  boolean isSymmetric(TreeNode root) {
    return checkTree(root.left, root.right);
  }

  public static void main(String[] args) {
    Symmetric_Tree obj = new Symmetric_Tree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.left = new TreeNode(4);

    obj.PreOrder(root);
    System.out.println(obj.isSymmetric(root));
  }
}
