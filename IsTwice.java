class Node {
  int data;
  Node left, right;

  Node(int newData) {
    data = newData;
    left = right = null;
  }
}

class BTree {
  Node root;

  public boolean isTwice() {
    return isTwice(root, 0);
  }

  private int sum(Node node) {
    if (node == null) 
      return 0;
      
    return node.data + sum(node.left) + sum(node.right);
    }

  private boolean isTwice(Node node, int leftSum) {
    if (node == null) 
      return true;

    int rightSum = sum(node.right);

    if ((leftSum + node.data) * 2 != rightSum)
      return isTwice(node.left, leftSum + node.data) && isTwice(node.right, rightSum);
    else
      return false;
  }

  public static void main(String[] args) {
    BTree tree = new BTree();

    tree.root = new Node(10);
    tree.root.left = new Node(5);
    tree.root.right = new Node(15);
    tree.root.left.left = new Node(5);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(15);

    boolean result = tree.isTwice();

    if (result) 
      System.out.println("The binary tree satisfies the condition.");
    else 
      System.out.println("The binary tree does not satisfy the condition.");
  }
}
