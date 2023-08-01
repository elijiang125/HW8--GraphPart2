import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GraphTest {

    // TODO: Write accuracy tests + test different graphs :)

    @Test
    public void shortestPath1(){
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        List<Node> nodes = List.of(n0,n1,n2,n3);
        Graph g = new Graph(nodes);

        g.addEdge(n0, n1, 1);
        g.addEdge(n0, n2, 1);
        g.addEdge(n1, n3, 4);
        g.addEdge(n2, n3,2);

        assertEquals(n1.getPrev(), n0);
        assertEquals(n2.getPrev(), n0);
        assertEquals(n3.getPrev(), n2);


        List<Node> traverse = g.shortestPath(0, 3);

        assertEquals(0, n0.getValue());
        assertEquals(1, n2.getValue());
        assertEquals(3, n3.getValue());
        assertEquals(3, traverse.size());
        g.reset();


        traverse = g.shortestPath(2, 0);
        assertNull(traverse);


    }

    @Test
    public void shortestPath2() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        List<Node> nodes = List.of(n0,n1,n2,n3,n4,n5,n6);
        Graph g = new Graph(nodes);

        g.addEdge(n0, n1, 2);
        g.addEdge(n0, n5, 6);
        g.addEdge(n1, n3, 4);
        g.addEdge(n2, n3,2);
        g.addEdge(n3, n4, 8);
        g.addEdge(n4, n5, 2);
        g.addEdge(n5, n6, 4);

        List<Node> traverse = g.shortestPath(0, 3);

        assertEquals(0, n0.getValue());
        assertEquals(2, n1.getValue());
        assertEquals(6, n3.getValue());
        assertEquals(3, traverse.size());
        g.reset();

        traverse = g.shortestPath(0, 5);
        assertEquals(0, n0.getValue());
        assertEquals(2, n1.getValue());
        assertEquals(6, n3.getValue());
        assertEquals(2, traverse.size());
        g.reset();

        traverse = g.shortestPath(2, 1);
        assertNull(traverse);
    }

}
