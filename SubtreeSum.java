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

  public BTree findSubtree() {
    BTree resultTree = new BTree();
    findAndCopySubtree(root, root.data, resultTree);
    return resultTree;
  }

  private void findAndCopySubtree(Node node, int targetSum, BTree resultTree) {
    if (node == null)
      return;

    int currentSum = sum(node);
    if (currentSum == targetSum) {
      BTree subtree = new BTree();
      copySubtree(node, subtree);
      resultTree.root = addTreeRecursive(resultTree.root, subtree.root);
    }
    findAndCopySubtree(node.left, targetSum, resultTree);
    findAndCopySubtree(node.right, targetSum, resultTree);
  }

  private int sum(Node node) {
    if (node == null)
      return 0;

    return node.data + sum(node.left) + sum(node.right);
  }

  private void copySubtree(Node node, BTree subtree) {
    if (node != null) {
      subtree.root = addTreeRecursive(subtree.root, new Node(node.data));
      copySubtree(node.left, subtree);
      copySubtree(node.right, subtree);
    }
  }

  private Node addTreeRecursive(Node current, Node newNode) {
    if (current == null)
      return newNode;

    if (newNode.data < current.data)
      current.left = addTreeRecursive(current.left, newNode);
    else if (newNode.data > current.data)
      current.right = addTreeRecursive(current.right, newNode);

    return current;
  }

  public void printTree() {
    printInOrder(root);
  }

  private void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.print(node.data + " ");
      printInOrder(node.right);
    }
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    tree.root = new Node(50);
    tree.root.left = new Node(30);
    tree.root.right = new Node(20);
    tree.root.left.left = new Node(20);
    tree.root.left.right = new Node(40);
    tree.root.right.left = new Node(60);
    tree.root.right.right = new Node(80);

    System.out.println("Original Tree:");
    tree.printTree();

    System.out.println();

    BTree resultTree = tree.findSubtree();
    System.out.print("Resultant Tree: ");
    resultTree.printTree();
  }
}
