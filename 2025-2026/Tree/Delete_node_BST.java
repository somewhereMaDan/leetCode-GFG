public class Delete_node_BST {
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

  TreeNode FindMin(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  void PreOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + " ");
    PreOrder(root.left);
    PreOrder(root.right);
  }

  TreeNode deleteNode(TreeNode root, int val) {
    if (root == null) {
      return root;
    } else if (val < root.val) {
      root.left = deleteNode(root.left, val);
    } else if (val > root.val) {
      root.right = deleteNode(root.right, val);
    } else {
      // We found the element we want to delete

      // Case 1: no child
      if (root.left == null && root.right == null) {
        root = null;
      }

      // Case 2 : 1 Child
      else if (root.left == null) {
        TreeNode temp = root;
        root = root.right;
        temp = null; // although we don't delete node from heap in java, I wrote just to make sense
      } else if (root.right == null) {
        root = root.left;
      }

      // Case 3 : 2 Child
      else {
        TreeNode minNode = FindMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = null;
    Delete_node_BST obj = new Delete_node_BST();
    root = obj.InsertNode(root, 12);

    // forming left subtree
    obj.InsertNode(root, 5);
    obj.InsertNode(root, 3);
    obj.InsertNode(root, 7);
    obj.InsertNode(root, 9);
    obj.InsertNode(root, 8);
    obj.InsertNode(root, 11);
    obj.InsertNode(root, 1);

    // forming right subtree
    obj.InsertNode(root, 15);
    obj.InsertNode(root, 13);
    obj.InsertNode(root, 14);
    obj.InsertNode(root, 17);
    obj.InsertNode(root, 20);
    obj.InsertNode(root, 18);

    System.out.println("PreOrder Traversal before deletion: ");
    obj.PreOrder(root);

    root = obj.deleteNode(root, 17);

    System.out.println();
    System.out.println("PreOrder Traversal before deletion: ");
    obj.PreOrder(root);

  }
}