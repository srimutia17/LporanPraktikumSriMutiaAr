import java.util.*;

//Kelas SimpleGraph merepresentasikan graf sederhana tanpa bobot pada edge.
class SimpleGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    // Konstruktor untuk inisialisasi objek SimpleGraph dengan adjacency list kosong.
    public SimpleGraph() {
        adjacencyList = new HashMap<>();
    }

   // Metode untuk menambahkan node baru ke graf.
    public void addNode(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

        // Metode untuk menambahkan edge ke graf.
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

   // Metode untuk mendapatkan daftar tetangga dari suatu node
    public List<Integer> getNeighbors(int node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

   
    // Metode untuk mencetak graf.
    public void printGraph() {
        for (int node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {  // Metode main untuk menjalankan contoh penggunaan graf.
         // Membuat objek SimpleGraph
        SimpleGraph graph = new SimpleGraph();

         // Menambahkan node-node ke graf
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

         // Menambahkan edge-edge ke graf
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        // Mencetak graf setelah penambahan node dan edge
        graph.printGraph();
    }
}