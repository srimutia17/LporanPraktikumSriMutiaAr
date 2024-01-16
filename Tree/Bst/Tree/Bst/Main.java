
package Bst;

/**
 * Kelas Main merupakan kelas utama untuk menjalankan program dan menguji
 * fungsionalitas dari BinarySearchTree.
 *
 * <p>
 * Kelas ini dibuat oleh Sri Mutia Angriani Rusli dan berfungsi sebagai entry
 * point dari program.
 * Program ini melakukan pengujian operasi pohon biner pencarian seperti
 * penambahan simpul,
 * penambahan anak pada simpul yang sudah ada, dan melakukan traversals
 * (in-order, pre-order, post-order, level-order).
 * </p>
 *
 * @author Sri Mutia Angriani Rusli
 */
public class Main {

    /**
     * Metode main adalah entry point dari program yang membuat objek
     * BinarySearchTree,
     * menambahkan beberapa node ke dalam pohon biner pencarian, menampilkan
     * struktur
     * pohon, dan melakukan traversals.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        // Membuat objek BinarySearchTree
        BinarySearchTree tree = new BinarySearchTree();

        // Menambahkan beberapa node ke dalam pohon biner pencarian
        tree.tambahNode("Mango");
        tree.tambahNode("Apple");
        tree.tambahNode("Orange");
        tree.tambahNode("Banana");

        // Menambahkan anak ke node "Orange"
        tree.tambahChild("Orange", "Grapes");

        // Menambahkan node "Pineapple"
        tree.tambahNode("Pineapple");

        // Menambahkan anak ke node "Pineapple"
        tree.tambahChild("Pineapple", "Peach");

        // Menampilkan struktur pohon
        System.out.println("\nModel Struktur Pohon:");
        tree.displayTree(tree.root, "");

        // Melakukan In-Order Traversal dan menampilkan hasilnya
        System.out.println("\n\nIn-Order Traversal:");
        tree.inOrderTraversal(tree.root);

        // Melakukan Pre-Order Traversal dan menampilkan hasilnya
        System.out.println("\n\nPre-Order Traversal:");
        tree.preOrderTraversal(tree.root);

        // Melakukan Post-Order Traversal dan menampilkan hasilnya
        System.out.println("\n\nPost-Order Traversal:");
        tree.postOrderTraversal(tree.root);

        // Melakukan Level-Order Traversal dan menampilkan hasilnya
        System.out.println("\n\nLevel-Order Traversal:");
        tree.levelOrder(tree.root);
    }
}