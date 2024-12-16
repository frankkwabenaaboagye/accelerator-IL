package frank.advanceDS.avltree;

public class MyAVLTree {
    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return balance(node);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;
                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.value = temp.value;
                root.right = delete(root.right, temp.value);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balance(root);
    }


    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.value) {
            return search(node.left, value);
        } else if (value > node.value) {
            return search(node.right, value);
        }

        return true;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate the subtree rooted at x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Balance the node
    private Node balance(Node node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        if (balanceFactor < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }


    public void printTree() {
        printTree(root, "", true);
    }

    // Helper method to recursively print the tree structure
    private void printTree(Node node, String indent, boolean isLeft) {
        if (node != null) {
            // Print the current node
            System.out.println(indent + (isLeft ? "L---- " : "R---- ") + node.value);

            // Recursively print the left and right children
            printTree(node.left, indent + (isLeft ? "|     " : "      "), true);
            printTree(node.right, indent + (isLeft ? "|     " : "      "), false);
        }
    }

    public static void main(String[] args) {
        MyAVLTree tree = new MyAVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder();

        System.out.println("\nSearch 20 in the AVL tree: " + tree.search(20));
        System.out.println("Search 25 in the AVL tree: " + tree.search(25));

        tree.delete(20);

        System.out.println("\nInorder traversal after deletion:");
        tree.inorder();

    }
}

