import java.util.*;

// Kelas Edge merepresentasikan sisi dalam graf berbobot.
class Edge {
    String destination;
    int weight;

    // Konstruktor untuk membuat sisi baru dengan tujuan dan bobot tertentu.
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
// Kelas WeightedGraph merepresentasikan graf berbobot dengan node dan edge bertipe String.
class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

        // Konstruktor untuk inisialisasi objek WeightedGraph dengan adjacency list kosong.
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    //  Metode untuk Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk Menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Metode untuk mencetak graf, menampilkan setiap node dan edge beserta bobotnya.
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {  // Metode main untuk menjalankan contoh penggunaan graf berbobot
         // Membuat objek WeightedGraph
        WeightedGraph graph = new WeightedGraph();
         // Menambahkan node-node ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        
    // Menambahkan edge-edge berbobot ke graf
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);


        // Mencetak graf setelah penambahan node dan edge berbobot
        graph.printGraph();
    }
} 
    

