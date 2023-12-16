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
  Node root1, root2;

  boolean identicalTrees(Node a, Node b) {
    if (a == null && b == null)
      return true;

    if (a != null && b != null) 
      return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

    return false;
  }

  public static void main(String[] args) {
    BTree tree = new BTree();

    tree.root1 = new Node(1);
    tree.root1.left = new Node(2);
    tree.root1.right = new Node(3);
    tree.root1.left.left = new Node(4);
    tree.root1.left.right = new Node(5);

    tree.root2 = new Node(1);
    tree.root2.left = new Node(2);
    tree.root2.right = new Node(3);
    tree.root2.left.left = new Node(4);
    tree.root2.left.right = new Node(5);

    if (tree.identicalTrees(tree.root1, tree.root2))
      System.out.println("Both trees are identical.");
    else
      System.out.println("Trees are not identical");
  }
}
