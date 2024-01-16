
 //Kelas untuk mengimplementasikan Bubble Sort pada array.
 
public class BubbleSort {

    /**
     * Metode untuk mengurutkan array menggunakan algoritma Bubble Sort.
     *
     * @param arr Array yang akan diurutkan.
     */
    void bubbleSort(int arr[]) {
        // Mendapatkan panjang dari array
        int n = arr.length; 

        // Loop luar dari awal sampai hampir akhir array
        for (int i = 0; i < n-1; i++) {
            
            // Loop dalam untuk perbandingan dan pertukaran
            for (int j = 0; j < n-i-1; j++) {
                
                // Jika elemen saat ini lebih besar dari yang berikutnya
                if (arr[j] > arr[j+1]) {
                    //  untuk Pertukaran elemen
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * Metode utama untuk menjalankan program.
     *
     * @param args Argumen baris perintah tidak digunakan.
     */
    public static void main(String args[]) {
       // Membuat instansi dari kelas BubbleSort
        BubbleSort ob = new BubbleSort(); 
        // Array yang akan diurutkan
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
        // Memanggil metode bubbleSort
        ob.bubbleSort(arr); 

        //  untuk Mencetak pesan
        System.out.println("Sorted array"); 

        // Loop untuk mencetak array yang sudah diurutkan
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

