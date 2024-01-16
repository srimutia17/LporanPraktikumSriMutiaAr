import java.util.*;

// Kelas UndirectedGraph merepresentasikan graf tidak terarah dengan node dan edge bertipe String.
class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi objek UndirectedGraph dengan adjacency list kosong.
    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    //  Metode untuk Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk Menambahkan edge ke graf (tambahkan di kedua arah untuk graf tidak terarah)
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode untuk Mendapatkan daftar tetangga dari node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

     // Metode untuk mencetak graf, menampilkan setiap node dan daftar tetangganya.
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {  // Metode main untuk menjalankan contoh penggunaan graf tidak terarah.
        UndirectedGraph graph = new UndirectedGraph(); // Membuat objek UndirectedGraph
        // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak graf setelah penambahan node dan edge
        graph.printGraph();
    }
} 
    

