package graphs.exercise030817.shortestPathInMatrix;

import java.util.*;

/**
 * 11/09/2017
 */
public class MyGraphById {

    private Map<Vertex, List<Vertex>> graph = new HashMap<>();
    private Map<String, Vertex> idVertex = new HashMap<>();

    public MyGraphById() {
    }

    public boolean contains (String key) {
        return idVertex.containsKey(key);
    }

    public void addVertex (Vertex vertex){
        graph.put(vertex, new ArrayList<>());
        idVertex.put(vertex.getKey(), vertex);
    }

    public Vertex getV(String key) {
        return idVertex.get(key);
    }

    public void addChildren(String key, List<Vertex> children) {
        Vertex parent = idVertex.get(key);
        graph.get(parent).addAll(children);
    }

    public void addChild(String key, Vertex children) {
        Vertex parent = idVertex.get(key);
        graph.get(idVertex).add(children);
    }


}
