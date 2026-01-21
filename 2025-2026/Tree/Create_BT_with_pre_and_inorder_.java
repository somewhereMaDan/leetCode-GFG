public class Create_BT_with_pre_and_inorder_ {
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

  TreeNode insert(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = insert(nums, left, mid - 1);
    root.right = insert(nums, mid + 1, right);

    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    TreeNode root = new TreeNode(preorder[0]);
    int rootIndex = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root.val) {
        rootIndex = i;
      }
    }

    // left skewed
    if (rootIndex == inorder.length - 1) {
      for (int i = inorder.length - 2; i >= 0; i--) {
        root.left = new TreeNode(inorder[i]);
        // root = root.left;
      }
    }
    // right skewed
    else if (rootIndex == 0) {
      for (int i = 1; i < inorder.length; i++) {
        root.right = new TreeNode(inorder[i]);
        root = root.right;
      }
    } else {
      // build leftSubtree
      root.left = insert(inorder, 0, rootIndex - 1);

      // build rightSubtree
      root.right = insert(inorder, rootIndex + 1, inorder.length - 1);
    }

    return root;
  }
  public static void main(String[] args) {
    
  }
}
