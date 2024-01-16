package Bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Kelas BinarySearchTree menyediakan implementasi pohon biner pencarian (BST)
 * dengan beberapa operasi seperti penambahan simpul, penambahan anak, dan
 * traversals.
 *
 * <p>
 * Kelas ini dibuat oleh Sri Mutia Angriani Rusli dan digunakan untuk
 * merepresentasikan struktur pohon biner.
 * Pohon ini dapat digunakan untuk menyimpan data dan melakukan operasi seperti
 * penambahan simpul,
 * penambahan anak pada simpul yang sudah ada, serta traversals (pre-order,
 * in-order, post-order, level-order).
 * </p>
 *
 * <p>
 * Struktur pohon biner memiliki simpul-simpul yang memiliki data (String),
 * serta referensi ke simpul kiri dan simpul kanan.
 * </p>
 *
 * @author Sri Mutia Angriani Rusli
 */
class Node {
    String data;
    Node left;
    Node right;
}

public class BinarySearchTree {

    // Akar pohon
    Node root;

    /**
     * Metode tambahNode digunakan untuk menambahkan simpul baru ke dalam pohon
     * biner pencarian.
     *
     * @param dataBaru Data untuk simpul baru (String).
     */
    void tambahNode(String dataBaru) {
        root = tambahNodeHelp(root, dataBaru);
    }

    /**
     * Metode tambahNodeHelp merupakan metode rekursif yang membantu dalam
     * penambahan simpul baru.
     *
     * @param root     Akar saat ini dari pohon.
     * @param dataBaru Data untuk simpul baru (String).
     * @return Node Akar pohon yang diperbarui setelah penambahan simpul baru.
     */
    Node tambahNodeHelp(Node root, String dataBaru) {
        if (root == null) {
            Node baru = new Node();
            baru.data = dataBaru;
            baru.left = null;
            baru.right = null;
            return baru;
        }

        int hasilCompare = dataBaru.compareTo(root.data);

        if (hasilCompare < 0) {
            root.left = tambahNodeHelp(root.left, dataBaru);
        } else if (hasilCompare > 0) {
            root.right = tambahNodeHelp(root.right, dataBaru);
        }

        return root;
    }

    /**
     * Metode tambahChild digunakan untuk menambahkan anak ke simpul yang sudah ada
     * dalam pohon.
     *
     * @param existingData Data pada simpul yang sudah ada.
     * @param newData      Data untuk anak baru (String).
     */
    void tambahChild(String existingData, String newData) {
        root = tambahChildHelp(root, existingData, newData);
    }

    /**
     * Metode tambahChildHelp merupakan metode rekursif yang membantu dalam
     * penambahan anak ke simpul yang sudah ada.
     *
     * @param root         Akar saat ini dari pohon.
     * @param existingData Data pada simpul yang sudah ada.
     * @param newData      Data untuk anak baru (String).
     * @return Node Akar pohon yang diperbarui setelah penambahan anak baru.
     */
    Node tambahChildHelp(Node root, String existingData, String newData) {
        if (root == null) {
            return root;
        }

        if (root.data.equals(existingData)) {
            Node childNode = new Node();
            childNode.data = newData;
            childNode.left = null;
            childNode.right = null;

            childNode.left = root.left;
            root.left = childNode;
        } else {
            root.left = tambahChildHelp(root.left, existingData, newData);
            root.right = tambahChildHelp(root.right, existingData, newData);
        }

        return root;
    }

    /**
     * Metode displayTree digunakan untuk menampilkan struktur pohon secara
     * rekursif.
     *
     * @param root   Akar saat ini dari pohon.
     * @param prefix Awalan untuk setiap baris untuk membentuk struktur berhierarki.
     */
    public static void displayTree(Node root, String prefix) {
        if (root != null) {
            System.out.println(prefix + "├── " + root.data);
            displayTree(root.left, prefix + "│   ");
            displayTree(root.right, prefix + "│   ");
        }
    }

    /**
     * Metode preOrderTraversal melakukan traversal pohon pre-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Akar pohon yang akan ditraversal.
     */
    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + ", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * Metode inOrderTraversal melakukan traversal pohon in-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Akar pohon yang akan ditraversal.
     */
    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + ", ");
        inOrderTraversal(root.right);
    }

    /**
     * Metode postOrderTraversal melakukan traversal pohon post-order dan mencetak
     * nilai setiap simpul.
     *
     * @param root Akar pohon yang akan ditraversal.
     */
    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + ", ");
    }

    /**
     * Metode levelOrder melakukan traversal pohon level-order (BFS) dan mencetak
     * nilai setiap simpul.
     *
     * @param root Akar pohon yang akan ditraversal.
     */
    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + ", ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}