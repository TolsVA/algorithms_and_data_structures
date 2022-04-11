package homework_7_2;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addVertex('М');
        graph.addVertex('Т');
        graph.addVertex('Л');
        graph.addVertex('В');
        graph.addVertex('Р');
        graph.addVertex('Ю');
        graph.addVertex('С');
        graph.addVertex('К');
        graph.addVertex('О');
        graph.addVertex('К');

        graph.addEdge('М', 'Т');
        graph.addEdge('Т', 'Л');
        graph.addEdge('Л', 'В');
        graph.addEdge('М', 'Р');
        graph.addEdge('Р', 'Ю');
        graph.addEdge('Ю', 'С');
        graph.addEdge('С', 'В');
        graph.addEdge('М', 'К');
        graph.addEdge('К', 'О');
        graph.addEdge('О', 'К');
        graph.addEdge('К', 'В');

        graph.bfs();
    }
}


