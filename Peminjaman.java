
//package Peminjaman;

import java.util.Scanner;

/**
 * 
 * 1. Fitur menu data master barang
 * 2. Fitur menu input peminjaman
 * 3. Fitur menu input pengembalian
 * 4. Denda atau perpanjangan
 * 5. Fitur menu pencarian
 */

public class Peminjaman 
{
   // Daftar barang yang ditampilkan
   public static String barang[] = {"Buku", "Bolpoin", "Pensil", "Spidol", "Rautan", "Komik"}; 
   // Daftar stok barang
   public static int stokBarang[] = {10, 5, 6, 8, 10, 9};
   
   // Daftar peminjaman barang, maksimal 10 dan bisa diubah
   public static String peminjamanBarang[] = new String[10];
   // Daftar stok/jumlah peminjaman barang
   public static int jumlahPeminjamanBarang[] = new int[10];
   // Daftar jumlah hari peminjaman
   public static int jumlahHariPeminjamanBarang[] = new int[10];
   
   // Daftar pengembalian barang, maksimal 10 dan bisa diubah
   public static String pengembalianBarang[] = new String[10];
   // Daftar stok/jumlah pengembalian barang
   public static int jumlahPengembalianBarang[] = new int[10];
   
   public static int indexPeminjamanBarang = 0, indexPengembalianBarang = 0, indexBarangDenda = 0;
   
   public static void main(String[] args) 
   {
      Scanner scInt = new Scanner(System.in);
      Scanner scString = new Scanner(System.in);
      
      // Variabel yang digunakan
      String inputPeminjaman, inputPengembalian, inisialisasi, lanjut, inputCariBarang;
      int pilihMenu, inputJumlahPeminjaman, inputJumlahHariPeminjaman, inputJumlahPengembalian, inputJumlahHariPerpanjangan;
      
      System.out.print("Press enter key to continue . . . .");
      inisialisasi = scString.nextLine();
      
      do {         
         menu();
         System.out.print("Pilih menu berdasarkan nomer > ");
         pilihMenu = scInt.nextInt();
         
         switch(pilihMenu)
         {
            case 1: // jika memilih menu 1 [ Tampilkan Barang ]
               System.out.println("\n[ Tampilkan Barang ]");
               
               tampilkanBarang(); // memanggil fungsi untuk menampilkan barang
               break;
               
            case 2 :
               System.out.println("\n[ Pencarian Barang ]");

               System.out.print("\nMasukan nama barang yang dicari > ");
               inputCariBarang = scString.nextLine();
               
               cariBarang(inputCariBarang);
               break;
               
            case 3: // jika memilih menu 3 [ Peminjaman Barang ]
               System.out.println("\n[ Peminjaman Barang ]");

               tampilkanBarang(); // memanggil fungsi untuk menampilkan barang
               
               System.out.print("\nMasukan nama barang yang ingin dipinjam > ");
               inputPeminjaman = scString.nextLine();
               
               System.out.print("Masukan stok barang > ");
               inputJumlahPeminjaman = scInt.nextInt();
               
               System.out.print("Masukan jumlah masa peminjaman (hari) > ");
               inputJumlahHariPeminjaman = scInt.nextInt();
               
               peminjamanBarang(inputPeminjaman, inputJumlahPeminjaman, inputJumlahHariPeminjaman); // memanggil fungsi peminjamanBarang() untuk menginputkan data ke dalam array peminjaman
               System.out.println("Peminjaman barang sukses . .  .");
               break;
               
            case 4: // Jika memilih menu 4 [ Pengembalian Barang ]
               System.out.println("\n[ Pengembalian Barang ]");

               if (indexPeminjamanBarang == 0) { // mengecek apakah sudah meminjam barang atau belum
                  System.out.println("Anda belum meminjam barang apapun . . .");
                  
               } else {
                  tampilkanPeminjamanBarang();

                  System.out.print("\nMasukan nama barang yang ingin dikembalikan > ");
                  inputPengembalian = scString.nextLine();

                  System.out.print("Masukan stok barang yang dikembalikan > ");
                  inputJumlahPengembalian = scInt.nextInt();

                  pengembalianBarang(inputPengembalian, inputJumlahPengembalian); // memanggil dan memasukan data ke dalam fungsi untuk menambahkan data ke array pengembalian
                  System.out.println("Pengembalian barang sukses . . .");
               }

               break;

            case 5: // Jika memilih menu 5 [ Laporan Peminjaman & Pengembalian Barang ]
               System.out.println("\n[ Laporan Peminjaman & Pengembalian Barang ]");
               
               System.out.println("\nPeminjaman : ");
               tampilkanPeminjamanBarang(); // Memanggil fungsi tampilkanPeminjamanBarang() untuk menampilkan peminjaman barang
               
               System.out.println("\nPengembalian : ");
               tampilkanPengembalianBarang(); // Memanggil fungsi tampilkanPengembalianBarang() untuk menampilkan pengembalian barang
               
               break;
            
            case 6: // Jika memilih menu 6 [ Perpanjangan Peminjaman ]
               System.out.println("\n[ Perpanjangan Peminjaman ]");
               
               System.out.println("\nPeminjaman : ");
               tampilkanPeminjamanBarang(); // Memanggil fungsi tampilkanPeminjamanBarang() untuk menampilkan peminjaman barang
               
               System.out.print("\nMasukan nama barang peminjaman yang ingin diperpanjang masa peminjaman > ");
               inputPeminjaman = scString.nextLine();
               
               System.out.print("Masukan jumlah hari perpanjangan barang > ");
               inputJumlahHariPerpanjangan = scInt.nextInt();
               
               perpanjanganPeminjaman(inputPeminjaman, inputJumlahHariPerpanjangan); // memanggil method/fungsi perpanjangan untuk menginputkan data perpanjangan barang
               
               break;
            
            case 7: // jika memilih menu 7 [ Keluar ]
               keluar();
               System.exit(0);
               
               break;
                              
         }
         
         System.out.print("\nKlik [ ENTER ] untuk mengulangi, ketik [ EXIT ] untuk keluar program . . .");
         lanjut = scString.nextLine();
         
         if (lanjut.equalsIgnoreCase("exit")) { // jika pengguna mengetik kata exit
            keluar(); // memanggil fungsi keluar()
         }
      } while (lanjut.equals(""));
   }
   
