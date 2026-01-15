public class Balanced_BST {
  class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  int check(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = check(root.left);
    int right = check(root.right);

    if (left == -1 || right == -1) {
      return -1;
    }

    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }

  boolean balanceTree(TreeNode root) {
    return check(root) != -1;
  }

  TreeNode InsertNode(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (val <= root.val) {
      root.left = InsertNode(root.left, val);
    } else {
      root.right = InsertNode(root.right, val);
    }
    return root;
  }

  void InOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    InOrder(root.left);
    System.out.print(root.val + " ");
    InOrder(root.right);
  }

  public static void main(String[] args) {
    Balanced_BST obj = new Balanced_BST();
    TreeNode root = null;

    root = obj.InsertNode(root, 15);
    root = obj.InsertNode(root, 7);
    root = obj.InsertNode(root, 4);
    root = obj.InsertNode(root, 9);

    root = obj.InsertNode(root, 20);

    System.out.println("InOrder traversal: ");
    obj.InOrder(root);

    System.out.println(obj.balanceTree(root));
  }
}
