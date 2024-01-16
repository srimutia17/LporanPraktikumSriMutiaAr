//Kelas yang menyediakan metode untuk mengurutkan array menggunakan algoritma Selection Sort.
 
public class SelectionSort {

    /**
     * Metode untuk mengurutkan array integer dalam urutan menurun menggunakan algoritma Selection Sort.
     *
     * @param array Array of integers yang akan diurutkan.
     * @return Array yang sudah diurutkan dalam urutan menurun.
     */
    public static int[] selectionSort(int[] array) {
        // Mendapatkan ukuran array
        int ukuran = array.length; 

        // Melakukan iterasi selama masih ada elemen yang belum diurutkan
        while (ukuran > 0) {
            // Mengasumsikan elemen pertama (index 0) adalah yang terbesar
            int max = 0; 
            // Untuk mencari elemen terbesar dalam subarray yang belum diurutkan
            for (int i = 1; i < ukuran; i++) {
                if (array[max] < array[i]) {
             // Untuk menemukan elemen baru yang lebih besar
                    max = i; 
                }
            }

            //  untuk Menukarkan elemen terbesar dengan elemen di akhir subarray yang belum diurutkan
            int temp = array[max];
            array[max] = array[ukuran - 1];
            array[ukuran - 1] = temp;

            // untuk mengurangi ukuran subarray yang belum diurutkan karena elemen terbesar sudah di tempat yang tepat
            ukuran--;
        }
        return array; // untuk mengembalikan array yang sudah diurutkan
    }

    /**
     * Metode utama yang menjalankan program.
     */
    public static void main(String[] args) {
        // Array yang akan diurutkan
        int[] array = {64, 34, 25, 12, 22, 11, 90}; 
        // Memanggil metode selec untuk mengurutkan array
        int[] sortedArray = selectionSort(array); 
        // Mencetak array yang sudah diurutkan dalam urutan menurun
        System.out.println("Sorted array in descending order:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}

