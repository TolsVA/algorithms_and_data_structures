package homework_7_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph {
    private Vertex[] vertexList; // массив вершин
    private int[][] adjMat; // Матрица смежности
    private int nVertex; // Текущий номер
    private Deque<Integer> stack; // Использование стека для реализации поиска в глубину
    private Deque<Integer> queue; // Использование очереди для поиска в ширину

    public Graph(int size) {
        vertexList = new Vertex[size];
        adjMat = new int[size][size];
        // Инициализируем все элементы матрицы смежности равными 0, т.е. все вершины не имеют ребер
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0; // Количество начальных вершин равно 0
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayAdjMat() {
        for (int i = 0; i < nVertex; i++) {
            for (int j = 0; j < nVertex; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // выводим значение, представленное вершиной
    public void display(int v) {
        System.out.print(vertexList[v].label);
    }

    // Найти вершину, которая смежна с вершиной и не посещена
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Алгоритм поиска в глубину:
     * 1. Используйте метод peek () для проверки верхней вершины стека
     * 2. Используйте метод getAdjUnvisitedVertex (), чтобы найти вершины, смежные с текущей вершиной стека и не посещенные
     * 3. Возвращаемое значение метода второго шага не равно -1, затем найдите следующую непосещенную соседнюю вершину, посетите эту вершину и поместите ее в стек; если возвращаемое значение метода второго шага равно -1, оно не найдено, и стек
     */
    public void dfs() {
        // посещение с первой вершины
        vertexList[0].wasVisited = true; // Пометить как true после посещения
        display(0); // Распечатать первую посещенную вершину
        stack.push(0); // Поместить первую вершину в стек
        while (!stack.isEmpty()) {
            // Находим вершину, которая смежна со стеком и не посещена
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {// Если текущее значение вершины равно -1, это означает, что нет смежных и не посещенных вершин, затем вытолкните вершину
                stack.pop();
            } else {// В противном случае посетите следующую смежную вершину
                vertexList[v].wasVisited = true;
                display(v);
                stack.push(v);
            }
        }
        // После поиска сбрасываем все маркеры
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /**
     * Алгоритм поиска в ширину:
     * 1. Используйте метод remove (), чтобы проверить верхнюю вершину стека
     * 2. Попытайтесь найти соседний узел, который эта вершина не посетила
     * 3. Если не найдено, вершина удаляется
     * 4. Если такая вершина найдена, посетите эту вершину и поместите ее в очередь
     */
    public void bfs() {
        vertexList[0].wasVisited = true;
        display(0);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int v;
            while ((v = getAdjUnvisitedVertex(temp)) != -1) {
                vertexList[v].wasVisited = true;
                display(v);
                queue.offer(v);
            }
        }
        // После поиска сбрасываем все маркеры
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
