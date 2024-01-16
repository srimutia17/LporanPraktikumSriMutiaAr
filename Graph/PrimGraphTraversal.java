import java.util.*;

// Kelas Edge merepresentasikan sisi dalam graf.
// Implementasi Comparable untuk memungkinkan pembandingan berdasarkan bobot.
class Edge implements Comparable<Edge> {
    String source;
    String destination;
    int weight;

      // Konstruktor untuk membuat sisi baru
    public Edge(String source, String destination, int weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
}

    // Metode compareTo untuk membandingkan sisi berdasarkan bobotnya.
    // Digunakan untuk pengurutan sisi.
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
    // Kelas PrimGraphTraversal mengimplementasikan algoritma Prim untuk mencari Minimum Spanning Tree.
public class PrimGraphTraversal {
     private Map<String, List<Edge>> adjacencyList;

     // Konstruktor untuk inisialisasi objek PrimGraphTraversal dengan adjacency list kosong.
    public PrimGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge berbobot ke graf.
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // Untuk graf tidak terarah
    }

    // Metode untuk mendapatkan daftar tetangga dan bobot dari suatu node.
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }
// Metode algoritma Prim untuk mencari Minimum Spanning Tree (MST).
    public void primMST(String start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> inMST = new HashSet<>();
        Map<String, Edge> edgeTo = new HashMap<>();
        // Untuk menyimpan edge-edge yang membentuk MST
        List<Edge> mstEdges = new ArrayList<>();

        // Inisialisasi dengan node awal
        inMST.add(start);

        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }

        
        int totalWeight = 0; // Variabel untuk menyimpan total bobot
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination)) continue;

            inMST.add(edge.destination);
            mstEdges.add(edge); // Menambahkan edge ke dalam MST
            totalWeight += edge.weight; // Menambahkan bobot edge ke total bobot

            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        // untuk  Menampilkan MST
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mstEdges) {
            System.out.println(edge.source + " - " + edge.destination + " [" + edge.weight + "]");
        }

        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot
    }

    public static void main(String[] args) {      // Metode main untuk menjalankan algoritma.
        PrimGraphTraversal graph = new PrimGraphTraversal();

        // Menambahkan node ke graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // menambahkan edge atau sisi ke graph
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
    // Menjalankan algoritma Prim dengan memulai dari node A
        graph.primMST("A");
    }
}
