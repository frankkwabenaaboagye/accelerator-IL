package frank.advanceDS.MST;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");
        graph.addCity("E");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 3);

        Map<String, Integer> mst = PrimMST.findMST(graph, "A");


        PrimMST.printMST(mst);
    }
}
