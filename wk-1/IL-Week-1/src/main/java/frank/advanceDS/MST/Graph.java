package frank.advanceDS.MST;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addCity(String city) {
        adjList.putIfAbsent(city, new ArrayList<>());
    }

    public void addEdge(String city1, String city2, int cost) {
        adjList.get(city1).add(new Edge(city2, cost));
        adjList.get(city2).add(new Edge(city1, cost)); // Because the graph is undirected
    }

    public List<Edge> getEdges(String city) {
        return adjList.get(city);
    }

    public Set<String> getCities() {
        return adjList.keySet();
    }

    public static class Edge {
        String city;
        int cost;

        public Edge(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        public String getCity() {
            return city;
        }

        public int getCost() {
            return cost;
        }
    }
}

