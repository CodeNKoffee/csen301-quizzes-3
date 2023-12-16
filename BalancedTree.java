// LEVEL 1

class Node {
  int data;
  Node left, right;

  Node (int newObj) {
    data = newObj;
    left = right = null;
  }
}

class BTree {
  Node root;

  public boolean isBalanced(Node node) {
    return checkBalance(node) != -1;
  }

  private int checkBalance(Node node) {
    if (node == null) 
      return 0;

    int leftHeight = checkBalance(node.left);
    if (leftHeight == -1)
      return -1;

    int rightHeight = checkBalance(node.right);
    if (rightHeight == -1)
      return -1;

    if (Math.abs(leftHeight - rightHeight) > 1) 
      return -1;

    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static void main(String[] args) {
    BTree tree = new BTree();

    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.left.left.left = new Node(8);

    if (tree.isBalanced(tree.root))
      System.out.println("Tree is balanced");
    else
      System.out.println("Tree is not balanced");
  }
}