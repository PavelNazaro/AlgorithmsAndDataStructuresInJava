package Lesson7.Homework;

import Lesson7.Lesson.Graph;
import Lesson7.Lesson.Vertex;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        
        for (int i = 0; i < 10; i++) {
            graph.addVertex(String.valueOf(i + 1));
        }

        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "5");
        graph.addEdge("5", "6");
        graph.addEdge("6", "7");
        graph.addEdge("7", "8");
        graph.addEdge("8", "9");
        graph.addEdge("9", "10");
        graph.addEdge("1", "10");

        System.out.println(graph.depthFirstSearch(new Vertex("1")));
        System.out.println(graph.breadthFirstSearch(new Vertex("1"), new Vertex("10")));
    }
}
