public class BST_Implement {
  class ListNode {
    int val;
    ListNode left;
    ListNode right;

    ListNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public ListNode InsertNode(ListNode root, int val) {
    if (root == null) {
      return new ListNode(val);
    } else if (val <= root.val) {
      root.left = InsertNode(root.left, val);
    } else {
      root.right = InsertNode(root.right, val);
    }
    return root;
  }

  public int MaxNum(ListNode root) {
    if (root == null) {
      return 0;
    }
    while (root.right != null) {
      root = root.right;
    }
    return root.val;
  }

  public int MinNum(ListNode root) {
    if (root == null) {
      System.out.println("Tree is empty");
    } else if (root.left == null) {
      return root.val;
    }
    return MinNum(root.left);
  }

  public static void main(String[] args) {
    BST_Implement obj = new BST_Implement();
    ListNode root = null;
    root = obj.InsertNode(root, 25);
    root = obj.InsertNode(root, 20);
    root = obj.InsertNode(root, 22);
    root = obj.InsertNode(root, 17);
    root = obj.InsertNode(root, 30);
    root = obj.InsertNode(root, 37);
    root = obj.InsertNode(root, 28);
    System.out.println("max value in tree: " + obj.MaxNum(root));
    System.out.println("min value in tree: " + obj.MinNum(root));
  }
}

//           25
//         /   \
//       20     30
//      /  \   /  \
//    17   22 28   37

// public class BST_Implement {
// class ListNode {
// int data;
// ListNode left, right;

// ListNode(int data) {
// this.data = data;
// this.left = null;
// this.right = null;
// }
// }

// private ListNode head;

// public void Insert(int val) {
// head = insertNode(head, val);
// }

// private ListNode insertNode(ListNode root, int val) {
// if (root == null) {
// return new ListNode(val);
// } else if (val <= root.data) {
// root.left = insertNode(root.left, val);
// } else {
// root.right = insertNode(root.right, val);
// }
// return root;
// }

// public boolean Search(ListNode root, int val) {
// if (root == null) {
// return false;
// } else if (root.data == val) {
// return true;
// } else if (val <= root.data) {
// return Search(root.left, val);
// } else {
// return Search(root.right, val);
// }
// }

// public static void main(String[] args) {
// BST_Implement obj = new BST_Implement();
// obj.Insert(15);
// obj.Insert(10);
// obj.Insert(20);
// obj.Insert(25);

// System.out.println(obj.Search(obj.head, 10));
// }
// }
