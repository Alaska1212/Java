package hw8;
import java.util.*;

public class B08_03 {
    public static class Graph {
        private Map<String, Set<String>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        // додає вершину
        public void addVertex(String vertex) {
            adjList.putIfAbsent(vertex, new HashSet<>());
        }

        // видаляє вершину
        public void removeVertex(String vertex) {
            adjList.remove(vertex);
            for (Set<String> neighbors : adjList.values()) {
                neighbors.remove(vertex);
            }
        }

        // додає ребро між двома вершинами
        public void addEdge(String v1, String v2) {
            addVertex(v1);
            addVertex(v2);
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        // видаляє ребро між двома вершинами
        public void removeEdge(String v1, String v2) {
            if (adjList.containsKey(v1)) adjList.get(v1).remove(v2);
            if (adjList.containsKey(v2)) adjList.get(v2).remove(v1);
        }

        // виводить список суміжності
        public void printGraph() {
            for (String vertex : adjList.keySet()) {
                System.out.println(vertex + " -> " + adjList.get(vertex));
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // додаємо вершини
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // додаємо ребра
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        System.out.println("граф після додавання вершин і ребер:");
        graph.printGraph();

        // видаляємо ребро
        graph.removeEdge("A", "B");
        System.out.println("\nпісля видалення ребра A-B:");
        graph.printGraph();

        // видаляємо вершину
        graph.removeVertex("C");
        System.out.println("\nпісля видалення вершини C:");
        graph.printGraph();
    }
}

