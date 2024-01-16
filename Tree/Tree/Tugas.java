package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Kelas Node merepresentasikan simpul atau node dalam struktur pohon biner.
 * Setiap simpul memiliki data, referensi ke simpul kiri, dan referensi ke
 * simpul kanan.
 * Konstruktor digunakan untuk menginisialisasi simpul dengan data tertentu.
 *
 * @author Sri Mutia Angriani Rusli
 */
class Node {
    int data;
    Node left;
    Node right;

    /**
     * Konstruktor untuk membuat objek Node dengan data tertentu.
     *
     * @param data Nilai untuk simpul ini.
     */
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/**
 * Kelas Tugas merupakan program Java yang mengimplementasikan berbagai fungsi
 * terkait
 * dengan pohon biner, seperti pencetakan struktur pohon, traversal pre-order,
 * in-order,
 * post-order, dan level-order.
 *
 * <p>
 * Kelas ini dibuat oleh Sri Mutia Angriani Rusli dan berfungsi sebagai program
 * utama yang menjalankan
 * berbagai operasi pada pohon biner.
 * </p>
 *
 */
public class Tugas {

    /**
     * Metode printTree digunakan untuk mencetak struktur pohon secara rekursif
     * dengan
     * menyertakan prefix untuk membentuk tampilan yang terstruktur.
     *
     * @param root   Simpul atau node saat ini.
     * @param prefix Awalan untuk setiap baris untuk membentuk struktur berhierarki.
     * @param isLeft Menandakan apakah simpul ini simpul kiri dari induknya.
     */
    static void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            // Menampilkan simpul saat ini dengan format yang sesuai
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.data);

            // Memanggil rekursif untuk simpul kiri jika ada
            if (root.left != null || root.right != null) {
                printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);

                // Memanggil rekursif untuk simpul kanan jika ada
                printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }

    /**
     * Metode preOrderTraversal melakukan traversal pohon pre-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Simpul atau node akar dari pohon yang akan ditraversal.
     */
    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Menampilkan nilai simpul saat ini
        System.out.print(root.data + ", ");

        // Rekursif untuk simpul kiri
        preOrderTraversal(root.left);

        // Rekursif untuk simpul kanan
        preOrderTraversal(root.right);
    }

    /**
     * Metode inOrderTraversal melakukan traversal pohon in-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Simpul atau node akar dari pohon yang akan ditraversal.
     */
    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Rekursif untuk simpul kiri
        inOrderTraversal(root.left);

        // Menampilkan nilai simpul saat ini
        System.out.print(root.data + ", ");

        // Rekursif untuk simpul kanan
        inOrderTraversal(root.right);
    }

    /**
     * Metode postOrderTraversal melakukan traversal pohon post-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Simpul atau node akar dari pohon yang akan ditraversal.
     */
    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Rekursif untuk simpul kiri
        postOrderTraversal(root.left);

        // Rekursif untuk simpul kanan
        postOrderTraversal(root.right);

        // Menampilkan nilai simpul saat ini
        System.out.print(root.data + ", ");
    }

    /**
     * Metode levelOrder melakukan traversal pohon level-order (BFS) dan mencetak
     * nilai setiap simpul.
     *
     * @param root Simpul atau node akar dari pohon yang akan ditraversal.
     */
    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Mengambil dan menghapus simpul depan dari antrian
            Node current = queue.poll();

            // Menampilkan nilai simpul saat ini
            System.out.print(current.data + ", ");

            // Menambahkan simpul kiri ke antrian jika ada
            if (current.left != null) {
                queue.add(current.left);
            }

            // Menambahkan simpul kanan ke antrian jika ada
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * Metode main merupakan entry point program yang membuat dua pohon biner
     * dan melakukan berbagai operasi seperti pencetakan struktur, traversal,
     * dan mencetak nama kelompok.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {

        // Membuat pohon pertama
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.right.left.left = new Node(10);

        System.out.println("Program ke-2");
        System.out.println("\nModel Struktur folder:");
        printTree(root, "", true);

        System.out.println("\nPreOrder: ");
        preOrderTraversal(root);
        System.out.println("\nInOrder: ");
        inOrderTraversal(root);
        System.out.println("\nPostOrder");
        postOrderTraversal(root);
        System.out.println("\nLevelOrder");
        levelOrder(root);

        // Membuat pohon kedua
        Node root2 = new Node(50);
        root2.left = new Node(30);
        root2.right = new Node(70);
        root2.left.left = new Node(10);
        root2.left.right = new Node(35);
        root2.right.left = new Node(65);
        root2.right.right = new Node(80);

        System.out.println("\nProgram ke-3");
        System.out.println("\n\nModel Struktur folder:");
        printTree(root2, "", true);

        System.out.println("PreOrder: ");
        preOrderTraversal(root2);
        System.out.println("\nInOrder: ");
        inOrderTraversal(root2);
        System.out.println("\nPostOrder");
        postOrderTraversal(root2);
        System.out.println("\nLevelOrder");
        levelOrder(root2);
    }
}