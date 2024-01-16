import java.util.*;

// Kelas StringGraph merepresentasikan graf dengan node dan edge bertipe String.
class StringGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk inisialisasi objek StringGraph dengan adjacency list kosong.
    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge ke graf.
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
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

    public static void main(String[] args) {   // Metode main untuk menjalankan contoh penggunaan graf dengan tipe data String.
        StringGraph graph = new StringGraph();  // Membuat objek StringGraph
         // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge ke graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

         // Mencetak graf setelah penambahan node dan edge
        graph.printGraph();
    }
}

