// Impor paket java.util untuk menggunakan kelas-kelas seperti Map, List, dan HashMap.
    import java.util.*;

    
// Definisikan kelas Edges untuk merepresentasikan tepi graf dengan tujuan (destination) dan bobot.
class Edges {
    String destination;
    int weight;

//Konstruktor untuk inisialisasi objek Edges dengan nilai tujuan dan bobot.
    public Edges(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
// Definisikan kelas BfsGraphTraversal untuk melakukan penelusuran graf menggunakan BFS.
public class BfsGraphTraversal {
    // Gunakan Map untuk merepresentasikan adjacency list, di mana setiap simpul terhubung dengan daftar tepi yang terkait.
    private Map<String, List<Edges>> adjacencyList;

// Konstruktor untuk inisialisasi objek BfsGraphTraversal dengan adjacency list kosong.
    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
    // Menambahkan node ke adjacency list jika belum ada
     adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

   // Metode untuk menambahkan edge berbobot ke graf
    public void addEdge(String source, String destination, int weight) {
     // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
   
    // Tambahkan edge berbobot ke daftar tetangga node sumber
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

   // Metode untuk mendapatkan daftar tetangga dan bobot dari suatu node
    public List<Edges> getNeighbors(String node) {
         // Mengembalikan daftar tetangga dari node atau daftar kosong jika node tidak ada
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

   
// Metode untuk melakukan BFS traversal dari suatu node sumber
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // Menambahkan node sumber ke antrian dan menandainya sebagai sudah dikunjungi
        queue.add(start);
        visited.add(start);

         // Melakukan BFS
        while (!queue.isEmpty()) {
             // Mengambil node saat ini dari antrian
            String current = queue.poll();
            System.out.print(current + " ");

            // Menambahkan semua tetangga yang belum dikunjungi ke antrian
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                    // Baris di bawah ini dapat digunakan untuk menampilkan bobot tepi
                    //System.out.print("-> (" + edge.weight + ") " + edge.destination + " ");
                }
            }
        }
        System.out.println(); // Mencetak baris baru setelah selesai traversal
    }

    public static void main(String[] args) {
         // Contoh penggunaan
        BfsGraphTraversal graph = new BfsGraphTraversal();
        // Menambahkan node dan edge ke graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);
        
          // Memulai BFS traversal dari node A
        graph.bfsTraversal("A");
    }
}

 