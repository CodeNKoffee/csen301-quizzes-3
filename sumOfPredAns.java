class Node {
  int data;
  Node left, right;

  Node(int newData) {
    data = newData;
    left = right = null;
  }
}

class Btree {
  Node root;

  public boolean sumPred() {
    return sumPred(root);
  }

  private int sumChildren(Node node) {
    if (node == null) {
      return 0;
    }

    return node.data + sumChildren(node.left) + sumChildren(node.right);
  }

  private boolean sumPred(Node node) {
    if (node == null) {
      return true; // An empty tree satisfies the condition
    }

    int sumOfChildren = sumChildren(node.left) + sumChildren(node.right);

    if (node.data != sumOfChildren) {
      return false;
    }

    return sumPred(node.left) && sumPred(node.right);
  }
}
