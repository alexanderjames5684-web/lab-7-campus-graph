# Lab 7 - Campus Graph and DFS Traversal

## Description

This lab focuses on using a graph data structure in Java. The graph represents labeled buildings on Tri-C's Western Campus map. Each building is stored as a vertex, and each walking connection between buildings is stored as an edge.

The program creates an unweighted graph, performs a depth-first search starting from the Business & Technology building, prints the DFS search order, displays parent-child relationships, prints paths from Business & Technology to selected buildings, and prints the full DFS tree.

## Buildings Used as Vertices

The following buildings were added as vertices:

| Vertex Number | Building                   |
| ------------- | -------------------------- |
| 0             | Liberal Arts               |
| 1             | Student Services           |
| 2             | Health Careers & Sciences  |
| 3             | Health Technologies Center |
| 4             | Recreation Center          |
| 5             | Technology Learning Center |
| 6             | Business & Technology      |
| 7             | Theatre                    |

## Program Features

This program completes the following tasks:

* Adds vertices for all labeled buildings on the campus map
* Adds edges between buildings that are directly connected by walking paths
* Creates an unweighted graph using the vertices and edges
* Performs a depth-first search starting from `Business & Technology`
* Prints the DFS search order
* Prints the parent-child relationships from the DFS traversal
* Prints the path from `Business & Technology` to `Health Technologies Center`
* Prints the path from `Business & Technology` to `Student Services`
* Prints the path from `Business & Technology` to `Recreation Center`
* Prints the entire DFS tree

## Files Included

* `Main.java`
* `Edge.java`
* `Graph.java`
* `UnweightedGraph.java`

## Starting Vertex

The depth-first search starts at:

```java
Business & Technology
```

This building is vertex `6` in the graph.

## Example Code

The graph is created using an array of building names and an array of edges:

```java
String[] vertices = {
  "Liberal Arts",
  "Student Services",
  "Health Careers & Sciences",
  "Health Technologies Center",
  "Recreation Center",
  "Technology Learning Center",
  "Business & Technology",
  "Theatre"
};
```

The DFS traversal is started with:

```java
UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);
```

## Expected Output

The exact DFS order may vary depending on the order of the edges in the graph. However, the program should display:

* The graph edges
* The DFS search order
* Parent-child relationships
* Paths from Business & Technology to selected buildings
* The full DFS tree

Example sections of the output include:

```text
DFS search order starting from Business & Technology:
Business & Technology Technology Learning Center Student Services Liberal Arts Theatre Health Careers & Sciences Health Technologies Center Recreation Center

Parent-child relationships:
Business & Technology is the root
Student Services -> Liberal Arts
Technology Learning Center -> Student Services
Health Careers & Sciences -> Health Technologies Center
Health Careers & Sciences -> Recreation Center
Business & Technology -> Technology Learning Center
Technology Learning Center -> Business & Technology
Liberal Arts -> Theatre
```

## What I Learned

In this lab, I learned how graphs can be used to represent real-world locations and connections. I practiced creating vertices and edges, using an unweighted graph, and performing a depth-first search. I also learned how DFS creates a search tree that can be used to show traversal order, parent-child relationships, and paths between vertices.
