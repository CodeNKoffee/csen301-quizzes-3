class Node {
  int data;
  Node left, right;

  Node(int newObj) {
    data = newObj;
    left = right = null;
  }
}

class BTree {
  Node root;

  static boolean isOdd(Node root) {
    if (root == null)
      return true;
    
    if (root.data % 2 == 0) 
      return false;

    return (isOdd(root.left) && isOdd(root.right));
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    
    tree.root = new Node(1);
    tree.root.left = new Node(1);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println(isOdd(tree.root) ? "Tree is odd." : "Tree isn't odd.");
  }
}