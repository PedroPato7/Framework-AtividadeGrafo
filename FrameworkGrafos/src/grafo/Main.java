package grafo;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        graph.addNode(new Node<>("A"));
        graph.addNode(new Node<>("B"));
        graph.addNode(new Node<>("C"));
        graph.addNode(new Node<>("D"));
        graph.addNode(new Node<>("E"));

        //Aqui é inserido os Nodes desejados
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        graph.addAresta(nodeA, nodeB, 1.0);
        graph.addAresta(nodeB, nodeD, 2.5);
        graph.addAresta(nodeC, nodeE, 3.0);
        graph.addAresta(nodeA, nodeC, 4.0);
        graph.addAresta(nodeB, nodeE, 5.0);

        System.out.println("Estrutura do Grafo:");
        System.out.println(graph);
        
        // Exemplos do BFS
        String nodoInicial = "A"; // Salva qual o nó que o usuário deseja usar o BFS.
        Node<String> startNode = new Node<>(nodoInicial); // Converte para a variável do tipo Node.
        List<Node<String>> bfsResult; // Deixa criado a variável.
        
        if (graph.existeNodo(nodoInicial)) { // Chama a função para verificar se o Node já existe.
        	bfsResult = graph.bfs(startNode); // Chama a função bfs.
        	System.out.println("Nós visitados pelo BFS a partir de " + startNode +":");
            for (Node<String> node : bfsResult) {
                System.out.print(node + " ");
            }
            System.out.print("\n \n");
        } else {
        	System.out.println("O Node inserido não existe no momento. \n");
        }
        
        // Faz outra busca em outro Node usando o BFS.
        nodoInicial = "B"; // Salva os novos dados.
        startNode = new Node<>(nodoInicial);
        if (graph.existeNodo(nodoInicial)) {
        	bfsResult = graph.bfs(startNode);
        	System.out.println("Nós visitados pelo BFS a partir de " + startNode +":");
            for (Node<String> node : bfsResult) {
                System.out.print(node + " ");
            }
            System.out.print("\n \n");
        } else {
        	System.out.println("O Node inserido não existe no momento. \n");
        }
        
        //O próximo código é sobre o DFS
        nodoInicial = "A"; // Salva os novos dados.
        List<Node<String>> dfsResult;
        if (graph.existeNodo(nodoInicial)) {
            dfsResult = graph.dfs(new Node<>(nodoInicial));
            System.out.println("Nós visitados pelo DFS a partir de A:");
            for (Node<String> node : dfsResult) {
                System.out.print(node + " ");
            }
            System.out.print("\n \n");
        } else {
            System.out.println("O nó '" + nodoInicial + "' não existe no grafo. \n");
        }
        
      //Outro exemplo sobre o DFS
        nodoInicial = "G"; // Salva os novos dados.
        if (graph.existeNodo(nodoInicial)) {
            dfsResult = graph.dfs(new Node<>(nodoInicial));
            System.out.println("Nós visitados pelo DFS a partir de A:");
            for (Node<String> node : dfsResult) {
                System.out.print(node + " ");
            }
            System.out.print("\n \n");
        } else {
            System.out.println("O nó '" + nodoInicial + "' não existe no grafo. \n");
        }
        
     // Testando o Dijkstra
        startNode = new Node<>("A");
        Map<Node<String>, Double> dijkstraResult = graph.dijkstra(startNode);

        System.out.println("Distâncias mínimas a partir do nó " + startNode +":");
        for (Map.Entry<Node<String>, Double> entry : dijkstraResult.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}