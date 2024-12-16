package frank.advanceDS.roadnetwork;

import java.util.Map;

public class DijkstraExample {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges (roads) with distances
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 1);
        graph.addEdge("C", "E", 5);

        Map<String, Integer> distances = graph.dijkstra("A");
        
        System.out.println("Shortest distances from city A:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
