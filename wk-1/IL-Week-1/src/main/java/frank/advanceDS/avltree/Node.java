package frank.advanceDS.avltree;

public class Node {
    int value;
    Node left, right;
    int height;

    public Node(int value) {
        this.value = value;
        this.height = 1;
    }
}

