package frank.advanceDS.graph;

public class DFSExample {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("DFS traversal starting from node 0:");
        graph.dfs(0);  // Start DFS traversal from node 0
    }
}
