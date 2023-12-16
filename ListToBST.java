// LEVEL 3

class Link {
  int val;
  Link next;

  Link(int x) {
    val = x;
    next = null;
  }
}

class Node {
  int data;
  Node left, right;

  Node(int newObj) {
    data = newObj;
    left = right = null;
  }
}

class BTree {
  private Link current;

  public Node sortedListToBST(Link head) {
    int length = findLength(head);
    current = head;
    return sortedListToBST(length);
  }

  private int findLength(Link head) {
    int length = 0;
    Link current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    return length;
  }

  private Node sortedListToBST(int length) {
    if (length <= 0)
      return null;

    Node left = sortedListToBST(length / 2);
    Node root = new Node(current.val);
    current = current.next;
    Node right = sortedListToBST(length - length / 2 - 1);
    root.left = left;
    root.right = right;

    return root;
  }

  private void inOrderTraversal(Node root) {
    if (root != null) {
      inOrderTraversal(root.left);
      System.out.println(root.data + " ");
      inOrderTraversal(root.right);
    }
  }

  public static void main(String[] args) {
    Link head = new Link(1);
    head.next = new Link(2);
    head.next.next = new Link(3);

    BTree converter = new BTree();
    Node root = converter.sortedListToBST(head);

    System.out.println("Inorder traversal of Balanced BST:");
    converter.inOrderTraversal(root);
  }
}