   public static void menu() // Daftar menu 
   { 
      System.out.println("\n\n\n");
      System.out.println("==============================");
      System.out.println("========= PEMINJAMAN =========");
      System.out.println("==============================");
      System.out.println("Daftar Menu : ");
      System.out.println("1. Tampilkan Barang");
      System.out.println("2. Pencarian Barang");
      System.out.println("3. Peminjaman Barang");
      System.out.println("4. Pengembalian Barang");
      System.out.println("5. Laporan Peminjaman & Pengembalian Barang");
      System.out.println("6. Perpanjangan Peminjaman");
      System.out.println("7. Keluar \n");
   }

   public static void keluar() // menampilkan kata terima kasih
   { 
      System.out.println("\n\n");
      System.out.println("==================================================================================\n");
      System.out.println(" ######## #### #####   ##  ###    ###  ####      ##   ##  ####  ###### ## ##  ## ");
      System.out.println("    ##    ##   ##  ##  ##  ## #  # ## ##  ##     ## ##   ##  ## ##     ## ##  ## ");
      System.out.println("    ##    #### ## ##   ##  ##  ##  ## ##  ##     ###     ##  ## ###### ## ###### ");
      System.out.println("    ##    ##   ##  ##  ##  ##      ## ######     ## ##   ######     ## ## ##  ## ");
      System.out.println("    ##    #### ##   ## ##  ##      ## ##  ##     ##   ## ##  ## ###### ## ##  ## \n");
      System.out.println("==================================================================================");
      System.out.println("\n\n");
   }
   
   public static void tampilkanBarang() // method/fungsi yang berfungsi untuk menampilkan daftar barang
   {
      System.out.println("-------------------------------");
      System.out.println("|NO|\tBarang\t\t  |Stok|");
      System.out.println("-------------------------------");

      for (int i = 0; i < barang.length; i++) {
         System.out.println((i + 1) + ".\t" + barang[i] + "\t\t   " + stokBarang[i]);
      }
   }
   
   public static void cariBarang(String namaBarang) // method/fungsi yang befungsi untuk pencarian barang
   {
      boolean status = false; // status pencarian barang, jika ketemu statusnya = TRUE, jika tidak maka statusnya = FALSE
      
      for (int i = 0; i < barang.length; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // Jika barang yang terdapat di array sesuai dengan inputan yang diinputkan
            
            System.out.println("-------------------------------");
            System.out.println("|NO|\tBarang\t\t  |Stok|");
            System.out.println("-------------------------------");
            System.out.println((i + 1) + ".\t" + barang[i] + "\t\t   " + stokBarang[i]);

            status = true;
            break;
         }
      }
      
