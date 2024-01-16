// Impor paket java.util untuk menggunakan kelas-kelas seperti Map, List, dan HashMap.
import java.util.*;

// Kelas untuk merepresentasikan sisi (edge) pada graf dengan tujuan dan bobot.
class Sisi {
    String destination;
    int weight;
// Konstruktor untuk inisialisasi objek Sisi dengan nilai tujuan dan bobot.
    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
// Kelas utama untuk penelusuran graf menggunakan algoritma Dijkstra.
public class DijkstraGraphTraversal {
     // Adjacency list untuk menyimpan sisi-sisi dari setiap node.
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    // Metode untuk menambahkan node ke graf jika belum ada.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sisi (edge) ke graf dengan bobot tertentu.
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        // Tambahkan sisi ke adjacency list dari node sumber.
        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

     // Metode untuk melakukan penelusuran menggunakan algoritma Dijkstra dan mengembalikan jarak antara dua node.
    public int dijkstra(String start, String end) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<String, Integer> distances = new HashMap<>();
        Set<String> settled = new HashSet<>();

        // Inisialisasi jarak untuk setiap node dengan nilai tak terhingga.
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        // Jarak dari node awal ke node awal diatur sebagai 0.
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

         // Algoritma Dijkstra
        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();

             // Jika mencapai node tujuan, kembalikan jarak.
            if (current.equals(end)) {
                return distances.get(end);
            }

            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            
            // Update jarak ke tetangga-tetangga yang belum terkunjungi.
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!settled.contains(edge.destination)) {
                    int newDistance = distances.get(current) + edge.weight;
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }
  
        // Jika tidak ada jalur yang tersedia, kembalikan nilai tak terhingga.
        return distances.get(end);
    }

    
    public static void main(String[] args) {   // Metode utama sebagai contoh penggunaan algoritma Dijkstra
    // Membuat objek graf dan menambahkan node serta sisi ke graf.
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();
        
        // Tambahkan node dan edge sesuai dengan graf Anda
        // Contoh: graph.addEdge("A", "B", 6);

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);
        
        
        // Melakukan penelusuran Dijkstra dari node A ke node E.
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}

