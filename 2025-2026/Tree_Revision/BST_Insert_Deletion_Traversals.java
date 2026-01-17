public class BST_Insert_Deletion_Traversals {
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

  TreeNode Insert(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (val <= root.val) {
      root.left = Insert(root.left, val);
    } else {
      root.right = Insert(root.right, val);
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

  void PostOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    PostOrder(root.left);
    PostOrder(root.right);
    System.out.print(root.val + " ");
  }

  void InOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    InOrder(root.left);
    System.out.print(root.val + " ");
    InOrder(root.right);
  }

  TreeNode MaxNode(TreeNode root) {
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  // For delete we have three condition
  TreeNode Delete(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    if (target < root.val) {
      root.left = Delete(root.left, target);
    } else if (target > root.val) {
      root.right = Delete(root.right, target);
    } else {
      // Now it means we have found the target
      // Case 1: No Child
      if (root.left == null && root.right == null) {
        root = null;
      }
      // Case 2: One Child
      else if (root.left != null && root.right == null) {
        root = root.left;
      } else if (root.left == null && root.right != null) {
        root = root.right;
      }
      // Case 3 : Two Child
      else {
        TreeNode maxNode = MaxNode(root.left);
        root.val = maxNode.val;
        root.left = Delete(root.left, maxNode.val);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    BST_Insert_Deletion_Traversals obj = new BST_Insert_Deletion_Traversals();
    TreeNode root = null;
    root = obj.Insert(root, 7);
    root = obj.Insert(root, 5);
    root = obj.Insert(root, 4);
    root = obj.Insert(root, 6);

    root = obj.Insert(root, 9);
    root = obj.Insert(root, 8);
    root = obj.Insert(root, 10);

    root = obj.Insert(root, 2);
    root = obj.Insert(root, 7);
    root = obj.Insert(root, 9);

    // obj.PreOrder(root);
    obj.InOrder(root);
    // obj.PostOrder(root);
    obj.Delete(root, 5);
    System.out.println();

    obj.InOrder(root);
  }
}