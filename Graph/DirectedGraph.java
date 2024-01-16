// Impor paket java.util untuk menggunakan kelas-kelas seperti Map, List, dan HashMap.
import java.util.*;

// Kelas untuk merepresentasikan graf berarah menggunakan adjacency list.
class DirectedGraph {
     // Map untuk menyimpan adjacency list dari setiap node.
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi objek DirectedGraph dengan adjacency list kosong.
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }
// Metode untuk menambahkan node baru ke graf.
    public void addNode(String node) {
        // Menambahkan node ke adjacency list jika belum ada.
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge ke graf (hanya satu arah untuk graf berarah).
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

   // Metode untuk mendapatkan daftar tetangga dari suatu node.
    public List<String> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dari node atau daftar kosong jika node tidak ada.
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

  // Metode untuk mencetak graf (menampilkan node dan tetangganya).
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {   // Metode utama sebagai contoh penggunaan graf berarah.
        // Membuat objek graf dan menambahkan node serta sisi ke graf.
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak graf untuk menampilkan hubungan antar node
        graph.printGraph();
    }
}