      if (!status) { // jika barang tidak ketemu/berstatus FALSE
         System.out.println("Barang [ " + namaBarang + " ] tidak ditemukan . . .");
      }
   }
   
   public static void peminjamanBarang(String namaBarang, int jumlahStok, int jumlahHari) // method/fungsi yang berfungsi untuk menyimpan data peminjaman barang
   {
      peminjamanBarang[indexPeminjamanBarang] = namaBarang;
      jumlahPeminjamanBarang[indexPeminjamanBarang] = jumlahStok;
      jumlahHariPeminjamanBarang[indexPeminjamanBarang] = jumlahHari;
      
      for (int i = 0; i < barang.length; i++) {
         if (barang[i].equalsIgnoreCase(namaBarang)) { // mencari barang yang dituju
            stokBarang[i] = stokBarang[i] - jumlahStok; // mengurangi stok pada barang
            break;
         }
      }
      
      indexPeminjamanBarang++;
   }
   
   public static void tampilkanPeminjamanBarang() // method/fungsi yang menampilkan data peminjaman barang
   {
      System.out.println("------------------------------------------------------");
      System.out.println("|NO|\tBarang\t\t  |Stok| \t |jumlah(Hari)|");
      System.out.println("------------------------------------------------------");
      
      if (indexPeminjamanBarang == 0) { // mengecek apakah ada barang yang dipinjam atau belum
         System.out.println("Belum ada barang yang dipinjam");
         
      } else {
         for (int i = 0; i < indexPeminjamanBarang; i++) {
            System.out.println((i + 1) + ".\t" + peminjamanBarang[i] + "\t\t   " + jumlahPeminjamanBarang[i] + "\t\t  " + jumlahHariPeminjamanBarang[i] + " hari"); // menampilkan peminjaman 
         }
      }
   }
   
   public static void pengembalianBarang(String namaBarang, int jumlahStok) // method/fungsi yang berfungsi untuk menyimpan data pengembalian barang
   {
      pengembalianBarang[indexPengembalianBarang] = namaBarang;
      jumlahPengembalianBarang[indexPengembalianBarang] = jumlahStok;
      
      for (int i = 0; i < indexPeminjamanBarang; i++) {
         if (pengembalianBarang[i].equalsIgnoreCase(namaBarang)) { // mencari barang yang dituju
            stokBarang[i] = stokBarang[i] + jumlahStok; // menambah/mengembalikan stok pada barang
            jumlahPeminjamanBarang[i] = jumlahPeminjamanBarang[i] - jumlahStok; // mengurangi jumlah peminjaman barang
            break;
         }
      }
      
      indexPengembalianBarang++;
   }
   
   public static void tampilkanPengembalianBarang() // Method/fungsi yang berfungsi untuk menampilkan data pengembalian barang
   {
      System.out.println("-------------------------------");
      System.out.println("|NO|\tBarang\t\t  |Stok|");
      System.out.println("-------------------------------");
      
      if (indexPengembalianBarang == 0) { // mengecek apakah ada barang yang dipinjam atau belum
         System.out.println("Belum ada barang yang dikembalikan");
      } else {
         for (int i = 0; i < indexPengembalianBarang; i++) {
            System.out.println((i + 1) + ".\t" + pengembalianBarang[i] + "\t\t   " + jumlahPengembalianBarang[i]); // menampilkan pengembalian barang
         }
      }
   }
   
   public static void perpanjanganPeminjaman(String namaBarang, int jumlahHari) // method/fungsi yang berfungsi untuk memperpanjang masa peminjaman
   {
      if (indexPeminjamanBarang == 0) { // mengecek apakah ada barang yang dipinjam atau belum
         System.out.println("Belum ada barang yang dipinjam . . .");

      } else {
         for (int i = 0; i < indexPeminjamanBarang; i++) {
            if (peminjamanBarang[i].equalsIgnoreCase(namaBarang)) {
               jumlahHariPeminjamanBarang[i] = jumlahHariPeminjamanBarang[i] + jumlahHari; // memperpajang peminjaman sesuai dengan jumlah hari yang diinputkan
               break;
            }
         }
         System.out.println("Perpanjangan peminjaman sukses . . .");
      }
   }
}
