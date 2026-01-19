import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Binary_Tree_right_side_view_199 {
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

  public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> arr = new ArrayList<>();
    if (root == null) {
      return arr;
    }
    Deque<TreeNode> dq = new ArrayDeque<>();
    dq.add(root);

    while (!dq.isEmpty()) {
      int size = dq.size();
      arr.add(dq.peekLast().val);

      for (int i = 0; i < size; i++) {
        TreeNode curr = dq.pollFirst(); // 1
        if (curr.left != null) {
          dq.add(curr.left);
        }
        if (curr.right != null) {
          dq.add(curr.right);
        }
      }
    }
    return arr;
  }
}
