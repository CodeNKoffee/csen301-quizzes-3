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

  public void mirror() {
    mirror(root);
  }

  private void mirror(Node node) {
    if (node != null) {
      Node temp = node.left;
      node.left = node.right;
      node.right = temp;
      mirror(node.left);
      mirror(node.right);
    }
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if (node == null)
      return;
    
    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
  }

  public static void main(String[] args) {
    BTree tree = new BTree();

    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("In order traversal of the constructed tree is: ");
    tree.inOrder();
    System.out.println("");

    tree.mirror();

    System.out.println("In order traversal of the mirrored tree is: ");
    tree.inOrder();
  }
}