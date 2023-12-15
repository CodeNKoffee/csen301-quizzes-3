class Node {
  int data;
  Node left, right;

  Node(int newData) {
    data = newData;
    left = right = null;
  }
}

class BTree {
  private Node root;

  public BTree() {
    root = null;
  }

  public BTree createCommonTree(BTree otherTree) {
    BTree commonTree = new BTree();
    createCommonTreeRecursive(this.root, otherTree.root, commonTree);
    return commonTree;
  }

  private void createCommonTreeRecursive(Node node1, Node node2, BTree commonTree) {
    if (node1 != null && node2 != null) {
      if (node1.data == node2.data) {
        if (commonTree.root == null) {
          commonTree.root = new Node(node1.data);
        } else {
          addRecursive(commonTree.root, node1.data);
        }
        createCommonTreeRecursive(node1.left, node2.left, commonTree);
        createCommonTreeRecursive(node1.right, node2.right, commonTree);
      } else {
        createCommonTreeRecursive(node1.left, node2, commonTree);
        createCommonTreeRecursive(node1.right, node2, commonTree);
      }
    }
  }

  private void addRecursive(Node node, int key) {
    if (key < node.data) {
      if (node.left == null) {
        node.left = new Node(key);
      } else {
        addRecursive(node.left, key);
      }
    } else if (key > node.data) {
      if (node.right == null) {
        node.right = new Node(key);
      } else {
        addRecursive(node.right, key);
      }
    }
  }

  public void displayTree() {
    // Your existing displayTree method code
  }

  public static void main(String[] args) {
    BTree tree1 = new BTree();
    tree1.root = new Node(50);
    tree1.root.left = new Node(30);
    tree1.root.right = new Node(70);
    tree1.root.left.left = new Node(20);
    tree1.root.left.right = new Node(40);
    tree1.root.right.left = new Node(60);
    tree1.root.right.right = new Node(80);

    System.out.println("Tree 1:");
    tree1.displayTree();

    BTree tree2 = new BTree();
    tree2.root = new Node(50);
    tree2.root.left = new Node(30);
    tree2.root.right = new Node(70);
    tree2.root.left.left = new Node(20);
    tree2.root.left.right = new Node(40);
    tree2.root.right.left = new Node(55);
    tree2.root.right.right = new Node(80);

    System.out.println("\nTree 2:");
    tree2.displayTree();

    BTree commonTree = tree1.createCommonTree(tree2);

    System.out.println("\nCommon Tree:");
    commonTree.displayTree();
  }
}
