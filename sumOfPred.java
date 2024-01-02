class Node {
  int data;
  Node left, right;

  Node(int newObj) {
    data = newObj;
    left = right = null;
  }
}

class Btree {
  Node root;

  public boolean sumPred(Node node) {
    return sumPred(root, root);
  }

  private boolean sumPred(Node node, Node root) {
    if (node == null) 
      return false;

    if (node.left.data + node.right.data == root.data) 
      return true;

    if (node.left.data + node.right.data >= root.data)
      return false;

    return sumPred(node.left, root) && sumPred(node.right, root);
  }  
}