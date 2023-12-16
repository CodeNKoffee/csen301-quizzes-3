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

  public boolean isBST() {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST(Node node, int min, int max) {
    if (node == null) 
      return true;

    if (node.data <= min || node.data >= max) 
      return false;

    return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    
    tree.root = new Node(2);
    tree.root.left = new Node(1);
    tree.root.right = new Node(3);

    if (tree.isBST()) 
      System.out.println("Tree is a BST");
    else
      System.out.println("Tree is not a BST");
  }
}