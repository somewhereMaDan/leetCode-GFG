public class Check_BST {
  class ListNode {
    int val;
    ListNode left;
    ListNode right;

    ListNode(int val) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  boolean Is_BST(ListNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }
    return Is_BST(root.left, min, root.val) && Is_BST(root.right, root.val, max);
  }

  ListNode InsertNode(ListNode root, int val) {
    if (root == null) {
      return new ListNode(val);
    }
    if (val <= root.val) {
      root.left = InsertNode(root.left, val);
    } else {
      root.right = InsertNode(root.right, val);
    }
    return root;
  }

  public static void main(String[] args) {
    Check_BST obj = new Check_BST();
    ListNode root = null;
    root = obj.InsertNode(root, 25);
    root = obj.InsertNode(root, 20);
    root = obj.InsertNode(root, 22);
    root = obj.InsertNode(root, 17);
    root = obj.InsertNode(root, 30);
    root = obj.InsertNode(root, 37);
    root = obj.InsertNode(root, 28);

    System.out.println(obj.Is_BST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
}


//              25
//            /    \
//          /        \
//        20           30
//      /   \        /    \
//    17     22     28     37
//   /  \   /  \   /  \   /   \ 
// 16   18 21  23 26  29 35   40
