package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para os métodos da classe {@link Graph}.
 * Esta classe possuí testes unitários para verificar o comportamento dos métodos da classe Graph.
 * 
 * @author Pedro Henrique Damann
 * @version 1.0
 */

public class GraphTest {

	private Graph<String> grafo;
    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;

    /**
     * Cria um grafo para os testes seguintes.
     */
    @Before
    public void setUp() {
        grafo = new Graph<>();
        nodeA = new Node<>("A");
        nodeB = new Node<>("B");
        nodeC = new Node<>("C");
        nodeD = new Node<>("D");
        nodeE = new Node<>("E");

        grafo.addNode(nodeA);
        grafo.addNode(nodeB);
        grafo.addNode(nodeC);
        grafo.addNode(nodeD);
        grafo.addNode(nodeE);
    }

    /**
     * Faz o teste do método {@link Graph#addNode(Node)}.
     * Verifica se um node é corretamente adicionado ao grafo.
     */
    @Test
    public void testAddNode() {
        grafo.addNode(nodeA);
        assertTrue(grafo.getAdjacencyList().containsKey(nodeA));
    }
    
    /**
     * Faz o teste do método {@link Graph#addAresta(Node, Node, double)}.
     * Verifica se uma aresta é corretamente criada entre dois nodes.
     */
    @Test
    public void testAddAresta() {
        grafo.addAresta(nodeA, nodeB, 1.0);
        assertEquals(1, grafo.getAdjacencyList().get(nodeA).size());
    }

    /**
     * Faz o teste do método {@link Graph#bfs(Node)}.
     * Verifica se a busca em largura (BFS) retorna os nodes em ordem certa.
     */
    @Test
    public void testBFS() {
        grafo.addAresta(nodeA, nodeB, 1.0);
        grafo.addAresta(nodeB, nodeC, 2.5);

        List<Node<String>> bfsResult = grafo.bfs(nodeA);
        assertEquals(3, bfsResult.size());
        assertEquals(nodeA, bfsResult.get(0));
        assertEquals(nodeB, bfsResult.get(1));
        assertEquals(nodeC, bfsResult.get(2));
    }
    
    /**
     * Faz o teste do método {@link Graph#dfs(Node)}.
     * Verifica se a busca em profundidade (DFS) retorna os nodes em ordem certa.
     */
    @Test
    public void testDFS() {
    	grafo.addAresta(nodeA, nodeB, 1.0);
        grafo.addAresta(nodeB, nodeD, 2.5);
        grafo.addAresta(nodeC, nodeE, 3.0);
        grafo.addAresta(nodeA, nodeC, 4.0);
        grafo.addAresta(nodeB, nodeE, 5.0);

        List<Node<String>> bfsResult = grafo.dfs(nodeA);
        assertEquals(5, bfsResult.size());
        assertEquals(nodeA, bfsResult.get(0));
        assertEquals(nodeB, bfsResult.get(1));
        assertEquals(nodeD, bfsResult.get(2));
        assertEquals(nodeE, bfsResult.get(3));
        assertEquals(nodeC, bfsResult.get(4));
    }

    /**
     * Faz o teste do método {@link Graph#dijkstra(Node)}.
     * Verifica se o método dijkstra retorna os nodes na ordem correta.
     */
    @Test
    public void testDijkstra() {
    	Graph<String> graph = new Graph<>();
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        
        grafo.addAresta(nodeA, nodeB, 1.0);
        grafo.addAresta(nodeB, nodeC, 2.5);
        grafo.addAresta(nodeA, nodeC, 3.0);
        grafo.addAresta(nodeC, nodeD, 3.0);

        Map<Node<String>, Double> dijkstraResult =  grafo.dijkstra(nodeA);
        assertEquals(0.0, dijkstraResult.get(nodeA), 0.01);
        assertEquals(1.0, dijkstraResult.get(nodeB), 0.01);
        assertEquals(3.0, dijkstraResult.get(nodeC), 0.01);
    }
}
