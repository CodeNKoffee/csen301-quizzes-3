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
  public boolean isSymmetric(Node root) {
    if (root == null)
      return true;
    
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(Node left, Node right) {
    if (left == null && right == null) 
      return true;

    if (left == null || right == null)
      return false;

    return (left.data == right.data) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }

  public static void main(String[] args) {
    BTree tree = new BTree();

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(2);
    root.right.right = new Node(3);
    root.right.left = new Node(4);
    root.left.left = new Node(3);
    root.left.right = new Node(4);


    System.out.println("Is the tree symmetrical?\n" + "Answer: " + tree.isSymmetric(root));
  }
}