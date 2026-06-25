import java.util.*;

class Main {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    String[] vertices = {
      "Liberal Arts",                 // vertex 0
      "Student Services",             // vertex 1
      "Health Careers & Sciences",    // vertex 2
      "Health Technologies Center",   // vertex 3
      "Recreation Center",            // vertex 4
      "Technology Learning Center",   // vertex 5
      "Business & Technology",        // vertex 6
      "Theatre"                       // vertex 7
    };

    // 2. Define edges based on connected walking areas
    // Since walking paths go both ways, each connection is added twice.
    int[][] edges = {
      {0, 1}, {1, 0}, // Liberal Arts <-> Student Services
      {0, 7}, {7, 0}, // Liberal Arts <-> Theatre

      {1, 2}, {2, 1}, // Student Services <-> Health Careers & Sciences
      {1, 5}, {5, 1}, // Student Services <-> Technology Learning Center

      {2, 3}, {3, 2}, // Health Careers & Sciences <-> Health Technologies Center
      {2, 4}, {4, 2}, // Health Careers & Sciences <-> Recreation Center

      {4, 5}, {5, 4}, // Recreation Center <-> Technology Learning Center

      {5, 6}, {6, 5}, // Technology Learning Center <-> Business & Technology

      {6, 7}, {7, 6}  // Business & Technology <-> Theatre
    };

    // 3. Create the graph using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

    // Optional: print edges to check the graph
    System.out.println("Graph edges:");
    graph.printEdges();
    System.out.println();

    // 4. Perform DFS starting from Business & Technology
    int startVertex = 6;
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(startVertex);

    // 5. Retrieve and print the search order of the DFS traversal
    System.out.println("DFS search order starting from Business & Technology:");
    for (int index : dfs.getSearchOrder()) {
      System.out.print(graph.getVertex(index) + " ");
    }
    System.out.println();
    System.out.println();

    // 6. Print the parent-child relationships for each vertex during DFS traversal
    System.out.println("Parent-child relationships:");
    for (int i = 0; i < graph.getSize(); i++) {
      int parent = dfs.getParent(i);

      if (parent != -1) {
        System.out.println(
          graph.getVertex(parent) + " -> " + graph.getVertex(i)
        );
      }
      else {
        System.out.println(graph.getVertex(i) + " is the root");
      }
    }
    System.out.println();

    // 7. Call printPath() to display paths from Business & Technology
    dfs.printPath(3); // Health Technologies Center
    System.out.println();

    dfs.printPath(1); // Student Services
    System.out.println();

    dfs.printPath(4); // Recreation Center
    System.out.println();
    System.out.println();

    // 8. Call printTree() to print the entire DFS tree
    dfs.printTree();
  }
}