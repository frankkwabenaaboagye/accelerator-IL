package frank.advanceDS.roadnetwork;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(String from, String to, int distance) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(to, distance));
        adjList.get(to).add(new Edge(from, distance)); // Assuming undirected roads
    }

    public Map<String, Integer> dijkstra(String start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<String, Integer> dist = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String city : adjList.keySet()) {
            dist.put(city, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentCity = currentNode.city;

            if (visited.contains(currentCity)) continue;
            visited.add(currentCity);

            for (Edge edge : adjList.get(currentCity)) {
                String neighbor = edge.to;
                int newDist = dist.get(currentCity) + edge.distance;

                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    pq.add(new Node(neighbor, newDist));
                }
            }
        }

        return dist;
    }

    class Edge {
        String to;
        int distance;

        Edge(String to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    class Node {
        String city;
        int distance;

        Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
}

