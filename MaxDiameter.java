class Node {
  int data;
  Node left, right;

  Node (int newObj) {
    data = newObj;
    left = right = null;
  }
}

class BTree {
  public int diameterOfBTree(Node root) {
    int[] result = dfs(root);
    return result[1];
  }

  private int[] dfs(Node node) {
    if (node == null) 
      return new int[]{0, 0};

    int[] leftResult = dfs(node.left);
    int[] rightResult = dfs(node.right);

    int currentDepth = 1 + Math.max(leftResult[0], rightResult[0]);
    int currentDiameter = Math.max(leftResult[0] + rightResult[0], Math.max(leftResult[1], rightResult[1]));

    return new int[]{currentDepth, currentDiameter};
  }

  public static void main(String[] args) {
    BTree treeDiameter = new BTree();

    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);

    System.out.println(treeDiameter.diameterOfBTree(root1));

    Node root2 = new Node(1);
    root2.left = new Node(2);
    root2.right = new Node(3);
    root2.left.left = new Node(4);
    root2.left.right = new Node(5);
    root2.right.right = new Node(6);

    System.out.println(treeDiameter.diameterOfBTree(root2));
  }
}