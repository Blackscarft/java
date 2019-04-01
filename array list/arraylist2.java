package array1d;

import java.util.Scanner;
import java.util.ArrayList;
public class arraylist2 {
    public static void main(String[] args) {
    	arraydata buah = new arraydata();
    	Scanner read =  new Scanner(System.in);

        buah.tambahdata("apel");
        buah.tambahdata("semangka");
        buah.tambahdata("anggur");
        
        int menu;
    	String setbuah = "";
        do {
        	menu = buah.pilihmenu();
        	switch(menu){
        		case 1 :
        			System.out.print("Tambah Data : ");
        			setbuah = read.nextLine();
        			if (!buah.tambahdata(setbuah)) {
                        System.out.println("Gagal Menambah data!");
        			}
        			break;
        		case 2 :
                    System.out.print("Hapus Data : ");
                    setbuah = read.nextLine();
                    if(!buah.hapusdata(setbuah)){
                        System.out.println("Data tidak ditemukan");
                    }
        			break;
        		case 3 :
                    buah.tampildata();
        			break;
                case 4 :
                    System.out.print("Edit Data : ");
                    setbuah = read.nextLine();
                    System.out.print("Data Baru : ");
                    String databaru = read.nextLine();
                    if(!buah.editdata(setbuah,databaru)){
                        System.out.println("Data tidak ditemukan");
                    }
                    break;
                    
        	case 5 :
        		break;
        	}
        }while(menu != 5);
    }

}

class arraydata {
   private ArrayList<String> buah = new ArrayList<String>();
   private int jumlahdata;

   public arraydata() {
		jumlahdata = 0;
	}

	public int pilihmenu(){
	int pilih;
	Scanner read = new Scanner(System.in);

	System.out.println("+-------- > Menu < --------+");
        System.out.println("+ 1. Tambah data           +");
        System.out.println("+ 2. Hapus data            +");
        System.out.println("+ 3. Tampil data           +");
        System.out.println("+ 4. Edit Data             +");
        System.out.println("+ 5. Selesai               +");
        System.out.println("+--------------------------+");
        int pilihan;
        do {
            System.out.print("masukan pilihan : ");
            pilihan = read.nextInt();
        }while(pilihan < 1 || pilihan > 5);
            return pilihan;
	}

	public boolean tambahdata(String tambahbuah) {
		int posisi = -1;
		for (int i = 0; i < jumlahdata ; i++ ){
			if (tambahbuah.compareTo(buah.get(i)) < 0){
				posisi = i;
				break;
			}
        }
			if (posisi == -1){
				buah.add(tambahbuah);
				jumlahdata = jumlahdata + 1;
			} else {
				buah.add(posisi, tambahbuah);
				jumlahdata = jumlahdata + 1;
			}
		return true;
	}

    public boolean hapusdata(String hapusdata){
        int posisi = -1;
        for (int i=0;i < jumlahdata ; i++ ) {
            if(hapusdata.compareTo(buah.get(i)) == 0){
                posisi = i;
                break;
            }
        }
        if (posisi == -1){
            return false;
        }

        buah.remove(posisi);
        jumlahdata = jumlahdata - 1;

        return true;
    }

    public void tampildata(){
        System.out.println("Isi Data : ");
        for (int i=0; i < jumlahdata ;i++ ) {
            System.out.println(" - "+buah.get(i));
        } 
    }

    public boolean editdata(String datalama, String databaru){
       int posisi = -1;
        for (int i=0;i < jumlahdata ; i++ ) {
            if(datalama.compareTo(buah.get(i)) == 0){
                posisi = i;
                break;
            }
        }
        if (posisi == -1){
            return false;
        }

        buah.set(posisi, databaru);
        return true;
    }

}
