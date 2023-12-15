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

  // Function to find the largest value in each level of the binary tree
  public void findLargestValuesPerLevel() {
    if (root == null) {
      System.out.println("Tree is empty.");
      return;
    }

    QueueObj queue = new QueueObj(100); // Adjust the size accordingly
    ArrayStack stack = new ArrayStack(100); // Adjust the size accordingly

    queue.enqueue(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      int levelMax = Integer.MIN_VALUE;

      for (int i = 0; i < levelSize; i++) {
        Node current = (Node) queue.dequeue();
        levelMax = Math.max(levelMax, current.data);

        if (current.left != null) 
            queue.enqueue(current.left);

        if (current.right != null) 
            queue.enqueue(current.right);
      }

      stack.push(levelMax);
    }

    System.out.println("Largest values in each level:");
    while (!stack.isEmpty()) 
      System.out.println(stack.pop());
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    // Construct your binary tree here

    // Example tree:
    //        10
    //       /  \
    //      5   15
    //     / \    \
    //    3   7    20

    tree.root = new Node(10);
    tree.root.left = new Node(5);
    tree.root.right = new Node(15);
    tree.root.left.left = new Node(3);
    tree.root.left.right = new Node(7);
    tree.root.right.right = new Node(20);

    System.out.println("Largest values in each level:");
    tree.findLargestValuesPerLevel();
  }
}