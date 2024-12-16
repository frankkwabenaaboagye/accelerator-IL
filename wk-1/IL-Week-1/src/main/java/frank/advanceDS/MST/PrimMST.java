package frank.advanceDS.MST;

import java.util.*;

import java.util.*;

public class PrimMST {
    public static Map<String, Integer> findMST(Graph graph, String startCity) {
        Map<String, Integer> mst = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Graph.Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Graph.Edge::getCost));

        visited.add(startCity);
        for (Graph.Edge edge : graph.getEdges(startCity)) {
            pq.add(edge);
        }

        int totalCost = 0;

        while (!pq.isEmpty()) {
            Graph.Edge edge = pq.poll();
            String city = edge.getCity();
            int cost = edge.getCost();

            if (!visited.contains(city)) {
                visited.add(city);
                mst.put(city, cost);
                totalCost += cost;

                for (Graph.Edge nextEdge : graph.getEdges(city)) {
                    if (!visited.contains(nextEdge.getCity())) {
                        pq.offer(nextEdge);
                    }
                }
            }
        }
        System.out.println("Total cost of MST: " + totalCost);
        return mst;
    }

    public static void printMST(Map<String, Integer> mst) {
        for (Map.Entry<String, Integer> entry : mst.entrySet()) {
            System.out.println("City: " + entry.getKey() + ", Cost: " + entry.getValue());
        }
    }
}

