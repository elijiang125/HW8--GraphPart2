import java.sql.Array;
import java.util.*;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    // TODO: Initialize the nodes
    public void init(int n){
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
    }

    // TODO: not tested for credit technically but this method should reset your node's value
    public void reset(){
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setValue(0);
        }
    }

    // TODO: First, create the edge with Edge constructor. Second, Update the source's edgeList.
    // Third, update the destination's previous node structure
    public void addEdge(Node src, Node dest, int weight){
        Edge newEdge = new Edge(dest, weight);

        src.getEdges().add(newEdge);
        //src.setValue(weight);

        dest.setPrev(src);

    }

    // TODO: remove the edge from the Node
    // First, find the edge from the src node in edgeList
    // Second, remove the edge from the edgeList
    // Third, set the prev Node from dest to null
    public void removeEdge(Node src, Node dest){

        for (int i = 0; i < src.getEdges().size(); i++) {
            if (src.getEdges().get(i).getDestVertex() == dest) {
                dest.setPrev(null);
                src.getEdges().remove(i);
                break;
            }
        }
    }

    // TODO: Return the shortest path from start to dest with the correct cost of the nodes; return null if no path possible
    public List<Node> shortestPath(int start, int dest){
        for (Node node : nodes) {
            node.setValue(Integer.MAX_VALUE);
            node.setPrev(null);
        }
        nodes.get(start).setValue(0);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(nodes.get(start));

        while (!priorityQueue.isEmpty()) {
            Node node1 = priorityQueue.poll();
            if (node1.getName() == dest) {
                List<Node> arrayList = new ArrayList<>();
                Node current = nodes.get(dest);
                while (current != null) {
                    arrayList.add(0, current);
                    current = current.getPrev();
                }
                return arrayList;
            }
            for (Edge edge : node1.getEdges()) {
                Node destVertex = edge.getDestVertex();
                int dist = node1.getValue() + edge.getWeight();
                if (dist < destVertex.getValue()) {
                    destVertex.setValue(dist);
                    destVertex.setPrev(node1);
                    priorityQueue.add(destVertex);
                }
            }
        }
        return null;


    }

    public boolean allTrue(boolean[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) { //if there's false value, return false
                return false;
            }
        }
        return true;
    }
}

