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

  int maxDepth(Node node) {
    if (node == null)
      return 0;

    else {
      // Compute the depth of each subtree
      int lDepth = maxDepth(node.left);
      int rDepth = maxDepth(node.right);

      if (lDepth > rDepth) 
        return (lDepth + 1);

      else return (rDepth + 1);
    }
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("Height of tree is: "+ tree.maxDepth(tree.root));
  }
}

