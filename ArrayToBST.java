// LEVEL 1

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

	public Node sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) 
			return null;

		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	private void preOrder(Node node) {
		if (node == null) 
			return;

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		BTree tree = new BTree();
		int arr[] = new int[] { 1, 2, 3, 4 };
		int n = arr.length;
    
		tree.root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		tree.preOrder(tree.root);
	}
}
